package sqa.main;

import java.util.ArrayList;
import java.util.List;

public class ShippingVehicle {
	
	public static final int CANNOT_SHIP_ITEM = -1;
	public static final int MAX_WEIGHT = 1000;
	public static final int SMALL_WEIGHT = 2;
	public static final int MED_WEIGHT = 5;
	public static final int LARGE_WEIGHT = 10;
	

    public List<Integer> calculate(int smallSize, int mediumSize, int largeSize) {
    	
    	List<Integer> shiplist = new ArrayList<Integer>();
    	int total = (smallSize*SMALL_WEIGHT) + (mediumSize*MED_WEIGHT) + (largeSize*LARGE_WEIGHT);
    	
    	if (total >= MAX_WEIGHT){
        	shiplist.add(CANNOT_SHIP_ITEM);
            return shiplist;
        }
    	else {
    	
    		int maxLargeBoxes = total / LARGE_WEIGHT;
    		int largeBoxesWeCanShip = Math.min(maxLargeBoxes, largeSize);
        
    		shiplist.add(largeBoxesWeCanShip);
    		total -= (largeBoxesWeCanShip * LARGE_WEIGHT);

    		if(mediumSize < total) {
    			shiplist.add(CANNOT_SHIP_ITEM);
    			return shiplist;
    		}
    		else {
    			int maxMediumBoxes = total / MED_WEIGHT;
    			int mediumBoxesWeCanShip = Math.min(maxMediumBoxes, mediumSize);
    			shiplist.add(mediumBoxesWeCanShip);
    			total -= (mediumBoxesWeCanShip * MED_WEIGHT);
    		}
        
    		if(smallSize < total){
    			shiplist.add(CANNOT_SHIP_ITEM);
    			return shiplist;
    		}
    		else {
    			shiplist.add(total);
    		}
    	}
        
        return shiplist;
    }
}