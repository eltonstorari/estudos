package lasanha;

public class Main {

	public static void main(String[] args) {
		
		// Criando instancia dos metodos da lasagna 
		Lasagna lasagna = new Lasagna();
		
		System.out.println("Tempo esperado no forno: " + lasagna.expectedMinutesInOven() + " Minutos");
		
		// Paramentro de entrada é referente o tempo que a lasanha Já ficou no forno. 10 minutos
		System.out.println("Tempo que a lasanha ainda precisa ficar no forno: " + lasagna.remainingMinutesInOven(10) + " Minutos");
		
		// paramento de entrada e quantas camadas é preciso para fazer a lasanha e retorna o tempo de preparo 20 * 2 = 40 min
		System.out.println("A lasanha ficará pronta em: " + lasagna.preparationTimeInMinutes(20));
		
		// Paramentro de entrada 20 camadas e 40 minutos de forno que retorna o tempo total gasto cozinhando a lasanha
		System.out.println("Total de tempo trabalhado para cozinhar a lasanha: " + lasagna.totalTimeInMinutes(20, 40) + "Minutos");
		
		// Instancia de calculos que o projeto inicialmente pede
		int sum = new Calculator().add(1, 2);
		System.out.println("Calculo -> " + sum);
		
	}
	
	
	public static class Lasagna {

        public int expectedMinutesInOven(){
            return 40;
        }
        
        public int remainingMinutesInOven(int permaneceuNoFogo){
            return expectedMinutesInOven() - permaneceuNoFogo;
        }
        
        public int preparationTimeInMinutes(int qtdeCamadas){
            return qtdeCamadas * 2;
        }
        
        public int totalTimeInMinutes(int nCamadasAdd, int nMinutosNoForno){
            int n = preparationTimeInMinutes(nCamadasAdd);
            return  n + nMinutosNoForno;
        }
	}
	
	public static class  Calculator {
        public int add(int x, int y) {
        return x + y;
    }
}

}
