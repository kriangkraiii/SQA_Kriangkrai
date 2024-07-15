# Lab#5 - EC
# SC353201 Software Quality Assurance
# Semester 1/2567
# Instructor: Chitsutha Soomlek

class ShippingBoxes:
    CANNOT_SHIP_ITEM = -1

    def calculate(self, small_size: int, medium_size: int, large_size: int) -> list[int]:
        """
        Calculates the number of small, medium, and large boxes that can be shipped.

        Args:
            small_size: The number of small-sized items.
            medium_size: The number of medium-sized items.
            large_size: The number of large-sized items.

        Returns:
            A list containing the number of shippable large, medium, and small boxes,
            or [-1] if the items cannot be shipped.
        """

        ship_list = []
        total_items = small_size + medium_size + large_size
        max_large_boxes = total_items // 10
        large_boxes_to_ship = min(max_large_boxes, large_size)

        ship_list.append(large_boxes_to_ship)
        total_items -= large_boxes_to_ship * 10

        if medium_size < total_items:
            ship_list.append(self.CANNOT_SHIP_ITEM)
            return ship_list
        else:
            max_medium_boxes = total_items // 5
            medium_boxes_to_ship = min(max_medium_boxes, medium_size)
            ship_list.append(medium_boxes_to_ship)
            total_items -= medium_boxes_to_ship * 5

        if small_size < total_items:
            ship_list.append(self.CANNOT_SHIP_ITEM)
            return ship_list
        else:
            ship_list.append(total_items)

        return ship_list
