package DAL

/**
 * Created by AMoroz on 21/02/14.
 */

import DALTables._
import play.api.db.slick.Config.driver.simple._
import scala.slick.lifted.TableQuery
import DALTables.Tables._
import java.util.UUID

/*
class User extends Tables with GenericTableUUID[User,UserRow]{
  override val profile = scala.slick.driver.PostgresDriver
  override val tableQuery = TableQuery[User]
}

class Role extends Tables with GenericTableUUID[Role,RoleRow] {
  val profile = scala.slick.driver.PostgresDriver
  val tableQuery = TableQuery[Role]
}

class UserInRole extends Tables with GenericTableInt[UserInRole, UserinroleRow] {
  val profile = scala.slick.driver.PostgresDriver
  val tableQuery = TableQuery[Userinrole]
}
*/

class User extends Tables {
  val profile = scala.slick.driver.PostgresDriver
//  override val User =  TableQuery[User]

  def insert(user: UserRow)(implicit s: Session){
    User.insert(user)
  }
/*
  def update(id: UUID, user: UserRow)(implicit s: Session){
    User.where(_.userid === id).update(user)
  }

  def findById(id: UUID)(implicit s:Session){
    User.where(_.userid === id).firstOption()
  }
*/
  def findByName(name: String)(implicit s: Session){
    User.where(_.username like name).list()
  }
}