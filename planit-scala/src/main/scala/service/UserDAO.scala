package service

import slick.lifted.TableQuery
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import model._
import service.helper.BaseService


object UserDAO extends BaseService{

  val userTable = TableQuery[UserTable]


  def findAll(): Future[Seq[User]] = userTable.result

  def findById(id: Long): Future[User] = userTable.filter(_.id === id).result.head

  def create (user: User): Future[Long] = userTable returning userTable.map(_.id) += user

  def update(id: Long, user: User): Future[Int] = {
    userTable.filter(_.id === id).map(user =>
      (user.name, user.surname, user.birth_date, user.address))
      .update(user.name,
        user.surname,
        user.birth_date,
        user.address)
  }

  def delete(id: Long): Future[Int] = {
    userTable.filter(_.id === id).delete
  }
}

