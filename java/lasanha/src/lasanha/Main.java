package lasanha;

public class Main {

	public static void main(String[] args) {
		
		// Criando instancia dos metodos da lasagna 
		Lasagna lasagna = new Lasagna();
		
		System.out.println("Tempo esperado no forno: " + lasagna.expectedMinutesInOven() + " Minutos");
		
	}
	
	
	public static class Lasagna {

        public int expectedMinutesInOven(){
            return 40;
        }
	}

}
