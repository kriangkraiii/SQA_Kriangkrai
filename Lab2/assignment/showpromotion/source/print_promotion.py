# Lab#2 - Test design - designing practical test scenarios and test cases
# Student name: Mr.......
# Student ID:

MINIMUM = 500
MIDRANGE: int = 700
MAXIMUM = 1200
FREE_ICECREAM = "Free ice cream cone = "
FREE_CAKE = "Free chocolate cake = "
NO_GIFT = "Thank you and see you next time"

def print_promotion(total_cost):
    temp_cost = total_cost
    num_icecream = 0
    num_cake = 0

    # Check if total_cost is more than minimum requirement
    if total_cost >= MINIMUM:
        while temp_cost != 0:
            if temp_cost / MAXIMUM >= 1:
                num_icecream += temp_cost / MAXIMUM
                num_cake += temp_cost / MAXIMUM
                temp_cost = temp_cost - (num_icecream * MAXIMUM)
            elif temp_cost / MIDRANGE >= 1:
                num_cake += temp_cost / MIDRANGE
                temp_cost = temp_cost - (num_cake * MIDRANGE)
            elif temp_cost / MINIMUM >= 1:
                num_icecream += temp_cost / MINIMUM
                temp_cost = temp_cost - (num_icecream * MAXIMUM)
            else:
                temp_cost = 0
    else:
        # no gift
        print(NO_GIFT)

    if total_cost >= MAXIMUM:
        print(FREE_ICECREAM + str(num_icecream) + " and " + FREE_CAKE + str(num_cake))
    elif total_cost >= MIDRANGE:
        print(FREE_CAKE + str(num_cake))
    else:
        print(FREE_ICECREAM + str(num_icecream))
