# CP353201 Software Quality Assurance
# Lab6 - DT
# Semester 1/2567
# @author Chitsutha Soomlek, College of Computing, KKU
# @version 1.0

import unittest
from source import DogFoodFormula as DogFoodFormula

class TestCategorizeByAge(unittest.TestCase):

    def setUp(self):
        self.dogfoodformula = DogFoodFormula.DogFoodFormula(0)
        testname = self.shortDescription()

        if testname == "Puppy formula":
            self.age = 1
            print(testname, self.age)
        if testname == "Adolescent formula":
            self.age = 2
            print(testname, self.age)
        if testname == "Adult formula":
            self.age = 5
            print(testname, self.age)
        if testname == "Golden age formula":
            self.age = 8
            print(testname, self.age)


    def tearDown(self):
        print('\nEnd of test', self.shortDescription())

    def test_child(self):
        """Puppy formula"""
        result = self.dogfoodformula.categorize_by_age(self.age)
        self.assertEqual(result, "Puppy")

    def test_adolescent(self):
        """Adolescent formula"""
        result = self.dogfoodformula.categorize_by_age(self.age)
        self.assertEqual(result, "Adolescent")

    def test_adult(self):
        """Adult formula"""
        result = self.dogfoodformula.categorize_by_age(self.age)
        self.assertEqual(result, "Adult")

    def test_golden_age(self):
        """Golden age formula"""
        result = self.dogfoodformula.categorize_by_age(self.age)
        self.assertEqual(result, "Golden age")

    def test_negative_age(self):
        self.assertEqual(self.dogfoodformula.categorize_by_age(-1), "Invalid age: -1")

    def test_too_old(self):
        self.assertEqual(self.dogfoodformula.categorize_by_age(100), "Invalid age: 100")

if __name__ == '__main__':
    unittest.main()
