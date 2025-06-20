import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class EcommerceSearch {

    static class Product {
        int productId;
        String productName;
        String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        @Override
        public String toString() {
            return "Product ID: " + productId + ", Name: " + productName + ", Category: " + category;
        }
    }

    static Product linearSearch(Product[] products, String name) {
        for (Product p : products) {
            if (p.productName.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    static Product binarySearch(Product[] products, String name) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }

        return null;
    }

    static void explainAsymptoticNotation() {
        System.out.println("=== Asymptotic Notation ===");
        System.out.println("Big O notation describes the upper bound of an algorithm's running time as input size grows.");
        System.out.println("Linear Search:");
        System.out.println(" - Best Case: O(1) (if target is first element)");
        System.out.println(" - Average Case: O(n)");
        System.out.println(" - Worst Case: O(n)");
        System.out.println("Binary Search (requires sorted data):");
        System.out.println(" - Best Case: O(1) (if target is middle element)");
        System.out.println(" - Average & Worst Case: O(log n)\n");
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(501, "Computer", "Electronics"),
            new Product(502, "Phone", "Electronics"),
            new Product(503, "TShirt", "Clothing"),
            new Product(504, "Shoes", "Footwear"),
            new Product(505, "BOOKS", "Education")
        };

        Scanner scanner = new Scanner(System.in);

        explainAsymptoticNotation();

        System.out.print("Enter product name to search: ");
        String searchName = scanner.nextLine();

        Product foundLinear = linearSearch(products, searchName);
        System.out.println("\nLinear Search Result:");
        System.out.println(foundLinear != null ? foundLinear : "Product not found.");

        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        Product foundBinary = binarySearch(products, searchName);
        System.out.println("\nBinary Search Result:");
        System.out.println(foundBinary != null ? foundBinary : "Product not found.");

        scanner.close();
    }
}
