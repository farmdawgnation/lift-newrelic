# Smart NewRelic Transaction Naming for Lift

Have you ever wanted to join the ranks of those who use the premium service called NewRelic for keeping tabs on your
application? That's **great!** But wait! you're using Lift and Scala. Which isn't supported by NewRelic by default.
But now **YOU**, yes, **YOU** can enjoy the benefits of monitoring your Lift app from NewRelic with the *brand
spanking new lean über web 3.0* Lift add-on from **MATT FARMER ENTERPRISES**.

If you want to be among the **lucky individuals** who are able to monitor their Lift apps with NewRelic, all you
have to do is follow these simple steps.

First, add the following line to your library dependencies:

```scala
"me.frmr.newrelic"   %% "lift-newrelic"   % "1.1.6"
```

Then, add the following line somewhere in your Lift Apps Boot.scala:

```scala
NewRelicTransactionNaming.setup
```

Then just start up your JVM with the javaagent flag, as outlined in
[NewRelic's own documentation](https://newrelic.com/docs/java/java-agent-installation). And then YOU will be
among the great, the few, who monitor their Lift apps with NewRelic and actually understand what URLs are
consuming time.

## How does it work?

This add-on relies on SiteMap, so if you're not using SiteMap in your Lift app, you should be. When a new request comes
in, the NewRelicTransactionNaming code finds the Loc instance that matches the request, and sets the transaction name
to that value. So, if a Loc is associated with the URL `/amnesia` you'll see `/amnesia` in your NewRelic transactions.
If the Loc is parameterized, and is associated with something like `/resource/*/edit` you'll see `/resource/star/edit`
for that transaction in your NewRelic Web Transactions list.

For now, APIs using RestHelper will need to manually set their transaction name, since there's no good way to do that
auto-magically yet.

## About Me

My name is Matt Farmer. By night, I'm a committer and evangelist for the [Lift Framework](http://github.com/lift/framework)
and I enjoy beer and open source software. You can find me [on Twitter](https://twitter.com/farmdawgnation)
and on [my blog](https://farmdawgnation.com).
