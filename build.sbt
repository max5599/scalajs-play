// shadow sbt-scalajs' crossProject and CrossType until Scala.js 1.0.0 is released
import sbtcrossproject.{crossProject, CrossType}

val sharedSettings = Seq(scalaVersion := "2.12.6")

lazy val scalaJSPlay =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Full)
    .in(file("."))
    .settings(sharedSettings)
    .jsSettings()
    .jvmSettings(
      libraryDependencies ++= Seq(
        "com.typesafe.play" %% "play-akka-http-server" % "2.6.15",
        "com.typesafe.play" %% "play-json" % "2.6.9",
        "ch.qos.logback" % "logback-classic" % "1.2.3",
        "com.typesafe.scala-logging" %% "scala-logging" % "3.9.0"
      )
    )

lazy val scalaJSPlayJS = scalaJSPlay.js
lazy val scalaJSPlayJVM = scalaJSPlay.jvm
