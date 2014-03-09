package DAL

/**
 * Created by AMoroz on 08/03/14.
 */

import scala.slick.jdbc.JdbcBackend

class ActiveRecord[M, I](val model: M){

  def save(implicit session: JdbcBackend#Session): M =
    daoProvider(session).save(model)

}
