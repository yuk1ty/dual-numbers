package model

import org.scalatest.{FunSpec, Matchers}

class DualNumberSpec extends FunSpec with Matchers {
  describe("DualNumbers") {
    describe("f(x)=4x^3+3x^2+2x+1") {
      it("get 10+20ε") {
        val x = DualNumber(1d, 1d)
        def f(x: DualNumber): DualNumber =
          4.0 * x * x * x + 3.0 * x * x + 2.0 * x + 1.0
        f(x) shouldBe DualNumber(10d, 20d)
      }
    }

    describe("df(x)/dx=12x^2+6x+2") {
      it("get 20") {
        val x = DualNumber(1d, 1d)
        def df(x: DualNumber): DualNumber = 12.0 * x + 6.0 * x + 2.0
        df(x).a shouldBe 20d
      }
    }

    describe("sin(π)") {
      import math._
      it("get 1.2246467991473532E-16") {
        val x = DualNumber(3.1415926535897932384626433832795, 1d)
        def f(x: DualNumber): DualNumber = sin(x)
        f(x) shouldBe DualNumber(1.2246467991473532E-16, -1.0)
      }
    }

    describe("dsin(π)/dx") {
      import math._
      it("get -1") {
        val x = DualNumber(3.1415926535897932384626433832795, 1d)
        def dsin(x: DualNumber): DualNumber = cos(x)
        dsin(x).a shouldBe -1.0
      }
    }

    describe("f(x) = x^2 + sin(x)") {
      import math._
      it("get 2.5403023058681398") {
        def f(x: DualNumber): DualNumber = x * x + sin(x)
        val x = DualNumber(1, 1)
        f(x) shouldBe DualNumber(1.8414709848078965, 2.5403023058681398)
      }
    }

    describe("df(x)/dx= x + x + cos(x)") {
      import math._
      it("get 2.5403023058681398") {
        def df(x: DualNumber): DualNumber = x + x + cos(x)
        val x = DualNumber(1, 1)
        df(x).a shouldBe 2.5403023058681398
      }
    }
  }
}
