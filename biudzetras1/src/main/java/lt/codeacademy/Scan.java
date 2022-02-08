package lt.codeacademy;

import java.util.Scanner;

public class Scan {
  private static Scanner sc = new Scanner(System.in);

  public static String scanLine(){
    return sc.nextLine();
  }

  public static float scanFloat(){
    float result = sc.nextFloat();
    sc.nextLine();
    return result;
  }

  public static boolean scanBoolean(){
    boolean result = sc.nextBoolean();
    sc.nextLine();
    return result;
  }


}
