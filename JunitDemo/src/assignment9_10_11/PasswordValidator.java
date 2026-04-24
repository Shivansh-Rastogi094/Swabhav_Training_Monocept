package assignment9_10_11;

public class PasswordValidator {

    public boolean isValid(String password) {
        if (password == null || password.isEmpty()) return false;

        boolean hasUpper = password.chars().anyMatch(Character::isUpperCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);

        return password.length() >= 8 && hasUpper && hasDigit;
    }
}