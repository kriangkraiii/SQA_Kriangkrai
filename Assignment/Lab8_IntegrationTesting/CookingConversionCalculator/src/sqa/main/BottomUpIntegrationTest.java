package sqa.main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class BottomUpIntegrationTest {
    
    private TemperatureConverter tempConverter;
    private MassConverter massConverter;
    private LiquidVolumeConverter liquidConverter;
    private CookingConversionCalculator calculator;
    
    @BeforeEach
    void setUp() {
        tempConverter = new TemperatureConverter();
        massConverter = new MassConverter();
        liquidConverter = new LiquidVolumeConverter();
        calculator = new CookingConversionCalculator();
    }
    
    // Level 1: Test individual converters
    @Test
    void testTemperatureConverterUnit() {
        // Test celsius to fahrenheit
        double result = tempConverter.convert(0, "celsius", "fahrenheit");
        assertEquals(32.0, result, 0.01);
        
        result = tempConverter.convert(100, "celsius", "fahrenheit");
        assertEquals(212.0, result, 0.01);
        
        // Test fahrenheit to celsius
        result = tempConverter.convert(32, "fahrenheit", "celsius");
        assertEquals(0.0, result, 0.01);
        
        result = tempConverter.convert(212, "fahrenheit", "celsius");
        assertEquals(100.0, result, 0.01);
        
        // Test unsupported conversion
        result = tempConverter.convert(100, "kelvin", "celsius");
        assertEquals(0.0, result);
    }
    
    @Test
    void testMassConverterUnit() {
        // Test getConversionFactor method
        assertEquals(125.0, massConverter.getConversionFactor("cup", "gram"));
        assertEquals(8.0, massConverter.getConversionFactor("tablespoon", "gram"));
        assertEquals(3.0, massConverter.getConversionFactor("teaspoon", "gram"));
        assertEquals(28.349, massConverter.getConversionFactor("oz", "gram"));
        assertEquals(0.454, massConverter.getConversionFactor("pound", "kilogram"));
        assertEquals(0.035, massConverter.getConversionFactor("gram", "oz"));
        assertEquals(2.205, massConverter.getConversionFactor("kilogram", "pound"));
        
        // Test convert method
        assertEquals(250.0, massConverter.convert(2, "cup", "gram"));
        assertEquals(24.0, massConverter.convert(3, "tablespoon", "gram"));
        assertEquals(12.0, massConverter.convert(4, "teaspoon", "gram"));
    }
    
    @Test
    void testLiquidVolumeConverterUnit() {
        // Test getConversionFactor method
        assertEquals(250.0, liquidConverter.getConversionFactor("cup", "ml"));
        assertEquals(8.0, liquidConverter.getConversionFactor("cup", "oz"));
        assertEquals(15.0, liquidConverter.getConversionFactor("tablespoon", "ml"));
        assertEquals(5.0, liquidConverter.getConversionFactor("teaspoon", "ml"));
        assertEquals(29.574, liquidConverter.getConversionFactor("oz", "ml"));
        assertEquals(473.176, liquidConverter.getConversionFactor("pint", "ml"));
        assertEquals(0.946, liquidConverter.getConversionFactor("quart", "liter"));
        assertEquals(0.034, liquidConverter.getConversionFactor("ml", "oz"));
        assertEquals(2.113, liquidConverter.getConversionFactor("liter", "pint"));
        assertEquals(1.057, liquidConverter.getConversionFactor("liter", "quart"));
        assertEquals(0.264, liquidConverter.getConversionFactor("liter", "gallon"));
        
        // Test convert method
        assertEquals(500.0, liquidConverter.convert(2, "cup", "ml"));
        assertEquals(45.0, liquidConverter.convert(3, "tablespoon", "ml"));
        assertEquals(20.0, liquidConverter.convert(4, "teaspoon", "ml"));
    }
    
    // Level 2: Test integration between CookingConversionCalculator and individual converters
    @Test
    void testCalculatorWithTemperatureConverter() {
        double result = calculator.convert(0, "temperature", "celsius", "fahrenheit");
        double expectedResult = tempConverter.convert(0, "celsius", "fahrenheit");
        assertEquals(expectedResult, result);
        
        result = calculator.convert(212, "temperature", "fahrenheit", "celsius");
        expectedResult = tempConverter.convert(212, "fahrenheit", "celsius");
        assertEquals(expectedResult, result);
    }
    
    @Test
    void testCalculatorWithMassConverter() {
        double result = calculator.convert(2, "mass", "cup", "gram");
        double expectedResult = massConverter.convert(2, "cup", "gram");
        assertEquals(expectedResult, result);
        
        result = calculator.convert(1, "mass", "pound", "kilogram");
        expectedResult = massConverter.convert(1, "pound", "kilogram");
        assertEquals(expectedResult, result);
    }
    
    @Test
    void testCalculatorWithLiquidVolumeConverter() {
        double result = calculator.convert(3, "liquid", "cup", "ml");
        double expectedResult = liquidConverter.convert(3, "cup", "ml");
        assertEquals(expectedResult, result);
        
        result = calculator.convert(2, "liquid", "liter", "pint");
        expectedResult = liquidConverter.convert(2, "liter", "pint");
        assertEquals(expectedResult, result);
    }
    
    // Level 3: Complete system integration test
    @Test
    void testCompleteSystemIntegration() {
        // Test all conversion types through main calculator
        
        // Temperature conversions
        assertEquals(32.0, calculator.convert(0, "temperature", "celsius", "fahrenheit"), 0.01);
        assertEquals(100.0, calculator.convert(212, "temperature", "fahrenheit", "celsius"), 0.01);
        
        // Mass conversions
        assertEquals(125.0, calculator.convert(1, "mass", "cup", "gram"), 0.01);
        assertEquals(0.454, calculator.convert(1, "mass", "pound", "kilogram"), 0.01);
        
        // Liquid volume conversions
        assertEquals(250.0, calculator.convert(1, "liquid", "cup", "ml"), 0.01);
        assertEquals(0.946, calculator.convert(1, "liquid", "quart", "liter"), 0.01);
        
        // Invalid choice
        assertEquals(0.0, calculator.convert(1, "invalid", "cup", "ml"));
    }
    
    @Test
    void testBoundaryValues() {
        // Test with zero
        assertEquals(0.0, calculator.convert(0, "mass", "cup", "gram"));
        assertEquals(0.0, calculator.convert(0, "liquid", "cup", "ml"));
        
        // Test with negative values
        assertEquals(-125.0, calculator.convert(-1, "mass", "cup", "gram"));
        assertEquals(-250.0, calculator.convert(-1, "liquid", "cup", "ml"));
        
        // Test temperature with freezing/boiling points
        assertEquals(-17.78, calculator.convert(0, "temperature", "fahrenheit", "celsius"), 0.01);
        assertEquals(-40.0, calculator.convert(-40, "temperature", "fahrenheit", "celsius"), 0.01);
    }
}
