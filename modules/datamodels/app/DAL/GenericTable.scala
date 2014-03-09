package DAL

/**
 * Created by AMoroz on 08/03/14.
 */

import scala.slick.lifted.Column

trait GenericTable[I] {
  def id: Column[I]
}
