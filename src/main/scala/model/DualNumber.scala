package model

case class DualNumber(a: Double = 0d, b: Double = 0d)
    extends DualNumberAddOps
    with DualNumberSubOps
    with DualNumberMulOps
    with DualNumberDivOps {

  def + : DualNumber = this

  def - : DualNumber = DualNumber(-a, -b)

  def ++ : DualNumber = DualNumber(a + 1, b)

  def -- : DualNumber = DualNumber(a - 1, b)

  def +=(rhs: DualNumber): DualNumber =
    DualNumber(a + rhs.a, b + rhs.b)

  def +=(rhs: Double): DualNumber = this.copy(a = this.a + rhs)

  def -=(rhs: DualNumber): DualNumber =
    DualNumber(a - rhs.a, b - rhs.b)

  def -=(rhs: Double): DualNumber = this.copy(a = this.a - rhs)

  def *=(rhs: DualNumber): DualNumber = {
    val _b = {
      var ret = this.b * rhs.a
      ret = ret + (this.a * rhs.b)
      ret = ret * rhs.a
      ret
    }
    val _a = this.a * rhs.a
    DualNumber(_a, _b)
  }

  def *=(rhs: Double): DualNumber =
    DualNumber(a * rhs, b * rhs)

  def /=(rhs: DualNumber): DualNumber = {
    val _b = {
      var ret = this.b * rhs.a
      ret = ret - (this.a * rhs.b)
      ret = ret / (rhs.a * rhs.a)
      ret
    }
    val _a = this.a / rhs.a
    DualNumber(_a, _b)
  }

  def /=(rhs: Double): DualNumber =
    DualNumber(a / rhs, b / rhs)

  def inverse(): DualNumber = {
    assert(a != 0d)
    val _a = 1d / a
    val _b = b / -(a * a)
    DualNumber(_a, _b)
  }

  def conjugate(): DualNumber = this.copy(b = -b)

  override def toString: String = s"${a}+${b}ε"

}

object DualNumber {

  // zero identity
  def zero(): DualNumber = DualNumber()

  def additiveIdentity(): DualNumber = zero()

  def multiplicativeIdentity(): DualNumber = zero()

  implicit def orderingDefinition: Ordering[DualNumber] =
    Ordering.by(e => (e.a, e.b))

  // to enable operations from Double to DualNumber
  implicit class DoubleOperations(val source: Double) extends AnyVal {
    def +(rhs: DualNumber): DualNumber = rhs += source
    def -(rhs: DualNumber): DualNumber = rhs -= source
    def *(rhs: DualNumber): DualNumber = rhs *= source
    def /(rhs: DualNumber): DualNumber = rhs /= source
  }
}
