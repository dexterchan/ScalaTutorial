name := "Animals"

organization in ThisBuild := "farm"

version in ThisBuild := "1.0.0-SNAPSHOT"

scalaVersion in ThisBuild := "2.13.1"

resolvers += "Sonatype Releases Repository" at "https://oss.sonatype.org/content/repositories/releases"


lazy val animals = project in file("animals")

lazy val animalsRunner = 
  (project in file("animals-runner"))
  /*
    .settings(
      libraryDependencies ++= List(
        "net.liftweb" %% "lift-util" % liftVersion,
        "net.liftweb" %% "lift-json" % liftVersion
      )
    )*/.dependsOn(animals)
