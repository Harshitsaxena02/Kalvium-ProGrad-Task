import java.util.*;

public class SpellOutNumber {

  private static final String[] ONES = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
  private static final String[] TENS = { "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety" };
  private static final String[] THOUSANDS = { "", "thousand", "million", "billion" };

  public static String spellOutNumber(int number) {
    if (number == 0) {
      return "zero";
    }
    int[] parts = splitNumber(number);
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < parts.length; i++) {
      if (parts[i] != 0) {
        builder.append(spellOutPart(parts[i])).append(" ").append(THOUSANDS[parts.length - i - 1]).append(" ");
      }
    }
    return builder.toString().trim();
  }

  private static int[] splitNumber(int number) {
    int[] parts = new int[(int) Math.ceil(Math.log10(number + 1) / 3)];
    for (int i = parts.length - 1; i >= 0; i--) {
      parts[i] = number % 1000;
      number /= 1000;
    }
    return parts;
  }

  private static String spellOutPart(int part) {
    StringBuilder builder = new StringBuilder();
    int hundreds = part / 100;
    if (hundreds > 0) {
      builder.append(ONES[hundreds]).append(" hundred ");
    }
    part %= 100;
    if (part < 20) {
      builder.append(ONES[part]);
    } else {
      int tens = part / 10;
      int ones = part % 10;
      builder.append(TENS[tens]).append("-").append(ONES[ones]);
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a number: ");
    int number = scanner.nextInt();
    System.out.println(spellOutNumber(number));
  }
}