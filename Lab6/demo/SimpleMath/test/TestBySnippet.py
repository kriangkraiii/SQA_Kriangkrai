# CP353201 Software Quality Assurance
# Lab6 - DT
# Semester 1/2567
# @author Chitsutha Soomlek, College of Computing, KKU
# @version 1.0

import unittest
import source.SimpleMathCalculator as SimpleMathCalculator

class TestBySnippet(unittest.TestCase):
    def setUp(self):
        self.calculator = SimpleMathCalculator.SimpleMathCalculator()
        testname = self.shortDescription()

    def tearDown(self):
        print('\nend of test', self.shortDescription())

    def test_add(self):
        """Add two numbers"""
        self.assertEqual(self.calculator.add_two_number(20, 5), 25)
        self.assertEqual(self.calculator.add_two_number(-1, 1), 0)

    def test_subtract(self):
        """Subtract two numbers"""
        self.assertEqual(self.calculator.subtract_two_number(15, 5), 10)
        self.assertEqual(self.calculator.subtract_two_number(-1, 0), -1)
        self.assertEqual(self.calculator.subtract_two_number(-1, -1), 0)

    def test_multiply(self):
        """Multiply two numbers"""
        self.assertEqual(self.calculator.multiply_two_number(20, 5), 100)
        self.assertEqual(self.calculator.multiply_two_number(-1, 1), -1)
        self.assertEqual(self.calculator.multiply_two_number(-1, -1), 1)

    def test_divide(self):
        """Divide two numbers"""
        self.assertEqual(self.calculator.divide_two_number(10, 5), 2)
        self.assertEqual(self.calculator.divide_two_number(-1, 1), -1)
        with self.assertRaises(ZeroDivisionError):
            self.calculator.divide_two_number(10, 0)

if __name__ == '__main__':
    unittest.main()
