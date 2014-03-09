package DAL

/**
 * Created by AMoroz on 08/03/14.
 */

import scala.languageFeature.implicitConversions
import scala.slick.jdbc.JdbcBackend
import scala.slick.driver.JdbcProfile
//import scala.slick.lifted.Column
import scala.slick.lifted._

trait JdbcDal[M, I] extends GenericDal[M, I] {

  val profile: JdbcProfile

  import profile.simple._

  implicit val session: JdbcBackend#Session

  def query: TableQuery[_ <: Table[M] with GenericTable[I]]

  def extractId(model: M): Option[I]

  def withId(model: M, id: I): M

  def queryById(id: I): Query[Table[M],M]

  def count: Int = query.length.run

  def add(model: M): I =
    query.returning(query.map(_.id)).insert(model)

  def delete(model: M): Boolean =
    extractId(model) match {
      case Some(id) => deleteById(id)
      case None => false
    }

  def deleteById(id: I): Boolean = queryById(id).delete == 1

  def findOptionById(id: I): Option[M] = queryById(id).firstOption

  def list: List[M] = query.list

  def page(pageIndex: Int, limit: Int): List[M] =
    query.drop(pageIndex).take(limit).run.toList

}
