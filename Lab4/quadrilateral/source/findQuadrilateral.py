# Lab#4 - Boundary Value Analysis
# SC353201 Software Quality Assurance
# Semester 1/2567
# Instructor: Chitsutha Soomlek

class Quadrilateral:
  """
  Represents a quadrilateral and provides methods to classify its type.
  """

  def __init__(self, top, left_side, bottom, right_side):
    """
    Initializes a Quadrilateral object with given side lengths.

    Args:
      top: Length of the top side.
      left_side: Length of the left side.
      bottom: Length of the bottom side.
      right_side: Length of the right side.

    Raises:
      ValueError: If any side length is not a positive number.
    """
    if top <= 0 or left_side <= 0 or bottom <= 0 or right_side <= 0:
      raise ValueError("Side lengths must be positive numbers.")

    self.top = top
    self.left_side = left_side
    self.bottom = bottom
    self.right_side = right_side

  def classify(self):
    """
    Classifies the type of quadrilateral based on its side lengths.

    Returns:
      A string describing the type of quadrilateral.
    """
    if self.top == self.bottom and self.left_side == self.right_side:
      if self.top == self.left_side:
        return "Square"
      else:
        return "Rectangle"
    elif self.top == self.bottom or self.left_side == self.right_side:
      return "Trapezoid" 
    else:
      return "Irregular"

# Get side lengths from the user
top = float(input("Enter the length of the top side: "))
left_side = float(input("Enter the length of the left side: "))
bottom = float(input("Enter the length of the bottom side: "))
right_side = float(input("Enter the length of the right side: "))

# Create a Quadrilateral object
try:
  quad = Quadrilateral(top, left_side, bottom, right_side)
except ValueError as e:
  print("Error:", e) 
else:
  # Classify and print the result
  quad_type = quad.classify()
  print("The shape is a:", quad_type)
