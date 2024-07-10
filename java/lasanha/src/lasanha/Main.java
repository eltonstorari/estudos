package lasanha;

public class Main {

	public static void main(String[] args) {
		
		// Criando instancia dos metodos da lasagna 
		Lasagna lasagna = new Lasagna();
		
		System.out.println("Tempo esperado no forno: " + lasagna.expectedMinutesInOven() + " Minutos");
		
		// Paramentro de entrada é referente o tempo que a lasanha Já ficou no forno. 10 minutos
		System.out.println("Tempo que a lasanha ainda precisa ficar no forno: " + lasagna.remainingMinutesInOven(10) + " Minutos");
		
	}
	
	
	public static class Lasagna {

        public int expectedMinutesInOven(){
            return 40;
        }
        
        public int remainingMinutesInOven(int permaneceuNoFogo){
            return expectedMinutesInOven() - permaneceuNoFogo;
        }
	}

}
