package streams;

import java.io.*;
import java.util.Scanner;

public class BlackStreams {
    public static void main(String[] args) {
        try(BufferedReader reader = new BufferedReader(new FileReader("D://temp//notes.txt"));
            Scanner blacklist = new Scanner(new File("D://temp//black_list.txt"));
            FileWriter fr = new FileWriter("D://temp//notes_new.txt");) {

            String s = "";
            String S = null;
            String [] SS = null;
            int kol = 0;
            while ((S = reader.readLine()) != null) {
                SS = S.split("\\.");

                for (String S1 : SS) {
                        s = blacklist.next().replaceAll("[<0-9?!.,\\s>]+", "");
                    if (S1.contains(s)) {
                        kol++;
                        System.out.println("Эти предложения подлежат проверке: " + S1);
                    }
                }
            }
            System.out.println("Столько предложений имеют недопустимые слова: " + kol);
            if (kol == 0) {
                System.out.println("В тексте не встретилось ни одного недопустимого слова!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
