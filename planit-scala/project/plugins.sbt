logLevel := Level.Warn

resolvers += Classpaths.sbtPluginReleases

addSbtPlugin("io.spray" %% "sbt-revolver" % "0.9.1")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.9")