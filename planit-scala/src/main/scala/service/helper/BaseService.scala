package service.helper

import slick.dbio.NoStream
import slick.sql.{FixedSqlStreamingAction, SqlAction}

import scala.concurrent.Future

import config.DatabaseConfig

trait BaseService extends DatabaseConfig {

  protected implicit def executeFormDb[A](action: SqlAction[A, NoStream, _ <: slick.dbio.Effect]): Future[A] = {
    db.run(action)
  }

  protected implicit def executeReadStreamFormDb[A](action: FixedSqlStreamingAction[Seq[A], A, _ <: slick.dbio.Effect]): Future[Seq[A]] = {
    db.run(action)
  }
}
