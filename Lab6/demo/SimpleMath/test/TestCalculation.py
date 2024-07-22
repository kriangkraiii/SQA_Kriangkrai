# CP353201 Software Quality Assurance
# Lab6 - DT
# Semester 1/2567
# @author Chitsutha Soomlek, College of Computing, KKU
# @version 1.0

import unittest
import TestBySnippet

def make_suite():
    arithmetic_tests = [
        TestBySnippet.TestBySnippet("test_add"),
        TestBySnippet.TestBySnippet("test_subtract"),
        TestBySnippet.TestBySnippet("test_multiply"),
        TestBySnippet.TestBySnippet("test_divide"),
    ]
    return unittest.TestSuite(tests=arithmetic_tests)

if __name__ == "__main__":
    suite = make_suite()
    runner = unittest.TextTestRunner(verbosity=2)
    runner.run(suite)
