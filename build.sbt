// shadow sbt-scalajs' crossProject and CrossType until Scala.js 1.0.0 is released
import sbtcrossproject.{crossProject, CrossType}

val sharedSettings = Seq(scalaVersion := "2.12.6")

lazy val scalaJSPlay =
  crossProject(JSPlatform, JVMPlatform)
    .crossType(CrossType.Full)
    .in(file("."))
    .settings(sharedSettings)
    .jsSettings()
    .jvmSettings()

lazy val scalaJSPlayJS = scalaJSPlay.js
lazy val scalaJSPlayJVM = scalaJSPlay.jvm