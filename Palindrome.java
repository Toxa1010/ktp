import java.util.Scanner;
    public class Palindrome {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] words = s.split("\\s");
            for (String word : words) {
                System.out.println(isPalindrome(word));
            }
        }
        public static String reverseString(String s) {
            String a = "";
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                a += c;
            }
            return a;
        }
        public static boolean isPalindrome(String s) {
            String a = reverseString(s);
            return a.equals(s);
        }
}
