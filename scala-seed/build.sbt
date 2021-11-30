import Dependencies._

ThisBuild / scalaVersion     := "2.13.6"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "com.example"
ThisBuild / organizationName := "example"

val AkkaVersion = "2.6.17"
val AkkaHttpVersion = "10.2.7"
val sttpVersion = "3.3.17"
val circeVersion = "0.14.1"

lazy val root = (project in file("."))
  .settings(
    name := "scala-seed",
    libraryDependencies += scalaTest % Test,
    libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
    libraryDependencies += "com.typesafe.akka" %% "akka-stream-typed" % AkkaVersion,
    libraryDependencies += "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
    libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "1.3.8",
    libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.13",
    libraryDependencies += "net.liftweb" %% "lift-json" % "3.5.0"
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
