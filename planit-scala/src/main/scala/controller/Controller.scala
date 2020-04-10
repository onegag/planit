package controller

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import ch.megard.akka.http.cors.scaladsl.CorsDirectives._

import scala.concurrent.ExecutionContext.Implicits.global
import spray.json._

import controller.helper.{ErrorHandler, JsonMapping}
import model.User
import service.UserDAO


trait Controller extends JsonMapping with ErrorHandler {
  val routes: Route = cors() {
    pathPrefix("users") {
      pathEnd {
        post {
          entity(as[User]) { user =>
            complete(UserDAO.create(user).map(_.toJson))
          }
        } ~
        get {
          complete(UserDAO.findAll().map(_.toJson))
        }
      } ~
      path(Segment) { id_string =>
        val id = id_string.toInt
        delete {
          complete(UserDAO.delete(id).map(_.toJson))
        } ~
          get {
            complete(UserDAO.findById(id).map(_.toJson))
          } ~
          put {
            entity(as[User]) { update =>
              complete(UserDAO.update(id, update).map(_.toJson))
            }
          }
        }
      }
    }
}
