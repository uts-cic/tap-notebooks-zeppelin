case class DisplayPhrase(text:String,style:String)
case class DisplaySection(text:String,phrases:List[DisplayPhrase])
case class DisplayDoc(title:String,sections:List[DisplaySection])

val sections = List(
  DisplaySection("A sentence to test the angular display system.",List(DisplayPhrase("angular display","important"),DisplayPhrase("test","keyword"))),
  DisplaySection("This would be another section. Sections can have more than one sentence.",List(DisplayPhrase("section","keyword"),DisplayPhrase("sentence","keyword"),DisplayPhrase("more than one","important")))
)

val doc = DisplayDoc("My Title",sections)


def markupSection(phrases:List[DisplayPhrase],markedUp:String=""):String = {
  if (phrases.isEmpty) markedUp
  else {
    val p = phrases.head
    val newMarkedUp = markedUp.replace(p.text,s"""<span class="${p.style}">${p.text}</span>""")
    markupSection(phrases.tail,newMarkedUp)
  }
}

def markup(doc:DisplayDoc) = {
  println(s"%angular <h3>${doc.title}</h3>")
  doc.sections.map( s => markupSection(s.phrases,s.text)).foreach { sec =>
      println(s"<p>$sec<p>")
  }
}

markup(doc)

