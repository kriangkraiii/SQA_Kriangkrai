# CP353201 Software Quality Assurance
# Lab5 - EC
# Semester 1/2567
# @author Chitsutha Soomlek, College of Computing, KKU
# @version 1.0

class SimpleMathCalculator:
    def add_two_number(self, number_one, number_two):
        return number_one + number_two

    def subtract_two_number(self, number_one, number_two):
        return number_one - number_two

    def multiply_two_number(self, number_one, number_two):
        return number_one * number_two

    def divide_two_number(self, number_one, number_two):
        if number_two != 0:
            return number_one / number_two
        raise (ZeroDivisionError)

    def square_root(self, number):
        return number ** 0.5
