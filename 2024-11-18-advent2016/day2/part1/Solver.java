import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Solver {
  public static void main (String[] args) {
    try {
      File file = new File("input.txt");
      Scanner scan = new Scanner(file);
      ArrayList<String> instructionList = new ArrayList<String>(1);
      while(scan.hasNextLine()) {
         instructionList.add(scan.nextLine());
      }

      int xCor = 2;
      int yCor = 3;

      String pin = "";

      for (int i = 0; i < instructionList.size(); i++) {
        String currentList = instructionList.get(i);

        for (int j = 0; j < currentList.length(); j++) {
            char c = currentList.charAt(j);
            int[] ret = move(c, xCor, yCor); 

            xCor = ret[0];
            yCor = ret[1];
          }

          System.out.println(xCor);
          System.out.println(yCor + '\n');
          pin += xCor + yCor;
        }

        System.out.println(pin);


      


    }catch(

  FileNotFoundException ex)
  {
    // File not found what should you do?
    System.out.println("File not found");
    return; // you can return from a void function just don't put a value.
  }
  }

  public static int[] move(char c, int xcor, int ycor) {
    System.out.println(xcor);
    System.out.println(ycor);


    if (c == 'U') {
      if (checkBounds(xcor, ycor - 3)) {
        ycor -= 3;
      }
    } else if (c == 'D') {
      if (checkBounds(xcor, ycor + 3)) {
        ycor += 3;
      }
    } else if (c == 'L') {
      if (checkBounds(xcor - 1, ycor)) {
        xcor -= 1;
      }
    } else {
      if (checkBounds(xcor + 1, ycor)) {
        xcor += 1;
      }
    }

    System.out.println(c);
    System.out.println("\n" + xcor);
    System.out.println(ycor + "\n\n");

    return new int[] { xcor, ycor };
  }

  public static boolean checkBounds(int xcor, int ycor) {
    return (1 <= xcor && xcor <= 3) && (ycor == 0 || ycor == 3 || ycor == 6);
  }
}
