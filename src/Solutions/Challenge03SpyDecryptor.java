package Solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Challenge03SpyDecryptor {

    public static boolean isValid(String entry) {
        String[] parts = entry.split(":");
        String policy = parts[0].trim();
        String password = parts[1].trim();

        // Split the policy into min, max, and character parts
        String[] policyParts = policy.split(" ");
        String[] minMax = policyParts[0].split("-");
        int min = Integer.parseInt(minMax[0]);
        int max = Integer.parseInt(minMax[1]);
        char character = policyParts[1].charAt(0);

        // Count occurrences of the character in the password
        long count = password.chars().filter(ch -> ch == character).count();

        // Check if the count is within the specified range
        return count >= min && count <= max;
    }

    public static void main(String[] args) {
        String path = "C:\\Users\\zor89\\OneDrive\\Escritorio\\Programación en Java\\Codember\\src\\Solutions\\passwords.txt";

        System.out.println("Absolute Path: " + new File(path).getAbsolutePath());

        int invalidCount = 0;
        int targetInvalidKey = 13; // The invalid key to find

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!isValid(line)) {
                    invalidCount++;
                    if (invalidCount == targetInvalidKey) {
                        System.out.println("The invalid key is: " + line);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
