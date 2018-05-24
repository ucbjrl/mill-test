lazy val myrepl = (project in file("myrepl")).settings(
  name := "ReplProblem",
  version := "0.1",
  scalaVersion := "2.12.6",
  libraryDependencies ++= Seq(
    "org.jline" % "jline" % "3.6.2",
    "org.jline" % "jline-terminal-jna" % "3.6.2"
  )
)
