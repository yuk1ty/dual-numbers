package model

trait DualNumberAddOps {
	def +(rhs: DualNumber): DualNumber = this += rhs
	def +(rhs: Double): DualNumber = this += rhs
	def +=(rhs: DualNumber): DualNumber
	def +=(rhs: Double): DualNumber
}
