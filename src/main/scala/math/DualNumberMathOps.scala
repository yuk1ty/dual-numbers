package math

import model.DualNumber

trait DualNumberMathOps {
  def sin(x: DualNumber): DualNumber =
    DualNumber(Math.sin(x.a), x.b * Math.cos(x.a))
  def cos(x: DualNumber): DualNumber =
    DualNumber(Math.cos(x.a), -x.b * Math.sin(x.a))
}
