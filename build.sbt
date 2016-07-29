name := "lift-newrelic"

version := "1.1.3-SNAPSHOT"

organization := "me.frmr.newrelic"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.9.1", "2.9.2", "2.10.4", "2.11.8")

libraryDependencies ++= {
  val liftVersion = "2.6.3"
  Seq(
    "net.liftweb"               %% "lift-webkit"      % liftVersion     % "compile",
    "com.newrelic.agent.java"   % "newrelic-api"      % "3.30.+"
  )
}

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

credentials += Credentials(Path.userHome / ".sonatype")

pomExtra :=
<url>https://github.com/farmdawgnation/lift-newrelic</url>
<licenses>
  <license>
    <name>Apache 2</name>
    <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
    <distribution>repo</distribution>
  </license>
</licenses>
<scm>
  <url>https://github.com/farmdawgnation/lift-newrelic.git</url>
  <connection>https://github.com/farmdawgnation/lift-newrelic.git</connection>
</scm>
<developers>
  <developer>
    <id>farmdawgnation</id>
    <name>Matt Farmer</name>
    <email>matt@frmr.me</email>
  </developer>
</developers>
