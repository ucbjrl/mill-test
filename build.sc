import mill._
import mill.scalalib._
import ammonite.ops._

object myrepl extends ScalaModule {
  def publishVersion = "0.1"
  def scalaVersion = "2.12.6"
  def ivyDeps = Agg(
    ivy"org.jline:jline:3.6.2",
    ivy"org.jline:jline-terminal-jna:3.6.2"
  )
}
