import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Solver {
  public static boolean[][] boolTable = {
    {false, false, true, false, false},
    {false, true, true, true, false},
    {true, true, true, true, true},
    {false, true, true, true, false},
    {false, false, true, false, false},
  };

  public static String[][] strTable = {
    {"", "", "1", "", ""},
    {"", "2", "3", "4", ""},
    {"5", "6", "7", "8", "9"},
    {"", "A", "B", "C", ""},
    {"", "", "D", "", ""},
  };

  public static void main (String[] args) {
    try {
      File file = new File("input.txt");
      Scanner scan = new Scanner(file);
      ArrayList<String> instructionList = new ArrayList<String>(1);
      while(scan.hasNextLine()) {
         instructionList.add(scan.nextLine());
      }

      int xCor = 0;
      int yCor = 2;

      String pin = "";

      for (int i = 0; i < instructionList.size(); i++) {
        String currentList = instructionList.get(i);

        for (int j = 0; j < currentList.length(); j++) {
            char c = currentList.charAt(j);
            int[] ret = move(c, xCor, yCor); 

            xCor = ret[0];
            yCor = ret[1];
          }

          System.out.println(xCor + " " + yCor);
          pin += strTable[yCor][xCor];
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

    if (c == 'U') {
      if (checkBounds(xcor, ycor - 1)) {
        ycor -= 1;
      }
    } else if (c == 'D') {
      if (checkBounds(xcor, ycor + 1)) {
        ycor += 1;
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

    return new int[] { xcor, ycor };
  }

  public static boolean checkBounds(int xcor, int ycor) {
    if (xcor < 0 || 4 < xcor || ycor < 0 || 4 < ycor) {
      return false;
    }
    return boolTable[ycor][xcor];
     
  }
}
