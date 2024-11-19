import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SCTT {
    public static void main (String[] args) {
      //System.out.println(isTri(5, 5, 2));
      System.out.println(countTrianglesA("inputTri.txt"));
    }
  
    public static int countTrianglesA(String filename) {
      int counter = 0;
      int x, y, z = 0;
      File file = new File(filename);//1
      Scanner input = new Scanner(file);
      while(input.hasNextLine()) {
        x = input.nextInt();
        y = input.nextInt();
        z = input.nextInt();
        if (isTri(x, y, z)) {
            counter++;
        }
      }
  
  
  
  
      input.close();
      return counter;
    }
  
    public static boolean isTri(int a, int b, int c) {
      return (a + b > c && a + c > b && b + c > a);
    }
  
  }