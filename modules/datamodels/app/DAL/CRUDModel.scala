package DAL

/**
 * Created by AMoroz on 21/02/14.
 */
import scala.slick.jdbc._
import scala.slick.lifted.TableQuery
import play.api.db.slick.Config.driver.simple._
import java.util.UUID
import scala.slick.driver.JdbcProfile

abstract class TableIntId[T](tag: Tag, name: String) extends Table[T](tag, name) {
  def id = column[Int]("id", O.PrimaryKey)
}

abstract class TableStringId[T](tag: Tag, name: String) extends Table[T](tag, name) {
  def id = column[String]("id", O.PrimaryKey)
}


trait GenericTableInt[T <: TableIntId[A], A]{

//  val tableQuery: TableQuery[T]
  val tableQuery: TableQuery[T]

  def getNextId(seqName: String)(implicit session: Session) =
    (StaticQuery[Int] + "select nextval('" + seqName + "_seq') ").first

  def findById(id: Int)(implicit session: Session): Option[A] = {
    val byId = tableQuery.findBy(_.id)
    byId(id).list.headOption
  }

  def insert(entity: A)(implicit session: Session) = {
    tableQuery.insert(entity)
  }

  def delete(id: Int)(implicit session: Session): Boolean =
    findById(id) match {
      case Some(e) => { tableQuery.where(_.id === id).delete; true }
      case None => false
    }

  def update(id: Int, entity: A)(implicit session: Session): Boolean = {
    findById(id) match {
      case Some(e) => { tableQuery.where(_.id === id).update(entity); true }
      case None => false
    }
  }
}

trait GenericTableString[T <: TableStringId[A], A] {

  val tableQuery: TableQuery[T]

  def findById(id: String)(implicit session: Session): Option[A] = {
    val byId = tableQuery.findBy(_.id)
    byId(id).list.headOption
  }

  def insert(entity: A)(implicit session: Session) = {
    tableQuery.insert(entity)
  }

  def delete(id: String)(implicit session: Session): Boolean =
    findById(id) match {
      case Some(e) => { tableQuery.where(_.id === id).delete; true }
      case None => false
    }

  def update(id: String, entity: A)(implicit session: Session): Boolean = {
    findById(id) match {
      case Some(e) => { tableQuery.where(_.id === id).update(entity); true }
      case None => false
    }
  }
}