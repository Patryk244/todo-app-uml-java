import java.util.Scanner;
import java.util.regex.*;

public class InputValidator {
    protected String myRegex;
    Scanner scanner;
    String input;

    public InputValidator() {
        this.scanner = new Scanner(System.in);
        this.myRegex = "^(?=(?:.*[A-Za-z]){10,}).*$";
    }

    public String getValidDescription(String prompt) {
        System.out.println("Attention: The text contains at least 10 letters!");
        while (true) {
            System.out.println(prompt);
            input = scanner.nextLine();
            Pattern pattern = Pattern.compile(myRegex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.matches()) {
                System.out.println("All right");
                return input;
            } else {
                System.out.println("Notification: The text contains at least 10 letters.");
            }
        }
    }

    public int getValidId() {
        int id;
        while (true) {
            System.out.print("Podaj ID zadania: ");
            String input = scanner.nextLine();

            try {
                id = Integer.parseInt(input);
                if (id >= 0) {
                    return id;
                } else {
                    System.out.println("❗ ID nie może być ujemne.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❗ To nie jest poprawna liczba całkowita. Spróbuj ponownie.");
            }
        }
    }

}
