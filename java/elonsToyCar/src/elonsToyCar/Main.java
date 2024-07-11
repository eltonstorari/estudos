package elonsToyCar;

public class Main {

	public static void main(String[] args) {
		
		ElonsToyCar elonsToyCar = new ElonsToyCar();
		
		System.out.println(elonsToyCar.distanceDisplay());

	}

	public static class ElonsToyCar {
		private int distance = 0;
		
	    public static ElonsToyCar buy() {
	        ElonsToyCar car = new ElonsToyCar();
	        return car;
	    }
	    
	    public String distanceDisplay() {
	        return "Driven " + distance + " meters";
	    
	    }
		
	}


}