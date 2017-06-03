val test:Option[Int] = Some(3)


test match {
  case Some(x) => x
  case None => 0
}



