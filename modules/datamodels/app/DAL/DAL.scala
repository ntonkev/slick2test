package DAL

/**
 * Created by AMoroz on 21/02/14.
 */

import DALTables._
import scala.slick.lifted.TableQuery
import play.api.db.slick.Config.driver.simple._
import java.util.UUID

object DAL extends Tables {
  val profile = scala.slick.driver.PostgresDriver
  /*
  override val User = TableQuery[User]

  def insert(user: UserRow) (implicit s: Session){
    User.insert(user)
  }

    def update(userid: UUID, user: UserRow) (implicit s: Session){
      User.where(_.userid === userid).update(user)
    }

    def delete(userid: UUID) (implicit s: Session){
      User.where(_.userid === userid).delete()
    }
  */
}
