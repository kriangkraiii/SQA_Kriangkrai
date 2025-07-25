
package sqa.main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

//Extended Entry Decision Table
class TVPlanTest2 {

    @ParameterizedTest
    @CsvSource({
        // STANDARD package
        "STANDARD, false, false, false, 150",
        "STANDARD, false, false, true, 100",
        "STANDARD, false, true, false, 250",
        "STANDARD, false, true, true, 200",
        "STANDARD, true, false, false, 250",
        "STANDARD, true, false, true, 200",
        "STANDARD, true, true, false, 350",
        "STANDARD, true, true, true, 300",
        // PREMIUM package
        "PREMIUM, false, false, false, 350",
        "PREMIUM, false, false, true, 300",
        "PREMIUM, false, true, false, 450",
        "PREMIUM, false, true, true, 400",
        "PREMIUM, true, false, false, 450",
        "PREMIUM, true, false, true, 400",
        "PREMIUM, true, true, false, 550",
        "PREMIUM, true, true, true, 500",
        // FAMILY package
        "FAMILY, false, false, false, 450",
        "FAMILY, false, false, true, 400",
        "FAMILY, false, true, false, 550",
        "FAMILY, false, true, true, 500",
        "FAMILY, true, false, false, 550",
        "FAMILY, true, false, true, 500",
        "FAMILY, true, true, false, 650",
        "FAMILY, true, true, true, 600"
    })
    void testPricePerMonthLEDT(String pkg, boolean offline, boolean live, boolean discount, double expected) {
        TVPlan.TVPackage tvPackage = TVPlan.TVPackage.valueOf(pkg);
        TVPlan plan = new TVPlan(offline, live, discount);
        assertEquals(expected, plan.pricePerMonth(tvPackage));
    }

    @ParameterizedTest
    @CsvSource({
        // Normal cases
        "STANDARD, false, false, false, 150, 100, 100, 50, 150",
        "PREMIUM, true, false, true, 350, 100, 100, 50, 400",
        "FAMILY, true, true, false, 450, 100, 100, 50, 650",
        
        // Boundary: zero base price
        "STANDARD, true, true, true, 0, 100, 100, 50, 150",
        
        // Boundary: negative base price
        "PREMIUM, false, true, false, -350, 100, 100, 50, -250",
        
        // Boundary: high extra cost
        "FAMILY, true, true, true, 450, 500, 500, 50, 1900",
        
        // Invalid: negative extra cost
        "STANDARD, true, false, false, 150, -100, 100, 50, 150",
        
        
        // Invalid: negative discount
        "PREMIUM, false, false, true, 350, 100, 100, -50, 400"
    })
    void testPricePerMonthEEDT(String pkg, boolean offline, boolean live, boolean discount,
                               double basePrice, double offlineFee, double liveFee, double discountValue,
                               double expected) {
        TVPlan.TVPackage tvPackage = TVPlan.TVPackage.valueOf(pkg);
        TVPlan plan = new TVPlan(offline, live, discount) {
            @Override
            double pricePerMonth(TVPackage selectedPackage) {
                double extracost = 0;
                double reducecost = 0;
                extracost = offline ? extracost + offlineFee : extracost;
                extracost = live ? extracost + liveFee : extracost;
                reducecost = discount ? reducecost + discountValue : extracost;
                return basePrice + extracost - reducecost;
            }
        };
        assertEquals(expected, plan.pricePerMonth(tvPackage));
    }


}
