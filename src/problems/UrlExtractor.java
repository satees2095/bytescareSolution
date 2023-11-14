package problems;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrlExtractor {
  public static void main(String[] args) {
    String filePath = "path/to/your/text/file.txt"; // Replace with the actual path to your text file
    findAndExtractUrls(filePath);
  }

  private static void findAndExtractUrls(String filePath) {
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      StringBuilder content = new StringBuilder();
      String line;
      while ((line = reader.readLine()) != null) {
        content.append(line).append("\n");
      }

      String text = content.toString();
      Pattern pattern = Pattern.compile("\\b(?:https?|ftp):\\/\\/[-a-zA-Z0-9+&@#\\/=%~_|!:,.;]*[-a-zA-Z0-9+&@#\\/=%~_|]");
      Matcher matcher = pattern.matcher(text);

      if (matcher.find()) {
        String firstOccurrence = matcher.group();
        System.out.println("Occurrence Found: 1 First Occurrence: " + firstOccurrence);
      } else {
        System.out.println("No URL occurrence found in the text file.");
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
