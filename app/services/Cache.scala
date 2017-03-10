package services

import model.UserData


trait Cache {

  def addUser(user: UserData): String

  def userData(username: String): Option[UserData]

  def check(name: String): Boolean
}
