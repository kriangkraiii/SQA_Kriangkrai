package sqa.main;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class ShippingVehicleTest {

    @ParameterizedTest
    @CsvSource({
        // All negative values
        "-1,-1,-1,'-1'",
    	// Substitute large box with small boxes
        "5,0,0,'5,0,0'",      // 5 small boxes = 10kg

        // Substitute large box with medium boxes
        "0,2,0,'0,2,0'",      // 2 medium boxes = 10kg

        // Mix: 1 medium + 2 small = 9kg
        "2,1,0,'2,1,0'",      // 1 medium, 2 small

        // Not enough boxes to reach required weight
        "3,0,0,'3,0,0'",      // Only 3 small boxes (6kg)

        // Exact box counts for 17kg: 1 large, 1 medium, 1 small
        "1,1,1,'1,1,1'",
        // All zero
        "0,0,0,'0,0,0'",

        // Only small boxes
        "500,0,0,'-1'",      // Over limit
        "499,0,0,'499,0,0'", // Just under limit

        // Only medium boxes
        "0,200,0,'-1'",
        "0,199,0,'0,199,0'",

        // Only large boxes
        "0,0,101,'-1'",
        "0,0,100,'0,0,100'",

        // Mixed, under limit
        "10,10,10,'10,10,10'",
        "1,1,1,'1,1,1'",

        // Mixed, at limit
        "50,100,50,'-1'",

        // Mixed, over limit
        "100,100,100,'-1'",

        // Edge: minimal boxes
        "1,0,0,'1,0,0'",
        "0,1,0,'0,1,0'",
        "0,0,1,'0,0,1'",

        // Impossible to pack (not enough boxes)
        "1,1,100,'-1'",
        "1,100,1,'-1'",
        "100,1,1,'-1'",

        // Large values, but under limit
        "100,50,50,'50,50,0'",

        // Negative values (should not be possible, but test robustness)
        "-1,0,0,'-1'",
        "0,-1,0,'-1'",
        "0,0,-1,'-1'"
    })
    void testCalculate(int small, int medium, int large, String expectedStr) {
        ShippingVehicle vehicle = new ShippingVehicle();
        List<Integer> result = vehicle.calculate(small, medium, large);
        String actual = String.join(",", result.stream().map(String::valueOf).toArray(String[]::new));
        assertEquals(expectedStr, actual);
    }
}
