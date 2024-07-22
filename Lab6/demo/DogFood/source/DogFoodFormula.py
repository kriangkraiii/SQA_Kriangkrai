# CP353201 Software Quality Assurance
# Lab6 - DT
# Semester 1/2567
# @author Chitsutha Soomlek, College of Computing, KKU
# @version 1.0
class DogFoodFormula:
    def __init__(self, age):
        self.age = age

    def categorize_by_age(self, age):
        if 0 <= age <= 1:
            return "Puppy"
        elif 1 < age <= 3:
            return "Adolescent"
        elif 4 < age <= 7:
            return "Adult"
        elif 7 < age <= 20:
            return "Golden age"
        else:
            return f'Invalid age: {age}'
