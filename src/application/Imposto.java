package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.TaxPayer;

public class Imposto {

    private static List<TaxPayer> taxpayers = new ArrayList<>();

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Quantos contribuintes você vai digitar? ");
        int n = scanner.nextInt();

        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.println("Digite os dados do " + (i + 1) + "o contribuinte:");
            System.out.print("Renda anual com salário: ");
            double salaryIncome = scanner.nextDouble();
            System.out.print("Renda anual com prestação de serviço: ");
            double servicesIncome = scanner.nextDouble();
            System.out.print("Renda anual com ganho de capital: ");
            double capitalIncome = scanner.nextDouble();
            System.out.print("Gastos médicos: ");
            double healthSpending = scanner.nextDouble();
            System.out.print("Gastos educacionais: ");
            double educationSpending = scanner.nextDouble();

            System.out.println();

            taxpayers.add(new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending));
        }

        for (int i = 0; i < n; i++) {
            TaxPayer taxpayer = taxpayers.get(i);
            double grossTax = taxpayer.grossTax();
            double taxRebate = taxpayer.taxRebate();
            double netTax = taxpayer.netTax();

            System.out.println("Resumo do " + (i + 1) + "o contribuinte:");
            System.out.println("Imposto bruto total: " + String.format("%.2f", grossTax));
            System.out.println("Abatimento: " + String.format("%.2f", taxRebate));
            System.out.println("Imposto devido: " + String.format("%.2f", netTax));

            System.out.println();
        }
    }
}