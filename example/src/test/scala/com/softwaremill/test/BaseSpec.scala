package com.softwaremill.test

import com.softwaremill.common.RealTimeClock
import com.softwaremill.common.id.IdGenerator
import org.scalatest.time.{Millis, Span}
import org.scalatest.{Matchers, FlatSpec}
import org.scalatest.concurrent.ScalaFutures

trait BaseSpec extends FlatSpec with Matchers with ScalaFutures with TestImplicits {
  implicit val patience = PatienceConfig(timeout = Span(1000, Millis))
}

trait TestImplicits {
  implicit lazy val idGenerator = new IdGenerator()
  implicit lazy val clock = RealTimeClock
  implicit lazy val ec = scala.concurrent.ExecutionContext.Implicits.global
}