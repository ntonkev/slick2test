package DALTables
// AUTO-GENERATED Slick data model
/** Stand-alone Slick data model for immediate use */
object Tables extends {
  val profile = scala.slick.driver.PostgresDriver
} with Tables

/** Slick data model trait for extension, choice of backend or usage in the cake pattern. (Make sure to initialize this late.) */
trait Tables {
  val profile: scala.slick.driver.JdbcProfile
  import profile.simple._
  import scala.slick.model.ForeignKeyAction
  // NOTE: GetResult mappers for plain SQL are only generated for tables where Slick knows how to map the types of all columns.
  import scala.slick.jdbc.{GetResult => GR}
  
  /** DDL for all tables. Call .create to execute. */
  lazy val ddl = Application.ddl ++ Entity.ddl ++ Role.ddl ++ Systemstatus.ddl ++ Transaction.ddl ++ User.ddl ++ Userinrole.ddl
  
  /** Entity class storing rows of table Application
   *  @param applicationid Database column applicationid PrimaryKey
   *  @param applicationname Database column applicationname 
   *  @param loweredapplicationname Database column loweredapplicationname 
   *  @param description Database column description 
   *  @param transactionid Database column transactionid  */
  case class ApplicationRow(applicationid: String, applicationname: String, loweredapplicationname: String, description: Option[String], transactionid: Option[Int])
  /** GetResult implicit for fetching ApplicationRow objects using plain SQL queries */
  implicit def GetResultApplicationRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[ApplicationRow] = GR{
    prs => import prs._
    ApplicationRow.tupled((<<[String], <<[String], <<[String], <<?[String], <<?[Int]))
  }
  /** Table description of table application. Objects of this class serve as prototypes for rows in queries. */
  class Application(tag: Tag) extends Table[ApplicationRow](tag, Some("auth"), "application") {
    def * = (applicationid, applicationname, loweredapplicationname, description, transactionid) <> (ApplicationRow.tupled, ApplicationRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (applicationid.?, applicationname.?, loweredapplicationname.?, description, transactionid).shaped.<>({r=>import r._; _1.map(_=> ApplicationRow.tupled((_1.get, _2.get, _3.get, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column applicationid PrimaryKey */
    val applicationid: Column[String] = column[String]("applicationid", O.PrimaryKey)
    /** Database column applicationname  */
    val applicationname: Column[String] = column[String]("applicationname")
    /** Database column loweredapplicationname  */
    val loweredapplicationname: Column[String] = column[String]("loweredapplicationname")
    /** Database column description  */
    val description: Column[Option[String]] = column[Option[String]]("description")
    /** Database column transactionid  */
    val transactionid: Column[Option[Int]] = column[Option[Int]]("transactionid")
  }
  /** Collection-like TableQuery object for table Application */
  lazy val Application = new TableQuery(tag => new Application(tag))
  
  /** Entity class storing rows of table Entity
   *  @param entityid Database column entityid PrimaryKey
   *  @param name Database column name 
   *  @param description Database column description  */
  case class EntityRow(entityid: Int, name: String, description: Option[String])
  /** GetResult implicit for fetching EntityRow objects using plain SQL queries */
  implicit def GetResultEntityRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]]): GR[EntityRow] = GR{
    prs => import prs._
    EntityRow.tupled((<<[Int], <<[String], <<?[String]))
  }
  /** Table description of table entity. Objects of this class serve as prototypes for rows in queries. */
  class Entity(tag: Tag) extends Table[EntityRow](tag, Some("dict"), "entity") {
    def * = (entityid, name, description) <> (EntityRow.tupled, EntityRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (entityid.?, name.?, description).shaped.<>({r=>import r._; _1.map(_=> EntityRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column entityid PrimaryKey */
    val entityid: Column[Int] = column[Int]("entityid", O.PrimaryKey)
    /** Database column name  */
    val name: Column[String] = column[String]("name")
    /** Database column description  */
    val description: Column[Option[String]] = column[Option[String]]("description")
  }
  /** Collection-like TableQuery object for table Entity */
  lazy val Entity = new TableQuery(tag => new Entity(tag))
  
  /** Entity class storing rows of table Role
   *  @param roleid Database column roleid PrimaryKey
   *  @param rolename Database column rolename 
   *  @param roledescription Database column roledescription 
   *  @param transactionid Database column transactionid 
   *  @param systemstatusid Database column systemstatusid  */
  case class RoleRow(roleid: String, rolename: String, roledescription: Option[String], transactionid: Option[Int], systemstatusid: Option[Int])
  /** GetResult implicit for fetching RoleRow objects using plain SQL queries */
  implicit def GetResultRoleRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Int]]): GR[RoleRow] = GR{
    prs => import prs._
    RoleRow.tupled((<<[String], <<[String], <<?[String], <<?[Int], <<?[Int]))
  }
  /** Table description of table role. Objects of this class serve as prototypes for rows in queries. */
  class Role(tag: Tag) extends Table[RoleRow](tag, Some("auth"), "role") {
    def * = (roleid, rolename, roledescription, transactionid, systemstatusid) <> (RoleRow.tupled, RoleRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (roleid.?, rolename.?, roledescription, transactionid, systemstatusid).shaped.<>({r=>import r._; _1.map(_=> RoleRow.tupled((_1.get, _2.get, _3, _4, _5)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column roleid PrimaryKey */
    val roleid: Column[String] = column[String]("roleid", O.PrimaryKey)
    /** Database column rolename  */
    val rolename: Column[String] = column[String]("rolename")
    /** Database column roledescription  */
    val roledescription: Column[Option[String]] = column[Option[String]]("roledescription")
    /** Database column transactionid  */
    val transactionid: Column[Option[Int]] = column[Option[Int]]("transactionid")
    /** Database column systemstatusid  */
    val systemstatusid: Column[Option[Int]] = column[Option[Int]]("systemstatusid")
  }
  /** Collection-like TableQuery object for table Role */
  lazy val Role = new TableQuery(tag => new Role(tag))
  
  /** Entity class storing rows of table Systemstatus
   *  @param systemstatusid Database column systemstatusid PrimaryKey
   *  @param name Database column name 
   *  @param description Database column description  */
  case class SystemstatusRow(systemstatusid: Int, name: String, description: Option[String])
  /** GetResult implicit for fetching SystemstatusRow objects using plain SQL queries */
  implicit def GetResultSystemstatusRow(implicit e0: GR[Int], e1: GR[String], e2: GR[Option[String]]): GR[SystemstatusRow] = GR{
    prs => import prs._
    SystemstatusRow.tupled((<<[Int], <<[String], <<?[String]))
  }
  /** Table description of table systemstatus. Objects of this class serve as prototypes for rows in queries. */
  class Systemstatus(tag: Tag) extends Table[SystemstatusRow](tag, Some("dict"), "systemstatus") {
    def * = (systemstatusid, name, description) <> (SystemstatusRow.tupled, SystemstatusRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (systemstatusid.?, name.?, description).shaped.<>({r=>import r._; _1.map(_=> SystemstatusRow.tupled((_1.get, _2.get, _3)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column systemstatusid PrimaryKey */
    val systemstatusid: Column[Int] = column[Int]("systemstatusid", O.PrimaryKey)
    /** Database column name  */
    val name: Column[String] = column[String]("name")
    /** Database column description  */
    val description: Column[Option[String]] = column[Option[String]]("description")
  }
  /** Collection-like TableQuery object for table Systemstatus */
  lazy val Systemstatus = new TableQuery(tag => new Systemstatus(tag))
  
  /** Entity class storing rows of table Transaction
   *  @param transactionid Database column transactionid AutoInc, PrimaryKey
   *  @param userid Database column userid 
   *  @param applicationid Database column applicationid 
   *  @param createdon Database column createdon  */
  case class TransactionRow(transactionid: Int, userid: String, applicationid: String, createdon: java.sql.Timestamp)
  /** GetResult implicit for fetching TransactionRow objects using plain SQL queries */
  implicit def GetResultTransactionRow(implicit e0: GR[Int], e1: GR[String], e2: GR[java.sql.Timestamp]): GR[TransactionRow] = GR{
    prs => import prs._
    TransactionRow.tupled((<<[Int], <<[String], <<[String], <<[java.sql.Timestamp]))
  }
  /** Table description of table transaction. Objects of this class serve as prototypes for rows in queries. */
  class Transaction(tag: Tag) extends Table[TransactionRow](tag, Some("main"), "transaction") {
    def * = (transactionid, userid, applicationid, createdon) <> (TransactionRow.tupled, TransactionRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (transactionid.?, userid.?, applicationid.?, createdon.?).shaped.<>({r=>import r._; _1.map(_=> TransactionRow.tupled((_1.get, _2.get, _3.get, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column transactionid AutoInc, PrimaryKey */
    val transactionid: Column[Int] = column[Int]("transactionid", O.AutoInc, O.PrimaryKey)
    /** Database column userid  */
    val userid: Column[String] = column[String]("userid")
    /** Database column applicationid  */
    val applicationid: Column[String] = column[String]("applicationid")
    /** Database column createdon  */
    val createdon: Column[java.sql.Timestamp] = column[java.sql.Timestamp]("createdon")
  }
  /** Collection-like TableQuery object for table Transaction */
  lazy val Transaction = new TableQuery(tag => new Transaction(tag))
  
  /** Entity class storing rows of table User
   *  @param userid Database column userid PrimaryKey
   *  @param username Database column username 
   *  @param userpassword Database column userpassword 
   *  @param email Database column email 
   *  @param secretquestion Database column secretquestion 
   *  @param secretanswer Database column secretanswer 
   *  @param transactionid Database column transactionid 
   *  @param systemstatusid Database column systemstatusid  */
  case class UserRow(userid: String, username: String, userpassword: String, email: Option[String], secretquestion: Option[String], secretanswer: Option[String], transactionid: Option[Int], systemstatusid: Int)
  /** GetResult implicit for fetching UserRow objects using plain SQL queries */
  implicit def GetResultUserRow(implicit e0: GR[String], e1: GR[Option[String]], e2: GR[Option[Int]], e3: GR[Int]): GR[UserRow] = GR{
    prs => import prs._
    UserRow.tupled((<<[String], <<[String], <<[String], <<?[String], <<?[String], <<?[String], <<?[Int], <<[Int]))
  }
  /** Table description of table user. Objects of this class serve as prototypes for rows in queries. */
  class User(tag: Tag) extends Table[UserRow](tag, Some("auth"), "user") {
    def * = (userid, username, userpassword, email, secretquestion, secretanswer, transactionid, systemstatusid) <> (UserRow.tupled, UserRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (userid.?, username.?, userpassword.?, email, secretquestion, secretanswer, transactionid, systemstatusid.?).shaped.<>({r=>import r._; _1.map(_=> UserRow.tupled((_1.get, _2.get, _3.get, _4, _5, _6, _7, _8.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column userid PrimaryKey */
    val userid: Column[String] = column[String]("userid", O.PrimaryKey)
    /** Database column username  */
    val username: Column[String] = column[String]("username")
    /** Database column userpassword  */
    val userpassword: Column[String] = column[String]("userpassword")
    /** Database column email  */
    val email: Column[Option[String]] = column[Option[String]]("email")
    /** Database column secretquestion  */
    val secretquestion: Column[Option[String]] = column[Option[String]]("secretquestion")
    /** Database column secretanswer  */
    val secretanswer: Column[Option[String]] = column[Option[String]]("secretanswer")
    /** Database column transactionid  */
    val transactionid: Column[Option[Int]] = column[Option[Int]]("transactionid")
    /** Database column systemstatusid  */
    val systemstatusid: Column[Int] = column[Int]("systemstatusid")
  }
  /** Collection-like TableQuery object for table User */
  lazy val User =  new TableQuery(tag => new User(tag))

  /** Entity class storing rows of table Userinrole
   *  @param userid Database column userid 
   *  @param roleid Database column roleid 
   *  @param transactionid Database column transactionid 
   *  @param systemstatusid Database column systemstatusid  */
  case class UserinroleRow(userid: String, roleid: String, transactionid: Option[Int], systemstatusid: Int)
  /** GetResult implicit for fetching UserinroleRow objects using plain SQL queries */
  implicit def GetResultUserinroleRow(implicit e0: GR[String], e1: GR[Option[Int]], e2: GR[Int]): GR[UserinroleRow] = GR{
    prs => import prs._
    UserinroleRow.tupled((<<[String], <<[String], <<?[Int], <<[Int]))
  }
  /** Table description of table userinrole. Objects of this class serve as prototypes for rows in queries. */
  class Userinrole(tag: Tag) extends Table[UserinroleRow](tag, Some("auth"), "userinrole") {
    def * = (userid, roleid, transactionid, systemstatusid) <> (UserinroleRow.tupled, UserinroleRow.unapply)
    /** Maps whole row to an option. Useful for outer joins. */
    def ? = (userid.?, roleid.?, transactionid, systemstatusid.?).shaped.<>({r=>import r._; _1.map(_=> UserinroleRow.tupled((_1.get, _2.get, _3, _4.get)))}, (_:Any) =>  throw new Exception("Inserting into ? projection not supported."))
    
    /** Database column userid  */
    val userid: Column[String] = column[String]("userid")
    /** Database column roleid  */
    val roleid: Column[String] = column[String]("roleid")
    /** Database column transactionid  */
    val transactionid: Column[Option[Int]] = column[Option[Int]]("transactionid")
    /** Database column systemstatusid  */
    val systemstatusid: Column[Int] = column[Int]("systemstatusid")
    
    /** Primary key of Userinrole (database name userinrole_pkey) */
    val pk = primaryKey("userinrole_pkey", (userid, roleid))
    
    /** Foreign key referencing Role (database name fk_auth_user_roleid) */
    lazy val roleFk = foreignKey("fk_auth_user_roleid", roleid, Role)(r => r.roleid, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Cascade)
    /** Foreign key referencing User (database name fk_auth_user_userid) */
    lazy val userFk = foreignKey("fk_auth_user_userid", userid, User)(r => r.userid, onUpdate=ForeignKeyAction.Cascade, onDelete=ForeignKeyAction.Cascade)
  }
  /** Collection-like TableQuery object for table Userinrole */
  lazy val Userinrole = new TableQuery(tag => new Userinrole(tag))
}