# Smart NewRelic Transaction Naming for Lift

Have you ever wanted to join the ranks of those who use the premium service called NewRelic for keeping tabs on your
application? That's **great!** But wait! you're using Lift and Scala. Which isn't supported by NewRelic by default.
But now **YOU**, yes, **YOU** can enjoy the benefits of monitoring your Lift app from NewRelic with the *brand
spanking new lean über web 3.0* Lift add-on from **MATT FARMER ENTERPRISES**.

If you want to be among the **lucky individuals** who are able to monitor their Lift apps with NewRelic, all you
have to do is follow these simple steps.

First, add the following line to your library dependencies:

```scala
"me.frmr.newrelic"   %% "lift-newrelic"   % "1.0.0"
```

Then, add the following line somewhere in your Lift Apps Boot.scala:

```scala
NewRelicTransactionNaming.setup
```

Then just start up your JVM with the javaagent flag, as outlined in
[NewRelic's own documentation](https://newrelic.com/docs/java/java-agent-installation). And then YOU will be
among the great, the few, who monitor their Lift apps with NewRelic and actually understand what URLs are
consuming time.

## About Me

My name is Matt Farmer. By day, I ship code at [Elemica](http://elemica.com). By night, I work on
[Anchor Tab](http://anchortab.com), and making the world a better place for all.
