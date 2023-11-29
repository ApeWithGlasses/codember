package Solutions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Challenge04Savipo {
    public static void main(String[] args) {
        String path = "C:\\Users\\zor89\\OneDrive\\Escritorio\\Programación en Java\\Codember\\src\\Solutions\\checksum.txt";
        System.out.println("Absolute Path: " + new File(path).getAbsolutePath());

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            int realFileCount = 0;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("-");
                String fileName = parts[0];
                String checksum = parts[1];

                if (isValidChecksum(fileName, checksum)) {
                    realFileCount++;

                    if (realFileCount == 33) {
                        System.out.println("Checksum of the 33rd real file: " + checksum);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static boolean isValidChecksum(String fileName, String checksum) {
        StringBuilder uniqueChars = new StringBuilder();

        for (char ch : fileName.toCharArray()) {
            if (fileName.indexOf(ch) == fileName.lastIndexOf(ch)) {
                uniqueChars.append(ch);
            }
        }

        return uniqueChars.toString().equals(checksum);
    }
}
