
  val commonSettings = Seq(
    scalaVersion := "2.11.8",
    organization := "com.cosomojo.akka-http-scalajs",
    version := "0.1.0-SNAPSHOT",
    scalacOptions ++= Seq(
      "-deprecation",
      "-unchecked",
      "-feature",
      "-encoding", "utf8"
    )
  )

// ui is js
// model is crosscompiled
// server is jvm
// db is jvm

lazy val server = (project in file("server"))
    .settings( name := "server" )
    .settings(commonSettings: _*)
    .settings( 
      libraryDependencies ++= Settings.serverDeps.value,
      libraryDependencies ++= Settings.sharedDeps.value
    )
    .dependsOn(db, modelJVM)


lazy val db = (project in file("db"))
    .settings( name := "db" )
    .settings(commonSettings: _*)
    .settings( 
      libraryDependencies ++= Settings.dbDeps.value,
      libraryDependencies ++= Settings.sharedDeps.value
    )
     

// FIXME enable scala js. cross compile
lazy val model = (crossProject.crossType(CrossType.Pure) in file("model"))
    .settings( name := "model" )
    .settings(commonSettings: _*)
    .settings( 
      libraryDependencies ++= Settings.sharedDeps.value
    )
    .enablePlugins(ScalaJSPlugin)

lazy val modelJS  = model.js
lazy val modelJVM = model.jvm

// FIXME enable scala js. pure scala js
lazy val ui = (project in file("ui"))
    .settings( name := "ui" )
    .settings(commonSettings: _*)
    .settings( 
      libraryDependencies ++= Settings.sharedDeps.value,
      libraryDependencies ++= Settings.jsDeps.value
    )
    .enablePlugins(ScalaJSPlugin)
    .dependsOn(modelJS)


