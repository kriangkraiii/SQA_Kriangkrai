package sqa.main;

public class ComponentDriver {
    
    public static void main(String[] args) {
        testTemperatureConverter();
        testMassConverter();
        testLiquidVolumeConverter();
    }
    
    public static void testTemperatureConverter() {
        System.out.println("=== Testing TemperatureConverter ===");
        TemperatureConverter converter = new TemperatureConverter();
        
        System.out.println("0°C to °F: " + converter.convert(0, "celsius", "fahrenheit"));
        System.out.println("100°C to °F: " + converter.convert(100, "celsius", "fahrenheit"));
        System.out.println("32°F to °C: " + converter.convert(32, "fahrenheit", "celsius"));
        System.out.println("212°F to °C: " + converter.convert(212, "fahrenheit", "celsius"));
    }
    
    public static void testMassConverter() {
        System.out.println("\n=== Testing MassConverter ===");
        MassConverter converter = new MassConverter();
        
        System.out.println("1 cup to gram: " + converter.convert(1, "cup", "gram"));
        System.out.println("1 tablespoon to gram: " + converter.convert(1, "tablespoon", "gram"));
        System.out.println("1 pound to kilogram: " + converter.convert(1, "pound", "kilogram"));
    }
    
    public static void testLiquidVolumeConverter() {
        System.out.println("\n=== Testing LiquidVolumeConverter ===");
        LiquidVolumeConverter converter = new LiquidVolumeConverter();
        
        System.out.println("1 cup to ml: " + converter.convert(1, "cup", "ml"));
        System.out.println("1 tablespoon to ml: " + converter.convert(1, "tablespoon", "ml"));
        System.out.println("1 quart to liter: " + converter.convert(1, "quart", "liter"));
    }
}