package DAL

/**
 * Created by AMoroz on 08/03/14.
 */
trait GenericDal[M,I] {

  def count: Int
  def save(model: M): M
  def delete(model: M): Boolean
  def deleteById(id: I): Boolean
  def findOptionById(id: I): Option[M]
  def findById(id:I): M = findOptionById(id).get
  def list: List[M]
  def page(pageIndex: Int, limit: Int): List[M]
}
