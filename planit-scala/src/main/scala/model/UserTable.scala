package model

import slick.jdbc.PostgresProfile.api._


class UserTable(tag: Tag) extends Table[User](tag, "users") {

  def id = column[Long]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def surname = column[String]("surname")
  def birth_date = column[String]("birth_date")
  def address = column[String]("address")

  def * = (id.?, name, surname, birth_date, address) <> ((User.apply _).tupled, User.unapply)
}
