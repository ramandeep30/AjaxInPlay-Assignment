package services

import model.UserData
import com.google.inject.Inject
import play.api.cache.CacheApi

import scala.collection.mutable.ListBuffer

class CacheListService @Inject()(cache: CacheApi) extends Cache {

  val listOfAccounts = new ListBuffer[UserData]() += UserData(
    "Raman", "ramandeep.kaur@gmail.com", "password", "password", "20/01/1993", "Female")

  val defaultUser = UserData("","","","","","")

  cache.set("Key", listOfAccounts)

  def addUser(user: UserData): String = {
    /*val userWithEncryption = user.copy(password = Encryption.hash(user.password))*/
    val list = cache.get[ListBuffer[UserData]]("Key").map {
      list => list += user
    }.getOrElse(ListBuffer())
    cache.remove("key")
    cache.set("Key", list)
    "success"
  }

  def userData(username: String): Option[UserData] = {
    if (check(username)) {
      val optionList = cache.get[ListBuffer[UserData]]("Key")
      val list = optionList.map {
        identity
      }.getOrElse(ListBuffer())
      val result = list.filter(_.userName == username).headOption
      result
    }
    else {

      None
    }

  }

  def check(name: String): Boolean = {
    val list = cache.get[ListBuffer[UserData]]("Key").map {
      identity
    }.getOrElse(ListBuffer())
    val userList: ListBuffer[UserData] = list.filter(_.userName == name)
    if (userList nonEmpty) true
    else false
  }

}
