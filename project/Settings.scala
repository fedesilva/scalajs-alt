
import sbt._
import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._

object Settings {

  object Versions {
    val cats  = "0.4.1"
    val circe = "0.3.0"
    val autowire = "0.2.5"
    val booPickle = "1.1.2"
    val uTest = "0.3.1"
    val diode = "0.5.0"
    val scalaDom = "0.9.0"
    val scalajsReact = "0.10.4"
    val scalaCSS = "0.3.1"

    val finch = "0.10.0"

  }

  val sharedDeps = Def.setting(Seq(
    "org.typelevel" %%% "cats"            % Versions.cats,
    "com.lihaoyi"   %%% "autowire"        % Versions.autowire,
    "me.chrons"     %%% "boopickle"       % Versions.booPickle,
    "io.circe"      %%% "circe-parser"    % Versions.circe,
    "com.lihaoyi"   %%% "utest"           % Versions.uTest
  ))

  val jsDeps = Def.setting(Seq(
    "com.github.japgolly.scalajs-react" %%% "core" % Versions.scalajsReact,
    "com.github.japgolly.scalajs-react" %%% "extra" % Versions.scalajsReact,
    "com.github.japgolly.scalacss" %%% "ext-react" % Versions.scalaCSS,
    "me.chrons" %%% "diode" % Versions.diode,
    "me.chrons" %%% "diode-react" % Versions.diode,
    "org.scala-js" %%% "scalajs-dom" % Versions.scalaDom      
  ))

  val serverDeps = Def.setting(Seq(
    // akka http
    // or finch
     "com.github.finagle" %% "finch-core"   % Versions.finch,
     "com.github.finagle" %% "finch-circe"  % Versions.finch
  ))

  val dbDeps = Def.setting(Seq(
    "com.typesafe.slick" %% "slick" % "3.1.1",
    "org.postgresql" % "postgresql" % "9.4.1208"
  ))


}

