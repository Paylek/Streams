package streams;

import java.io.*;
import java.util.Scanner;


public class Palindrome {
    public static void main(String[] args) throws  IOException {
        try ( FileWriter fr = new FileWriter("D://temp//notes_new.txt");
              Scanner in = new Scanner(new File("D://temp//notes.txt"));) {

            String s = "";
            while (in.hasNext()) {
                s = in.next().replaceAll("[<0-9?!.,\\s>]+", "");
                if (isPalindrome(s)) {
                    System.out.println(s);
                    fr.write(" " + s);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static boolean isPalindrome(String str) {
        return str.equalsIgnoreCase(new StringBuilder(str).reverse().toString());
    }
}
