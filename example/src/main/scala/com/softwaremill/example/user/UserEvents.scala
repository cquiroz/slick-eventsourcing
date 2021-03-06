package com.softwaremill.example.user

import com.softwaremill.events.{HandleContextTransform, HandleContext, PartialEventWithId, AggregateForEvent}

case class UserRegistered(
    login: String,
    email: String,
    encryptedPassword: String,
    salt: String
) extends HandleContextTransform[User] {
  override def apply(e: PartialEventWithId[User, _], hc: HandleContext) = hc.copy(rawUserId = e.aggregateId)
}

object UserRegistered {
  implicit val afe = AggregateForEvent[UserRegistered, User]
}

case class UserLoggedIn() extends HandleContextTransform[User] {
  override def apply(e: PartialEventWithId[User, _], hc: HandleContext) = hc.copy(rawUserId = e.aggregateId)
}
object UserLoggedIn {
  implicit val afe = AggregateForEvent[UserLoggedIn, User]
}
