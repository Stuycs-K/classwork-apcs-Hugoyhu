import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Solver {
  public static void main (String[] args) {

    int length = 8;
    try {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
      
        String[] columns = new String[length];

        for (int i = 0; i < length; i++) {
            columns[i] = "";
        }


        while(scan.hasNextLine()) {
            String current = scan.nextLine();
            for (int i = 0; i < length; i++) {
                columns[i] += current.charAt(i);
            }
        }

        String frequent = "";

        for (int i = 0; i < length; i++) {
            // check each column
            int[] counter = new int[26];
            String current = columns[i];


            for (int j = 0; j < current.length(); j++) {
                int charval = current.charAt(j) - 'a';
                counter[charval] += 1;
            }

            for (int j = 0; j < 26; j++) {
                if (counter[j] == 0) {
                    counter[j] = 1000;
                }
            }

            int lowestChar = 0;
            int lowestCount = 10000;
            for (int j = 0; j < counter.length; j++) {
                if (counter[j] < lowestCount) {
                    lowestChar = j;
                    lowestCount = counter[j];
                }
            }

            frequent += "" + (char) (lowestChar + 'a');
        }

        System.out.println(frequent);

        



    } catch (FileNotFoundException ex) {
        //File not found what should you do?
        System.out.println("File not found");
        return; //you can return from a void function just don't put a value.
    }
  }
}
