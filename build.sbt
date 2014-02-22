import play.Project._
import sbt._
import Keys._

name := "slick2test"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
)

lazy val datamodels = project.in(file("modules/datamodels"))

lazy val root = project.in( file(".") ).dependsOn(datamodels).aggregate(datamodels)

play.Project.playScalaSettings

