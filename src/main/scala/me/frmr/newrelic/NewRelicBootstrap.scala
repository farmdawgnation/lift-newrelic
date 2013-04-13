package me.frmr.newrelic

import net.liftweb._
  import common._
  import http._
  import sitemap._
    import Loc._

import com.newrelic.api.agent._

/**
 * This is the helper for NewRelic transaction naming via SiteMap.
 *
 * This helper will append rules to earlyInStateful and earlyInStateless
 * that retrieve the matched loc out of the current SiteMap, and then
 * set the NewRelic transaction na,e for this request based on the URL
 * of the Loc that the current request matches.
 *
 * So, if you create a Menu like so...
 *
 * {{{
 * val someMenu = Menu.i("my-menu") / "something" / "awesome"
 * }}}
 *
 * It would register in NewRelic as "/something/awesome". Additionally, if
 * you used a parameterized menu... say, like so...
 *
 * {{{
 * val editMenu = Menu.param[Thing]("Edit Thing", Text("Edit Thinkg"), Thing.find(_), _._id.toString) /
 *   "things" / * / "edit"
 * }}}
 *
 * It would register in NewRelic as "/things/star/edit". Also, comet requests
 * ajax requests will be registered as /comet_request and /ajax_request.
**/
object NewRelicTransactionNaming {
  protected def nameTransaction(req: Box[Req]) {
    for (req <- req) {
      LiftRules.siteMap.flatMap(_.findLoc(req)).map { matchedLoc =>
        val transactionName = "/" + matchedLoc.link.uriList.mkString("/")
        NewRelic.setTransactionName("SiteMap", transactionName)
      } openOr {
        if (req.uri.startsWith("/comet_request")) {
          NewRelic.setTransactionName("AJAX", "/comet_request")
        } else if (req.uri.startsWith("/ajax_request")) {
          NewRelic.setTransactionName("AJAX", "/ajax_request")
        }
      }
    }
  }

  /**
   * Add the transaction naming handlers to LiftRules.
  **/
  def setup = {
    LiftRules.earlyInStateful.append(nameTransaction)
    LiftRules.earlyInStateless.append(nameTransaction)
  }
}
