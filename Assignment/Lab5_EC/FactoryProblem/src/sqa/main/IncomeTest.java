package sqa.main;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class IncomeTest {

    @ParameterizedTest
    @CsvSource({
        // 1. All valid (middle value)
        "3000,500,1000,67000.0",

        // 2. Valid boundaries (lower and upper for each input)
        "1000,500,1000,26000.0",
        "5000,500,1000,67000.0",
        "3000,300,1000,43000.0",
        "3000,800,1000,103000.0",
        "3000,500,500,41000.0",
        "3000,500,3000,107000.0",

        // 3. Each input invalid (low and high, others valid)
        "999,500,1000,-1.0",
        "5001,500,1000,-1.0",
        "3000,299,1000,-1.0",
        "3000,801,1000,-1.0",
        "3000,500,499,-1.0",
        "3000,500,3001,-1.0",

        // 4. Two invalids (all combinations, low/high for each, others valid)
        "999,299,1000,-1.0",
        "999,801,1000,-1.0",
        "5001,299,1000,-1.0",
        "5001,801,1000,-1.0",
        "999,500,499,-1.0",
        "999,500,3001,-1.0",
        "5001,500,499,-1.0",
        "5001,500,3001,-1.0",
        "3000,299,499,-1.0",
        "3000,299,3001,-1.0",
        "3000,801,499,-1.0",
        "3000,801,3001,-1.0",

        // 5. All invalid (all low, all high)
        "999,299,499,-1.0",
        "5001,801,3001,-1.0"
    })
    void testCalculateIncome(int impeller, int motor, int cover, double expected) {
        Income income = new Income();
        assertEquals(expected, income.calculateIncome(impeller, motor, cover));
    }
}
