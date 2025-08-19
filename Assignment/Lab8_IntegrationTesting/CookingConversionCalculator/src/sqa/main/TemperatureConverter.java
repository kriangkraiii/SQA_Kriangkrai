package sqa.main;

public class TemperatureConverter {
    
    public TemperatureConverter(){
        
    }
    
    public double convert(double tempValue, String fromUnit, String toUnit) {
        double result = 0.0;
        
        if (fromUnit.equals("fahrenheit")) {
            if (toUnit.equals("celsius")) {
                result = (tempValue - 32) * (5.0/9.0);
            } 
        }
        else if (fromUnit.equals("celsius")) {
            if (toUnit.equals("fahrenheit")) {
                result = (tempValue * (9.0/5.0)) + 32;
            } 
        }
        
        return result;
    }
}
