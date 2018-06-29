package Misc;

public class Palindrome {
  public static boolean isPalindrome(String word) {
    String reversedWord = new StringBuilder(word).reverse().toString();
    return (word.compareToIgnoreCase(reversedWord) == 0);
  }

  public static void main(String[] args) {
    System.out.println(Palindrome.isPalindrome("Deleveled"));
  }
}
