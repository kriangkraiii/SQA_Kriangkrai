package sqa.main;

<<<<<<< HEAD
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


=======
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

>>>>>>> 2025
public class TopDownIntegrationTest {
    
    private CookingConversionCalculator calculator;
    
    @BeforeEach
    void setUp() {
        calculator = new CookingConversionCalculator();
    }
    
    // Level 1: Test CookingConversionCalculator with all converters
    @Test
    void testTemperatureConversionIntegration() {
        // Celsius to Fahrenheit
        double result = calculator.convert(0, "temperature", "celsius", "fahrenheit");
        assertEquals(32.0, result, 0.01);
        
        // Fahrenheit to Celsius
        result = calculator.convert(212, "temperature", "fahrenheit", "celsius");
        assertEquals(100.0, result, 0.01);
    }
    
    @Test
    void testMassConversionIntegration() {
        // Cup to gram
        double result = calculator.convert(1, "mass", "cup", "gram");
        assertEquals(125.0, result, 0.01);
        
        // Tablespoon to gram
        result = calculator.convert(2, "mass", "tablespoon", "gram");
        assertEquals(16.0, result, 0.01);
        
        // Teaspoon to gram
        result = calculator.convert(3, "mass", "teaspoon", "gram");
        assertEquals(9.0, result, 0.01);
        
        // Oz to gram
        result = calculator.convert(1, "mass", "oz", "gram");
        assertEquals(28.349, result, 0.01);
        
        // Pound to kilogram
        result = calculator.convert(1, "mass", "pound", "kilogram");
        assertEquals(0.454, result, 0.01);
        
        // Gram to oz
        result = calculator.convert(100, "mass", "gram", "oz");
        assertEquals(3.5, result, 0.01);
        
        // Kilogram to pound
        result = calculator.convert(1, "mass", "kilogram", "pound");
        assertEquals(2.205, result, 0.01);
    }
    
    @Test
    void testLiquidVolumeConversionIntegration() {
        // Cup to ml
        double result = calculator.convert(1, "liquid", "cup", "ml");
        assertEquals(250.0, result, 0.01);
        
        // Cup to oz
        result = calculator.convert(1, "liquid", "cup", "oz");
        assertEquals(8.0, result, 0.01);
        
        // Tablespoon to ml
        result = calculator.convert(2, "liquid", "tablespoon", "ml");
        assertEquals(30.0, result, 0.01);
        
        // Teaspoon to ml
        result = calculator.convert(4, "liquid", "teaspoon", "ml");
        assertEquals(20.0, result, 0.01);
        
        // Oz to ml
        result = calculator.convert(1, "liquid", "oz", "ml");
        assertEquals(29.574, result, 0.01);
        
        // Pint to ml
        result = calculator.convert(1, "liquid", "pint", "ml");
        assertEquals(473.176, result, 0.01);
        
        // Quart to liter
        result = calculator.convert(1, "liquid", "quart", "liter");
        assertEquals(0.946, result, 0.01);
        
        // Ml to oz
        result = calculator.convert(100, "liquid", "ml", "oz");
        assertEquals(3.4, result, 0.01);
        
        // Liter to pint
        result = calculator.convert(1, "liquid", "liter", "pint");
        assertEquals(2.113, result, 0.01);
        
        // Liter to quart
        result = calculator.convert(1, "liquid", "liter", "quart");
        assertEquals(1.057, result, 0.01);
        
        // Liter to gallon
        result = calculator.convert(1, "liquid", "liter", "gallon");
        assertEquals(0.264, result, 0.01);
    }
    
    @Test
    void testInvalidChoiceReturnsZero() {
        double result = calculator.convert(100, "invalid", "cup", "ml");
        assertEquals(0.0, result);
    }
    
    @Test
    void testEdgeCases() {
        // Zero value
        double result = calculator.convert(0, "mass", "cup", "gram");
        assertEquals(0.0, result);
        
        // Negative value
        result = calculator.convert(-5, "liquid", "cup", "ml");
        assertEquals(-1250.0, result);
        
        // Large value
        result = calculator.convert(1000, "mass", "cup", "gram");
        assertEquals(125000.0, result);
    }
}
