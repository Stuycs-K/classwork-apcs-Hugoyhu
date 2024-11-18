import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Solver {
  public static void main (String[] args) {
    try {
      File file = new File("input.txt");
      Scanner scan = new Scanner(file);
      String raw = "";
      while(scan.hasNextLine()) {
        raw+= scan.nextLine();
      }

      String[] list = raw.split(", ");

      int dir = 1;
      int verDist = 0;
      int horDist = 0;

      for (int i = 0; i < list.length; i++) {
        String current = list[i];
        if (current.charAt(0) == 'L') {
          // left: add 1 to dir.
          dir = (dir + 1) % 4;
        } else {
          dir = (dir + 3) % 4;
        }

        String remain = current.substring(1);
        int num = Integer.valueOf(remain);

        if (dir == 1) {
          verDist += num;
        } else if (dir == 2) {
          horDist -= num;
        } else if (dir == 3) {
          verDist -= num;
        } else {
          horDist += num;
        }
      }

      System.out.println(Math.abs(horDist) + Math.abs(verDist));



    } catch (FileNotFoundException ex) {
      //File not found what should you do?
      System.out.println("File not found");
      return; //you can return from a void function just don't put a value.
    }
  }
}
