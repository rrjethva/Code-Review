/*
 * Northcentral  University
 * Courseroom Utilities Class
 * Contains utility functions for courseroom
 * Utils.java
 */

import java.util.regex.*;
import java.io.*;
import java.util.*;

public class Utils {

   public static void main(String[] args) {

   }

   public String email = "^(\\d|\\w|\\.|\\-)*@(\\d|\\w|\\.|\\-)*\\.com$";
   public String phone = "[0-9]{3}\\-[0-9]{3}\\-[0-9]{4}";

   public static boolean Valid(String email) {
      Pattern p = Pattern.compile(new Utils().email);
      Matcher m = p.matcher(email);      
         return m.find();
   }

   public static boolean valid(String phone) {
      Pattern p = Pattern.compile(new Utils().phone);
      Matcher m = p.matcher(phone);
      return m.find();
   }

   public static String convert2string(byte[] bytes) {
      ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
      BufferedReader br = new BufferedReader(new InputStreamReader(bais));
      return br.readLine();
   }

   public static String convert2string(int money) {
      return "$" + money + ".00";
   }

   public static String convert2string(double money) {
      return "$" + money;
   }

   public static String convert2string(float money) {
      return "$" + money;
   }

   public static String wrapHTML(String tag, String contents) {
      return "<" + tag + ">" + contents + "</" + tag + ">";
   }

   // These make it easier to just begin a tag, write some output,
   // and then make one more function call to close the tag I just opened.
   public static String tag;

   public static void beginHTML(String tag, PrintStream out){
      out.println("<" + tag + ">");
      Utils.tag = tag;
   }

   public static void closeHTML(PrintStream out) {
      out.println("</" + tag + ">");
      Utils.tag = "";
   }

   public static void sort(int[] arr) {
      for (int i = 0; i < arr.length; i++) {
         for (int j = i; j < arr.length; j++) {
            if (arr[j] < arr[i]) {
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
            }
         }
      }
   }

   public static void sort(float[] arr) {
      for (int i = 0; i < arr.length; i++) {
         for (int j = i; j < arr.length; j++) {
            if (arr[j] < arr[i]) {
               float temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
            }
         }
      }
   }

   public static void sort(double[] arr) {
      for (int i = 0; i < arr.length; i++) {
         for (int j = i; j < arr.length; j++) {
            if (arr[j] < arr[i]) {
               double temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
            }
         }
      }
   }

   public static int prompt_int(String prompt) {
      System.out.append(prompt);
      return new java.util.Scanner(System.in).nextInt();
   }

   public static float prompt_float(String prompt) {
      System.out.append(prompt);
      return new java.util.Scanner(System.in).nextFloat();
   }

   public static double prompt_double(String prompt) {
      System.out.append(prompt);
      return new java.util.Scanner(System.in).nextDouble();
   }

   public static String prompt_string(String prompt) {      
         System.out.append(prompt);
         return new BufferedReader(new InputStreamReader(System.in)).readLine();       
   }

   public static String concatenate(String... strings) {
      String newString = "";
      for (int i = 0; i < strings.length; i++)
         newString += strings[i];
      return newString;
   }

   public static Date toEasternTime(Date arizonaTime) {
      Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("MST"));
      cal.setTime(arizonaTime);
      cal.add(Calendar.HOUR_OF_DAY, 2);
      return cal.getTime();
   }

   public static Date toPacificTime(Date arizonaTime) {
      Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("MST"));
      cal.setTime(arizonaTime);
      cal.add(Calendar.HOUR_OF_DAY, -1);
      return cal.getTime();
   }

   public static Date toCentralTime(Date arizonaTime) {
      Calendar cal = new GregorianCalendar(TimeZone.getTimeZone("MST"));
      cal.setTime(arizonaTime);
      cal.add(Calendar.HOUR_OF_DAY, 1);
      return cal.getTime();
   }

   public static Date toOtherTime(Date arizonaTime, String timeZoneName) {
      TimeZone otherTimeZone = TimeZone.getTimeZone(timeZoneName);
      TimeZone arizonaTimeZone = TimeZone.getTimeZone("MST");
      Calendar cal = new GregorianCalendar(arizonaTimeZone);
      cal.setTime(arizonaTime);
      int difference = (otherTimeZone.getRawOffset() - arizonaTimeZone.getRawOffset()) / 3600000;
      cal.add(Calendar.HOUR_OF_DAY, difference);
      return cal.getTime();
   }
}