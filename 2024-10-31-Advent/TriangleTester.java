import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class TriangleTester {
    public static int countTrianglesA(String filename) {
        try {
            File file = new File(filename);
            Scanner input = new Scanner(file);

            List<List<Integer>> sides = new ArrayList<List<Integer>>();

            while (input.hasNextLine()) {
                String line = input.nextLine();
                Scanner li = new Scanner(line);
                List<Integer> side = new ArrayList<Integer>(3);
                while (li.hasNextInt()) {
                    side.add(li.nextInt());
                }
                sides.add(side);

                li.close();
            }

            input.close();

            // count

            int count = 0;

            for (int i = 0; i < sides.size(); i++) {
                List<Integer> list = sides.get(i);
                int s1 = list.get(0);
                int s2 = list.get(1);
                int s3 = list.get(2);

                if ((s1 + s2) > s3 &&
                        (s1 + s3) > s2 &&
                        (s2 + s3) > s1) {
                    count++;
                }
            }

            return count;

        } catch (FileNotFoundException ex) {
            // File not found what should you do?
            System.out.println("File not found");
            return 0; // you can return from a void function just don't put a value.
        }
    }

    public static int countTrianglesB(String filename) {
        try {
            File file = new File(filename);
            Scanner input = new Scanner(file);

            List<List<Integer>> sides = new ArrayList<List<Integer>>();

            while(input.hasNextLine()) {
                List<List<Integer>> threeSides = new ArrayList<List<Integer>>(3);
                List<Integer> c1 = new ArrayList<Integer>(3);
                List<Integer> c2 = new ArrayList<Integer>(3);
                List<Integer> c3 = new ArrayList<Integer>(3);

                for (int j = 0; j<3; j++) {
                    String line= input.nextLine();
                    Scanner lineInput = new Scanner(line);

                    c1.add(lineInput.nextInt());
                    c2.add(lineInput.nextInt());
                    c3.add(lineInput.nextInt());

                    lineInput.close();
                }
                threeSides.add(c1);
                threeSides.add(c2);
                threeSides.add(c3);

                sides.add(threeSides.get(0));
                sides.add(threeSides.get(1));
                sides.add(threeSides.get(2));
            }

            int count = 0;
            for (int i = 0; i < sides.size(); i++) {
                List<Integer> list = sides.get(i);
                int s1 = list.get(0);
                int s2 = list.get(1);
                int s3 = list.get(2);

                if ((s1 + s2) > s3 &&
                        (s1 + s3) > s2 &&
                        (s2 + s3) > s1) {
                    count++;
                }
            }

            input.close();

            return count;


        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(countTrianglesA("inputTri.txt"));
        System.out.println(countTrianglesB("inputTri.txt"));
    }
}
