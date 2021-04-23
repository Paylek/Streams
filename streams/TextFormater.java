package streams;

import java.io.*;

public class TextFormater {

    public static void main(String[] args) {

        try(BufferedReader reader = new BufferedReader(new FileReader("D://temp//notes.txt"));
            FileWriter fr = new FileWriter("D://temp//notes_new.txt");) {

            String S = null;
            String [] SS = null;
            while ((S = reader.readLine()) != null) {
                SS= S.split("\\.");
                for (String S1 : SS) {

                    if (kolWork(S1) >= 3 && kolWork(S1) <= 5) {
                        System.out.println(S1);
                        fr.write(S1 + " ");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int kolWork(String str) {
        int count = 0;

        //Если ввели хотя бы одно слово, тогда считать, иначе конец программы
        if(str.length() != 0){
            count++;
            //Проверяем каждый символ, не пробел ли это
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == ' '){
                    //Если пробел - увеличиваем количество слов на 1
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isPalindrome(String str) {
        return str.equalsIgnoreCase(new StringBuilder(str).reverse().toString());
    }
}