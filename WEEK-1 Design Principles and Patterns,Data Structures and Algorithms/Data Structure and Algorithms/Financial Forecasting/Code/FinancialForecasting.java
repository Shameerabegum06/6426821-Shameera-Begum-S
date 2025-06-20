import java.util.Scanner;

public class FinancialForecasting {

    static void explainRecursion() {
        System.out.println("=== Understanding Recursion ===");
        System.out.println("Recursion is a programming technique where a method calls itself.");
        System.out.println("It can simplify problems that can be broken into similar sub-problems.");
        System.out.println("For example, calculating future value year-by-year can be naturally expressed recursively.\n");
    }

    static double futureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        } else {
            return (1 + growthRate) * futureValue(presentValue, growthRate, years - 1);
        }
    }

    static void showComplexityInfo() {
        System.out.println("\n=== Time Complexity Analysis ===");
        System.out.println("Recursive Time Complexity: O(n)");
        System.out.println("Recursive Space Complexity: O(n) due to call stack depth.");
        System.out.println("For large 'years' values, recursion may cause stack overflow.");
        System.out.println("Optimization: Use an iterative loop or formula: FV = PV * (1 + r)^n to compute in O(1) space.\n");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        explainRecursion();

        System.out.println("=== Financial Forecasting Tool ===");

        System.out.print("Enter Present Value (e.g. 1000): ");
        double pv = scanner.nextDouble();

        System.out.print("Enter Annual Growth Rate (e.g. 0.05 for 5%): ");
        double rate = scanner.nextDouble();

        System.out.print("Enter Number of Years: ");
        int years = scanner.nextInt();

        int originalYears = years;

        double fv = futureValue(pv, rate, years);

        System.out.printf("\nPredicted Future Value after %d years: ₹%.2f\n", originalYears, fv);

        showComplexityInfo();

        scanner.close();
    }
}
