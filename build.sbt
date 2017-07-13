name := "lift-newrelic"

version := "1.1.7-SNAPSHOT"

organization := "me.frmr.newrelic"

scalaVersion := "2.12.2"

crossScalaVersions := Seq("2.11.11", "2.12.2")

libraryDependencies ++= {
  val liftVersion = "3.1.0"
  Seq(
    "net.liftweb"               %% "lift-webkit"      % liftVersion     % "compile",
    "com.newrelic.agent.java"   % "newrelic-api"      % "3.40.+"
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
