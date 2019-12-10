name := "Animals"

organization in ThisBuild := "farm"

version in ThisBuild := "1.0.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.13.1"

resolvers += "Sonatype Releases Repository" at "https://oss.sonatype.org/content/repositories/releases"

libraryDependencies ++= Seq(
  "net.liftweb" %% "lift-webkit" % "3.4.0"
)
lazy val animals = project in file("animals")

lazy val animalsRunner =
  (project in file("animals-runner"))
    .dependsOn(animals)
