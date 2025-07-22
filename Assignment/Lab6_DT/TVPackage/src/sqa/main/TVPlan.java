package sqa.main;

public class TVPlan {
	
	static final double OFFLINE_SERVICEFEE = 100;
	static final double LIVE_SERVICEFEE = 100;
	static final double DISCOUNT = 50;
	
	private final boolean offline_watching, live_service, discount;
	
	public TVPlan(boolean offline_watching, boolean live_service, boolean discount) {
		this.offline_watching = offline_watching;
		this.live_service = live_service;
		this.discount = discount;
	}
	
	public enum TVPackage {
		STANDARD, PREMIUM, FAMILY;
		
		public double getPrice() {
			switch(this) {	
			case STANDARD:
				return 150;
			case PREMIUM:
				return 350;
			case FAMILY:
				return 450;
			default:
				return 0;
			}
		}
	}
	
	double pricePerMonth(TVPackage selectedPackage) {
		double totalPrice = 0;
		double basePrice = selectedPackage.getPrice();
		double extracost = 0;
		double reducecost = 0;
		
		extracost = offline_watching ? extracost + OFFLINE_SERVICEFEE: extracost;
		extracost = live_service ? extracost + LIVE_SERVICEFEE : extracost;
		reducecost = discount ? reducecost + DISCOUNT : extracost;
		
		totalPrice = basePrice + extracost - reducecost;
		
		return totalPrice;
	}

}
