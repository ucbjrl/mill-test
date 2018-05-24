// See LICENSE for license details.

package myrepl

import java.io.Console
import org.jline.terminal._
import org.jline.reader._
import org.jline.reader.impl.completer._
import collection.JavaConverters._
import scala.collection.mutable.ArrayBuffer

object MyRepl {
  def main(args: Array[String]): Unit = {
    System.console() match {
      case c: Console => println("Connected to console.")
      case null => println("stdin or stdout redirected.")
    }
    val terminal: Terminal = TerminalBuilder.terminal()

    val completer = new ArgumentCompleter(
      new StringsCompleter(ArrayBuffer("one", "two", "three").asJava),
      new FileNameCompleter()
    )

    val console = LineReaderBuilder.builder()
                   .terminal(terminal)
                   .completer(completer)
                   .build()

    val prompt = ">>> "

    try {
      var command: String = ""
      while (!command.startsWith("quit")) {
        command = console.readLine(prompt)
        if (command == null) {
          println("Got null - assuming quit.")
          command = "quit"
        }
        println(s"Got: $command")
      }
    }
    catch {
      case t: Throwable =>
        println(s"oops: $t")
    }
    terminal.close()
  }
}
