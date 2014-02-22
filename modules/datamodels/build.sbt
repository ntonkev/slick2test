import sbt._
import Keys._

name := "datamodels"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.postgresql" % "postgresql" % "9.2-1003-jdbc4",
  "com.typesafe.slick" %% "slick" % "2.0.1-RC1",
  "com.typesafe.play" %% "play-slick" % "0.6.0.1"
)

play.Project.playScalaSettings
