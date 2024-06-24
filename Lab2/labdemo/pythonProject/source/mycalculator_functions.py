# CP353201 Software Quality Assurance
# Lab2 - Test design - designing practical test scenarios and test cases
# Semester 1/2567
# @author Chitsutha Soomlek, College of Computing, KKU
# @version 1.0

def add_two_number(number_one, number_two):
    return number_one + number_two


def subtract_two_number(number_one, number_two):
    return number_one - number_two


def multiply_two_number(number_one, number_two):
    return number_one * number_two


def divide_two_number(number_one, number_two):
    if number_two != 0:
        return number_one / number_two
    raise(ZeroDivisionError)


def square_root(number):
    return number ** 0.5
