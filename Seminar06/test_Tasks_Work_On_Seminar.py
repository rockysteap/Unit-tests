from unittest.mock import Mock
import pytest
from Tasks import Tasks


class TestTasks:

    # Задание 1
    def test_average(self):
        assert Tasks.find_average([1, 2, 3, 4]) == 2.5

    # Задание 2
    def test_average_type_validate(self):
        with pytest.raises(TypeError):
            Tasks.find_average_with_zero_division_check('не список')

    # Задание 3
    def test_person_transfer_money_with_zero_balance(self):
        person = Tasks.Person()
        bank = Tasks.Bank()
        with pytest.raises(ValueError):
            person.transfer_money(1, bank)

    # Задание 4
    def test_person_transfer_money_with_positive_balance(self):
        person = Tasks.Person()
        bank = Tasks.Bank()
        person.balance = 1200
        person.transfer_money(200, bank)
        account = bank.balance
        assert 200 == account

    # Задание 5
    def test_bank_receive_money_call(self):
        person = Tasks.Person()
        bank = Mock()
        person.balance = 10
        person.transfer_money(5, bank)
        bank.receive_money.assert_called_with(5)

    # Задание 6

    def test_division_by_zero(self):
        with pytest.raises(ZeroDivisionError):
            Tasks.divide(2, 0)

    # Задание 8
    @pytest.mark.parametrize('num1, num2, res', [(2, 3, 6), (5, 6, 30), (2, -4, -8), (-5, -3, 15)])
    def test_multiply(self, num1, num2, res):
        assert Tasks.multiply(num1, num2) == res

    # Задание 9
    @pytest.mark.parametrize('n, res', [(11, True), (17, True), (-11, False), (-13, False)])
    def test_is_prime_number(self, n, res):
        assert Tasks.is_prime(n) == res
