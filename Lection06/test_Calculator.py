from unittest import TestCase

import pytest

from Calculator import Calculator


class TestCalculator(TestCase):
    def setUp(self):
        self.calc = Calculator()

class CalculatorTest(TestCalculator):

    def test_add(self):
        res = self.calc.add(2, 3)
        self.assertEquals(res, 5)

    def test_sub(self):
        res = self.calc.sub(7, 3)
        self.assertEquals(res, 4)

    def test_mul(self):
        res = self.calc.mul(4, 5)
        self.assertEquals(res, 20)

    def test_div(self):
        res = self.calc.div(30, 2)
        self.assertEquals(res, 15)

    def test_div_by_zero(self):
        # res = Calculator.div(2, 0)
        # self.assertRaises(ValueError)
        with pytest.raises(ZeroDivisionError):
            self.calc.div(2, 0)
