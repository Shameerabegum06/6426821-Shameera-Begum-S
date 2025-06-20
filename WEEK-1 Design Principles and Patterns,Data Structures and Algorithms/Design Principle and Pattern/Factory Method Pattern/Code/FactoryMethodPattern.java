import java.util.Scanner;

interface Document {
    void open();
}

class WordDocument implements Document {
    public void open() {
        System.out.println("Opening a Word document.");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening a PDF document.");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening an Excel spreadsheet.");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        System.out.println("Creating a Word document...");
        return new WordDocument();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        System.out.println("Creating a PDF document...");
        return new PdfDocument();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    public Document createDocument() {
        System.out.println("Creating an Excel spreadsheet...");
        return new ExcelDocument();
    }
}

public class FactoryMethodPattern{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Document Manager ===");

        while (true) {
            System.out.print("\nEnter the type of document to open (word/pdf/excel) or 'exit' to quit: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Exiting Document Manager. Goodbye!");
                break;
            }

            DocumentFactory factory = null;

            switch (input) {
                case "word":
                    factory = new WordDocumentFactory();
                    break;
                case "pdf":
                    factory = new PdfDocumentFactory();
                    break;
                case "excel":
                    factory = new ExcelDocumentFactory();
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'word', 'pdf', 'excel', or 'exit'.");
                    continue;
            }

            Document document = factory.createDocument();
            document.open();
        }

        scanner.close();
    }
}
