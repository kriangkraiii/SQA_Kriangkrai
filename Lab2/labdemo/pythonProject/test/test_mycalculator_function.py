# CP353201 Software Quality Assurance
# Lab2 - Test design - designing practical test scenarios and test cases
# Semester 1/2567
# @author Chitsutha Soomlek, College of Computing, KKU
# @version 1.0

import pytest
import source.mycalculator_functions as mycalculator_functions


def test_add_two_numbers():
    result = mycalculator_functions.add_two_number(number_one=3, number_two=5)
    assert result == 8


def test_subtract_two_numbers():
    result = mycalculator_functions.subtract_two_number(number_one=3, number_two=5)
    assert result == 2


def test_multiply_two_numbers():
    result = mycalculator_functions.multiply_two_number(number_one=3, number_two=5)
    assert result == 15


def test_divide_two_numbers():
    result = mycalculator_functions.divide_two_number(number_one=10, number_two=5)
    assert result == 2


def test_divide_by_zero():
    with pytest.raises(ZeroDivisionError):
        result = mycalculator_functions.divide_two_number(number_one=5, number_two=0)
