name := "planit"

version := "1.0"

scalaVersion := "2.12.11"

libraryDependencies ++= {
  val akkaVersion = "2.6.4"
  val akkaHttpVersion = "10.1.11"
  val scalaTestVersion = "3.0.1"
  val scalaMockV = "3.5.0"
  val slickVersion = "3.3.2"
  Seq(
    "org.scala-lang" % "scala-library" % "2.12.11",
    "com.typesafe.akka"  %% "akka-actor"                  % akkaVersion,
    "com.typesafe.akka"  %% "akka-stream"                 % akkaVersion,

    "com.typesafe.akka"  %% "akka-http"                   % akkaHttpVersion,
    "com.typesafe.akka"  %% "akka-http-core"              % akkaHttpVersion,
    "com.typesafe.akka"  %% "akka-http-spray-json"        % akkaHttpVersion,
    "ch.megard" %% "akka-http-cors" % "0.4.2",

    "com.typesafe.slick" %% "slick"                       % slickVersion,
    "com.typesafe.slick" %% "slick-hikaricp"              % slickVersion,
    "org.slf4j"           % "slf4j-nop"                   % "1.7.25",
    "org.postgresql"      % "postgresql"                  % "42.1.4",
    "org.flywaydb"        % "flyway-core"                 % "3.2.1",


  )
}