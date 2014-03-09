package DAL

/**
 * Created by AMoroz on 21/02/14.
 */

import DALTables._
import play.api.db.slick.Config.driver.simple._
import scala.slick.lifted.TableQuery
import DALTables.Tables._
import java.util.UUID
import play.api.db.DB
import scala.slick.driver.JdbcProfile
import play.api.db.slick.Profile
import scala.slick.lifted._

/*

class User extends Tables with GenericTableString[User,UserRow]{
  val profile = scala.slick.driver.PostgresDriver
  val tableQuery = TableQuery[User]
}

class Role extends Tables with GenericTableString[Role,RoleRow] {
  override val profile = scala.slick.driver.PostgresDriver
  override val tableQuery = TableQuery[Role]
}

class UserInRole extends Tables with GenericTableInt[UserInRole, UserinroleRow] {
  override val profile = scala.slick.driver.PostgresDriver
  override val tableQuery = TableQuery[Userinrole]
}
*/



class DAL extends Tables{
  val profile = scala.slick.driver.PostgresDriver

    def insert(user: UserRow)(implicit s: Session){
      User.insert(user)
    }

    def update(id: UUID, user: UserRow)(implicit s: Session){
      User.where(_.userid === id.toString()).update(user)
    }
    /*
      def delete(id: UUID)(implicit s: Session){
        findById(id) match {
          case Some(User) => {User.where(_.userid === id.toString()).delete; true}
          case None => false
        }
      }
    */
    def findById(id: UUID)(implicit s:Session){
      User.where(_.userid === id.toString()).firstOption()
    }

    def findByName(name: String)(implicit s: Session){
      User.where(_.username like name).list()
    }

}
