# CP353201 Software Quality Assurance
# Lab5 - EC
# Semester 1/2567
# @author Chitsutha Soomlek, College of Computing, KKU
# @version 1.0

import unittest
import source.SimpleMathCalculator as SimpleMathCalculator


class TestSimpleMathCalculator(unittest.TestCase):
    def setUp(self):
        self.calculator = SimpleMathCalculator.SimpleMathCalculator()
        self.numberone = 10
        self.numbertwo = 20
        testname = self.shortDescription()

        if testname == "Add two numbers":
            self.numberone = 50
            self.numbertwo = 10
            print(testname, self.numberone, self.numbertwo)

        if testname == "Subtract two numbers":
            self.numberone = 40
            self.numbertwo = 20
            print(testname, self.numberone, self.numbertwo)

    def tearDown(self):
        print('\nend of test', self.shortDescription())

    def test_add_two_number(self):
        """Add two numbers"""
        result = self.calculator.add_two_number(self.numberone, self.numbertwo)
        self.assertEqual(result, 60)

    def test_subtract_two_number(self):
        """Subtract two numbers"""
        result = self.calculator.subtract_two_number(self.numberone, self.numbertwo)
        self.assertEqual(result, 20)

    def test_multiply_two_number(self):
        """Multiply two numbers"""
        result = self.calculator.multiply_two_number(self.numberone, self.numbertwo)
        self.assertEqual(result, 200)

if __name__ == '__main__':
    unittest.main()

