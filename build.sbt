name := "linear-algebra"

version := "1.0"

scalaVersion := "2.12.0"

resolvers += "Typesafe" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq(
  "junit" % "junit" % "4.8.1" % "test",
  "org.scalactic" %% "scalactic" % "3.0.0",
  "org.scalatest" %% "scalatest" % "3.0.0" % "test"
)
