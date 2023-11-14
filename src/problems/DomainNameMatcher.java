package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DomainNameMatcher {

    public static void main(String[] args) {
      String inputDomain = "google.com";
      List<String> domainList = new ArrayList<>();
      domainList.add("thegoogle.com");
      domainList.add("good.go");
      domainList.add("google.co.in");
      domainList.add("bing.com");

      domainList.forEach(domain -> {
        double similarity = calculateDomainSimilarity(inputDomain, domain);
        System.out.println(inputDomain + " matches " + domain + " with " + (similarity * 100) + "%");
      });
    }

    public static double calculateDomainSimilarity(String domain1, String domain2) {
      int lengthDifference = Math.abs(domain1.length() - domain2.length());
      int maxLength = Math.max(domain1.length(), domain2.length());
      double lengthSimilarity = 1 - (double) lengthDifference / maxLength;
      System.out.println(lengthSimilarity);

      String[] parts1 = domain1.split("\\.");
      String[] parts2 = domain2.split("\\.");

      int matchingParts = (int) IntStream.range(0, Math.min(parts1.length, parts2.length))
          .filter(i -> parts1[i].equals(parts2[i]))
          .count();

      double structureSimilarity = (double) matchingParts / Math.max(parts1.length, parts2.length);

      return (lengthSimilarity + structureSimilarity) / 2;
    }
}
