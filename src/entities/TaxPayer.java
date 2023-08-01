package entities;

public class TaxPayer {
    private double salaryIncome;
    private double servicesIncome;
    private double capitalIncome;
    private double healthSpending;
    private double educationSpending;

    public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
            double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double salaryTax() {
        if (salaryIncome / 12 < 3000) {
            return 0;
        } else if (salaryIncome / 12 < 5000) {
            return salaryIncome * 0.1;
        } else {
            return salaryIncome * 0.2;
        }
    }

    public double servicesTax() {
        return servicesIncome * 0.15;
    }

    public double capitalTax() {
        return capitalIncome * 0.2;
    }

    public double grossTax() {
        return salaryTax() + servicesTax() + capitalTax();
    }

    public double taxRebate() {
        double maxDeduction = 0.3 * grossTax();
        double healthEduExpenses = healthSpending + educationSpending;
        double totalDed = 0;

        if (healthEduExpenses > maxDeduction) {
            totalDed = maxDeduction;
            return totalDed;
        } else {
            totalDed = healthEduExpenses;
            return totalDed;
        }
    }

    public double netTax() {
        return grossTax() - taxRebate();
    }
}
