name := "fp-scala"
version := "v0.1"

lazy val root = (project in file("."))

scalaVersion := "2.12.8"

val scalaTest = "3.0.5"

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % scalaTest,
  "org.scalatest" %% "scalatest" % scalaTest % "test"
)
