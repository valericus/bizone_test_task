val jacksonVersion = "2.9.4"

lazy val root = (project in file("."))
  .settings(
    name         := "bi_zone",
    organization := "su.creator",
    scalaVersion := "2.11.12",
    version      := "0.1.0",
    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.0.0" % "test"
    )
  )
