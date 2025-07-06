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

    public String validateDescription(String prompt) {
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
}
