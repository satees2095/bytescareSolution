package problems;

import java.util.HashMap;

public class HindiToEnglishConverter {
  private HashMap<String, String> dictionary;

  public HindiToEnglishConverter() {
    // Initialize the dictionary with some sample translations (you can expand this)
    dictionary = new HashMap<>();
    dictionary.put("नमस्ते", "Hello");
    dictionary.put("कैसे", "How");
    dictionary.put("हो", "are");
    // Add more words and their translations to the dictionary
  }

  public String convertToEnglish(String hindiText) {
    // Split the Hindi text into words
    String[] words = hindiText.split("\\s+");

    StringBuilder englishText = new StringBuilder();

    // Convert each word from Hindi to English (if available in the dictionary)
    for (String word : words) {
      // Check if the word exists in the dictionary
      if (dictionary.containsKey(word)) {
        // Append the English translation of the word
        englishText.append(dictionary.get(word)).append(" ");
      } else {
        // If the word is not found in the dictionary, keep the original word
        englishText.append(word).append(" ");
      }
    }

    return englishText.toString().trim();
  }

  public static void main(String[] args) {
    HindiToEnglishConverter converter = new HindiToEnglishConverter();

    // Example Hindi text
    String hindiText = "नमस्ते कैसे हो";

    // Convert Hindi text to English
    String englishText = converter.convertToEnglish(hindiText);

    // Output the converted text
    System.out.println("Hindi Text: " + hindiText);
    System.out.println("English Text: " + englishText);
  }
}
