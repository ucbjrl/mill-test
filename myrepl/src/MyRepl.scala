// See LICENSE for license details.

package myrepl

import scala.tools.jline.console.ConsoleReader
import scala.tools.jline.console.completer._
import collection.JavaConverters._
import scala.tools.jline.{Terminal, TerminalFactory}

import scala.collection.mutable.ArrayBuffer

object MyRepl {
  def main(args: Array[String]): Unit = {
    val terminal: Terminal = TerminalFactory.create()
    val console = new ConsoleReader

    val completer = new ArgumentCompleter(
      new StringsCompleter(ArrayBuffer("one", "two", "three").asJava),
      new FileNameCompleter()
    )

    console.setCompletionHandler(new CandidateListCompletionHandler {})

    console.addCompleter(completer)
    console.setPrompt(">>> ")


    try {
      var command: String = ""
      while (!command.startsWith("quit")) {
        command = console.readLine()
        if (command == null) command = "quit"
        println(s"Got: $command")
      }
    }
    catch {
      case t: Throwable =>
        println(s"oops: $t")
    }
    console.shutdown()
    terminal.restore()
  }
}

/**
  * Require sbt file
  *
  * name := "ReplProblem"
  *
  * version := "0.1"
  *
  * scalaVersion := "2.12.6"
  *
  * libraryDependencies ++= Seq(
  * "org.scala-lang.modules" % "scala-jline" % "2.12.1"
  * )
  */
