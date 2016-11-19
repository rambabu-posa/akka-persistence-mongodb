//------------------------------------
// Setup scalastyle for sbt
// Invocation: sbt scalastyleGenerateConfig && sbt scalastyle
// See: https://github.com/scalastyle/scalastyle-sbt-plugin
//------------------------------------

val containsMessage = taskKey[Boolean]("contains message")

containsMessage := {
  val search = "File length exceeds"
  val filename = "target/scalastyle-result.xml"
  val lines = sbt.IO.readLines(file(filename))
  val contains = lines.find(s => s.contains(search)).isDefined
  if (!contains) {
    sys.error("Could not find " + search + " in " + filename)
  }
  contains
}