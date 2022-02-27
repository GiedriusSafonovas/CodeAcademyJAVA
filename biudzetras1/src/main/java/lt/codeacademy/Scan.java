package lt.codeacademy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Scan {
  private static Scanner sc = new Scanner(System.in);

  public static String scanLine() {
    return sc.nextLine();
  }

  public static float scanFloat() {
    while (true) {
      try {
        float result = sc.nextFloat();
        sc.nextLine();
        return result;
      } catch (InputMismatchException e) {
        System.out.println("Klaida! Ivestas ne skaicius, bandykite dar karta");
        sc.nextLine();
      }
    }
  }

  public static boolean scanBoolean() {
    while (true) {
      try {
        boolean result = sc.nextBoolean();
        sc.nextLine();
        return result;
      } catch (InputMismatchException e) {
        System.out.println("Klaida! Ivesta neteisinga reiksme (true/false), bandykite dar karta");
        sc.nextLine();
      }
    }
  }

  public static LocalDate scanDate() {
    while (true) {
      try {
        String data = sc.nextLine();
        if (data.equals("")) {
          return LocalDate.now();
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(data, format);
      } catch (DateTimeParseException e) {
        System.out.println(
            "Klaida! Ivestas neteisingas datos formatas (yyyy-MM-dd), bandykite dar karta");
      }
    }
  }

  public static LocalDateTime scanDateTime() {
    while (true) {
      try {
        String data = sc.nextLine();
        if (data.equals("")) {
          return LocalDateTime.now();
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
        return LocalDateTime.parse(data, format);
      } catch (DateTimeParseException e) {
        System.out.println(
            "Klaida! Ivestas neteisingas datos formatas (yyyy-MM-dd hh:mm), bandykite dar karta");
      }
    }
  }
}
