# CP353201 Software Quality Assurance
# Lab2 - Test design - designing practical test scenarios and test cases
# Semester 1/2567
# @author Chitsutha Soomlek, College of Computing, KKU
# @version 1.0

import pytest
import source.mystring_functions as mystring_functions

def test_concatenate_strings():
    result = mystring_functions.concatenate_strings(string1="Good day", string2=" for running")
    assert result == "Good day for running"


def test_substrings():
    result = mystring_functions.substrings(string1="I like apple", string2="apple")
    assert result == "I like apple for running"
