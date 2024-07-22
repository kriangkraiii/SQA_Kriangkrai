# Lab#6 - Decision Table and State Transition
# SC353201 Software Quality Assurance
# Semester 1/2567
# Instructor: Chitsutha Soomlek

from datetime import datetime

class Pension:
    """
    Represents a pension calculator for teachers based on specific criteria.
    """

    # Class constants for pension calculation
    APPLICATION_DEADLINE = datetime(2024, 7, 31)
    RETIREMENT_AGE = 60
    COMBINED_AGE_TEACHING = 80
    MAX_BASE_SALARY = 90000
    HIGHER_BASE_PERCENTAGE = 0.016
    LOWER_BASE_PERCENTAGE = 0.0155
    EXCESS_PERCENTAGE = 0.015

    def __init__(self, application_date, birth_date, years_of_teaching, highest_salary):
        """
        Initializes a Pension object with teacher's information.

        Args:
            application_date: Datetime object representing the application date.
            birth_date: Datetime object representing the teacher's birth date.
            years_of_teaching: Integer representing the teacher's years of teaching.
            highest_salary: Float representing the teacher's highest salary.
        """
        self.application_date = application_date
        self.birth_date = birth_date
        self.years_of_teaching = years_of_teaching
        self.highest_salary = highest_salary
        self.age = (datetime.now() - birth_date).days // 365

    def is_eligible(self):
        """
        Checks if the teacher is eligible for a pension.

        Returns:
            True if eligible, False otherwise.
        """
        if self.application_date > self.APPLICATION_DEADLINE:
            print("Application deadline missed.")
            return False
        return self.age >= self.RETIREMENT_AGE or (self.age + self.years_of_teaching) >= self.COMBINED_AGE_TEACHING

    def calculate_pension(self):
        """
        Calculates the pension amount if the teacher is eligible.

        Returns:
            The calculated pension amount as a float, or None if not eligible.
        """
        if self.is_eligible():
            if self.age >= self.COMBINED_AGE_TEACHING:
                base_percentage = self.LOWER_BASE_PERCENTAGE
            elif self.age >= self.RETIREMENT_AGE:
                base_percentage = self.HIGHER_BASE_PERCENTAGE
            else:
                base_percentage = self.years_of_teaching/100

            if self.highest_salary <= self.MAX_BASE_SALARY:
                return ((self.highest_salary * base_percentage)/100) * self.highest_salary
            else:
                return (((self.MAX_BASE_SALARY * base_percentage) + (
                    (self.highest_salary - self.MAX_BASE_SALARY) * self.EXCESS_PERCENTAGE)/100) * self.highest_salary
                )
        else:
            print("Not eligible for pension yet.")
            return None

# # Example usage
# application_date = datetime(2024, 7, 30)
# birth_date = datetime(1963, 5, 10)
# years_of_teaching = 30
# highest_salary = 110000
#
# # Create a Pension object
# pension = Pension(application_date, birth_date, years_of_teaching, highest_salary)
#
# # Calculate and print pension
# if pension.is_eligible():
#     pension_amount = pension.calculate_pension()
#     print(f"The calculated pension is: {pension_amount:.2f} baht")
