# CP353201 Software Quality Assurance
# Lab5 - EC
# Semester 1/2567
# @author Chitsutha Soomlek, College of Computing, KKU
# @version 1.0

import unittest
import source.SimpleMathCalculator as SimpleMathCalculator


class TestFixtureSimpleMathCalculator(unittest.TestCase):

    @classmethod
    def setUpClass(cls):
        print('This method is called once before all tests in the class.')

    @classmethod
    def tearDownClass(cls):
        print('\nThis method is called once after all tests in the class.')

    def setUp(self):
        self.calculator = SimpleMathCalculator.SimpleMathCalculator()
        self.numberone = 10
        self.numbertwo = 20
        testname = self.shortDescription()

    def tearDown(self):
        print('\n End of test', self.shortDescription())

    def test_add_two_number(self):
        """Add two numbers"""
        result = self.calculator.add_two_number(self.numberone, self.numbertwo)
        self.assertEqual(result, 30)

    def test_subtract_two_number(self):
        """Subtract two numbers"""
        result = self.calculator.subtract_two_number(self.numberone, self.numbertwo)
        self.assertEqual(result, -10)

if __name__ == '__main__':
    unittest.main()
