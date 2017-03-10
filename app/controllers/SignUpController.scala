package controllers

import _root_.model.UserData
import com.google.inject.Inject
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._
import services.CacheListService


class SignUpController @Inject()(service:CacheListService) extends Controller {

  def addAccount(fullName: String, userName: String,
                 password: String, confirmPassword: String, dateOfBirth: String, gender: String) = {
    Action { implicit request =>

      val userData = UserData(fullName, userName, password, confirmPassword, dateOfBirth, gender)
      if (!service.check(userData.userName)) {
        service.addUser(userData)
        Ok(views.html.profilePage(userData))
      }
      else {
        Ok(views.html.formSignUp())
      }
    }

  }
}
