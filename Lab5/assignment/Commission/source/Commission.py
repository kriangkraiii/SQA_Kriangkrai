# Lab#5 - EC
# SC353201 Software Quality Assurance
# Semester 1/2567
# Instructor: Chitsutha Soomlek

class Commission:
    PRICE_STOCK = 4500.0
    PRICE_LOCK = 3000.0
    PRICE_BARREL = 2500.0

    def check_commission(self, num_lock: int, num_stock: int, num_barrel: int) -> float:
        """
        Calculates the commission based on the number of locks, stocks, and barrels sold.

        Args:
            num_lock: The number of locks sold.
            num_stock: The number of stocks sold.
            num_barrel: The number of barrels sold.

        Returns:
            The calculated commission, or -1.0 if any input is negative.
        """

        if num_lock < 0 or num_stock < 0 or num_barrel < 0:
            return -1.0

        sold_lock = num_lock * self.PRICE_LOCK
        sold_stock = num_stock * self.PRICE_STOCK
        sold_barrel = num_barrel * self.PRICE_BARREL

        total_sales = sold_lock + sold_stock + sold_barrel

        if total_sales > 50000:
            commission = (0.1 * 20000) + (0.15 * 30000)
            commission += 0.2 * (total_sales - 50000)
        elif 20000 < total_sales < 50000:
            commission = 0.1 * 20000
            commission += 0.15 * (total_sales - 20000)
        elif 10000 < total_sales < 20000:
            commission = 0.1 * total_sales
        else:
            commission = 0.0

        return commission
