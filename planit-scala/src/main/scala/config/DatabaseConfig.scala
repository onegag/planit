package config
import slick.jdbc.PostgresProfile.api._

trait DatabaseConfig extends Config {
  lazy val db: Database = Database.forConfig("database")
  implicit val session: Session = db.createSession()
}
