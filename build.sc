import mill._
import mill.scalalib._
import ammonite.ops._

object myrepl extends ScalaModule {
  def publishVersion = "0.1"
  def scalaVersion = "2.12.6"
  def ivyDeps = Agg(ivy"org.scala-lang.modules:scala-jline:2.12.1")
}
