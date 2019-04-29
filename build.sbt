lazy val app = project in file(".") enablePlugins (Cinnamon)

cinnamon in run := true

name := "cinnamon-bug"

version := "1.0"

scalaVersion := "2.12.8"

val AkkaHttpVersion = "10.1.8"
val AkkaVersion = "2.5.22"

libraryDependencies ++= Seq(
  Cinnamon.library.cinnamonCHMetrics,
  Cinnamon.library.cinnamonAkkaHttp,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe" % "config" % "1.3.3"
)

cinnamonLogLevel := "INFO"
