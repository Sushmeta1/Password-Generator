import java.util.Scanner;  // ✅ correct way to import

public class UserCreatesPassword {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Create Your Own Password ===");

        System.out.print("Enter your desired password: ");
        String password = scanner.nextLine();

        // Optional: Check password strength
        if (isStrongPassword(password)) {
            System.out.println("Password created successfully!");
        } else {
            System.out.println("Weak password. Please include at least:");
            System.out.println("- 8 characters");
            System.out.println("- At least one uppercase letter");
            System.out.println("- At least one lowercase letter");
            System.out.println("- At least one number");
            System.out.println("- At least one special character (!@#$%^&* etc.)");
        }

        scanner.close();
    }

    // Password strength checker
    public static boolean isStrongPassword(String password) {
        if (password.length() < 8) return false;

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if ("!@#$%^&*()-_=+[]{}|;:'\",.<>?/".indexOf(ch) != -1) hasSpecial = true;
        }

        return hasUpper && hasLower && hasDigit && hasSpecial;
    }
}
