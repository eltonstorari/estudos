package salaryCalculator;

public class main {
	


	public static void main(String[] args) {
		
        SalaryCalculator calculator = new SalaryCalculator();

        // Teste da função salaryMultiplier()
        int daysSkipped = 15;
        double salaryMultiplier = calculator.salaryMultiplier(daysSkipped);
        System.out.println("Salário Multiplicado: " + salaryMultiplier);

        // Teste da função bonusMultiplier()
        int productsSold = 15;
        int bonusMultiplier = calculator.bonusMultiplier(productsSold);
        System.out.println("Bonus Multiplicado: " + bonusMultiplier);

        // Teste da função bonusForProductsSold()
        double bonus = calculator.bonusForProductsSold(productsSold);
        System.out.println("Bonus por Produtos vendidos: " + bonus);

        // Teste da função finalSalary()
        double finalSalary = calculator.finalSalary(daysSkipped, productsSold);
        System.out.println("Salário Final: " + finalSalary);
	}
	

	public static class SalaryCalculator {
	    public double salaryMultiplier(int daysSkipped) {
	       return (daysSkipped < 20) ? 0.85 : 1.0;
	    }

	    public int bonusMultiplier(int productsSold) {
	    	return (productsSold < 20) ? 10 : 13;
	    }

	    public double bonusForProductsSold(int productsSold) {
	        int multiplier = bonusMultiplier(productsSold);
            return productsSold * multiplier;
	    }

	    public double finalSalary(int daysSkipped, int productsSold) {
	        int multiplier = bonusMultiplier(productsSold);
            double v1 =  productsSold * multiplier;
            double v2 = v1 + (salaryMultiplier(daysSkipped) * 1000);
    
    return (v2 > 2000) ? 2000 : v2;
	    } 
	}
}


