package DAL

/**
 * Created by AMoroz on 21/02/14.
 */
import scala.slick.jdbc._
import scala.slick.lifted.TableQuery
import play.api.db.slick.Config.driver.simple._


abstract class TableIntId[T](tag: Tag, name: String) extends Table[T](tag, name) {
  def id = column[Int]("id", O.PrimaryKey)
}

trait GenericTableCRUD[T <: TableIntId[A], A] {

  val tableQuery: TableQuery[T]

  /*
   * To dynamically generate ids for insert, use sequences (they are created when schema is created).
   */
  def getNextId(seqName: String)(implicit session: Session) =
    (StaticQuery[Int] + "select nextval('" + seqName + "_seq') ").first

  /*
   * Find a specific entity by id.
   */
  def findById(id: Int)(implicit session: Session): Option[A] = {
    val byId = tableQuery.findBy(_.id)
    byId(id).list.headOption
  }

  /*
 * Insert an entity
 */
  def insert(entity: A)(implicit session: Session) = {
    tableQuery.insert(entity)
  }

  /*
   * Delete a specific entity by id. If successfully completed return true, else false
   */
  def delete(id: Int)(implicit session: Session): Boolean =
    findById(id) match {
      case Some(e) => { tableQuery.where(_.id === id).delete; true }
      case None => false
    }

  /*
   * Update a specific entity by id. If successfully completed return true, else false
   */
  def update(id: Int, entity: A)(implicit session: Session): Boolean = {
    findById(id) match {
      case Some(e) => { tableQuery.where(_.id === id).update(entity); true }
      case None => false
    }
  }
}