package controllers

import play.api._
import play.api.Play.current
import play.api.mvc._
import play.api.Logger
import play.api.db.slick.Config.driver.simple._
import DALTables._
import DAL._
import play.api.db.DB

object DAL1 extends Tables{
  val profile = scala.slick.driver.PostgresDriver
}

object Application extends Controller {

  lazy val database = Database.forDataSource(DB.getDataSource())

  def index = Action {

    val users = new DAL().User
    val query = for (u <- users) yield u.username

    val result = database.withSession{
      session => query.list() (session)
    }



    Logger.debug(result(0).toString)
    //scala.slick.model.codegen.SourceCodeGenerator.main(Array("scala.slick.driver.PostgresDriver","org.postgresql.Driver","jdbc:postgresql://ec2-54-200-218-97.us-west-2.compute.amazonaws.com/sandbox?user=postgres&password=Password1?","c:\\Dev\\Projects\\slick2test\\modules\\datamodels\\app","DALTables"))
    Ok(views.html.index("Your new application is ready."))
  }
}