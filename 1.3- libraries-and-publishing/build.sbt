name := "Animals"

organization := "farm"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.13.1"

resolvers += "Sonatype Releases Repository" at "https://oss.sonatype.org/content/repositories/releases"

{
  val liftVersion = "3.4.0"

  libraryDependencies ++= List(
    "net.liftweb" %% "lift-util" % liftVersion,
    "net.liftweb" %% "lift-json" % liftVersion
  )
  /*
  libraryDependencies += "net.liftweb" %% "lift-util" % liftVersion
  libraryDependencies += "net.liftweb" %% "lift-json" % liftVersion
  */
}

publishMavenStyle := true

pomExtra := <issueManagement><system>GitHub</system><url>my/url/github</url></issueManagement>

publishTo := Some("Sonatype Releases Repository" at "https://oss.sonatype.org/content/repositories/release")

credentials += Credentials(Path.userHome / ".ivy2" / "credentials")
