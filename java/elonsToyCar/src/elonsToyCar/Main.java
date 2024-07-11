package elonsToyCar;

public class Main {

	public static void main(String[] args) {
		
		ElonsToyCar elonsToyCar = new ElonsToyCar();
		
		System.out.println(elonsToyCar.distanceDisplay());
		System.out.println(elonsToyCar.batteryDisplay());

	}

	public static class ElonsToyCar {
		private int distance = 0;
		private int battery = 100;
		
	    public static ElonsToyCar buy() {
	        ElonsToyCar car = new ElonsToyCar();
	        return car;
	    }
	    
	    public String distanceDisplay() {
	        return "Driven " + distance + " meters";
	    
	    }
	    
	    public String batteryDisplay() {
	        String texto = "";
	        if( battery <= 0 ){
	            texto = "Battery empty";
	            
	        } else {
	            texto = "Battery at " + battery + "%";
	        }
	        return texto;
	    }
		
	}


}