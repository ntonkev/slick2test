package controllers

import play.api._
import play.api.mvc._

object Application extends Controller {

  def index = Action {

    //scala.slick.model.codegen.SourceCodeGenerator.main(Array("scala.slick.driver.PostgresDriver","org.postgresql.Driver","jdbc:postgresql://ec2-54-200-218-97.us-west-2.compute.amazonaws.com/sandbox?user=postgres&password=Password1?","c:\\Dev\\Projects\\slick2test\\modules\\datamodels\\app","DALTables"))

    Ok(views.html.index("Your new application is ready."))
  }

}