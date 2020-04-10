package controller.helper

import model.User
import spray.json.{DefaultJsonProtocol, RootJsonFormat}

trait JsonMapping extends DefaultJsonProtocol {
  implicit val userFormat: RootJsonFormat[User] = jsonFormat5(User)

}