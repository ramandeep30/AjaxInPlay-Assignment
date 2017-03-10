package controllers

import com.google.inject.Inject
import play.api.mvc.{Action, Controller}
import services.CacheListService


class SignInController@Inject()(service:CacheListService) extends Controller{

  def signInForm(userName:String)=Action{ implicit request =>
    val flag:Boolean=service.check(userName)
    if(flag){
    val usedData=service.userData(userName).get
    Ok(views.html.profilePage(usedData))}
    else Ok(views.html.main())
  }

}
