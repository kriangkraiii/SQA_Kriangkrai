# CP353201 Software Quality Assurance
# Lab6 - DT
# Semester 1/2567
# @author Chitsutha Soomlek, College of Computing, KKU
# @version 1.0

import unittest
from source import DogFoodFormula as DogFoodFormula


class TestMultipleAssertions(unittest.TestCase):
    def setUp(self):
        self.dogfoodformula = DogFoodFormula.DogFoodFormula(0)
        testname = self.shortDescription()

    def test_boundary_puppy_adolescent(self):
        self.assertEqual(self.dogfoodformula.categorize_by_age(0), "Puppy")
        self.assertEqual(self.dogfoodformula.categorize_by_age(2), "Adolescent")

    def test_boundary_adolescent_adult(self):
        self.assertEqual(self.dogfoodformula.categorize_by_age(3), "Adolescent")
        self.assertEqual(self.dogfoodformula.categorize_by_age(6), "Adult")

    def test_boundary_adult_goldenage(self):
        self.assertEqual(self.dogfoodformula.categorize_by_age(7), "Adult")
        self.assertEqual(self.dogfoodformula.categorize_by_age(20), "Golden age")

if __name__ == '__main__':
    unittest.main()
