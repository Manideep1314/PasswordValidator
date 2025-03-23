import java.util.Scanner;

public class PasswordValidator {

    private static final String SPECIAL_CHARACTERS = "~!@#$%^&*()-=+_";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password to validate: ");
        String password = scanner.nextLine();

        if (isValidPassword(password)) {
            System.out.println("✅ Password is valid.");
        } else {
            System.out.println("❌ Password is invalid.");
        }
        scanner.close();
    }

    public static boolean isValidPassword(String password) {
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (SPECIAL_CHARACTERS.contains(String.valueOf(ch))) hasSpecial = true;
        }

        int count = 0;
        if (hasLower) count++;
        if (hasUpper) count++;
        if (hasDigit) count++;
        if (hasSpecial) count++;

        return count >= 3;
    }
}
