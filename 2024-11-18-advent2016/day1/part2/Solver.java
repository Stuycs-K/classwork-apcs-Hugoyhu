import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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

      ArrayList<int[]> coordinateList = new ArrayList<int[]>(1);

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

        int previousX = horDist;
        int previousY = verDist;

        coordinateList.add(new int[]{previousX, previousY});
        boolean verticalChange = false;

        if (dir == 1) {
          verDist += num;
          verticalChange = true;
        } else if (dir == 2) {
          horDist -= num;
        } else if (dir == 3) {
          verDist -= num;
          verticalChange = true;
        } else {
          horDist += num;
        }

        if (coordinateList.size() > 1) {
          for (int j = 1; j < coordinateList.size() - 1; j++) {
            int test1X = coordinateList.get(j-1)[0];
            int test1Y = coordinateList.get(j-1)[1];
            int test2X = coordinateList.get(j)[0];
            int test2Y = coordinateList.get(j)[1];

            if ((test2X - test1X == 0) && (!verticalChange)) {
              // vertical change on test, horizontal on recent
              if ((Math.max(test2Y, test1Y) >= previousY) && (Math.min(test2Y, test1Y) <= previousY) && 
              (Math.max(previousX, horDist) >= test1X) && (Math.min(previousX, horDist) <= test1X)
              ) {
                System.out.println("Intersect: " + test1X + " " + previousY);
                break;
              }

            }

            if ((test2Y - test1Y == 0) && (verticalChange)) {
              // vertical change on recent, horizontal on test
              if ((Math.max(test2X, test1X) >= previousX) && (Math.min(test2X, test1X) <= previousX) && 
              (Math.max(previousY, verDist) >= test1Y) && (Math.min(previousY, verDist) <= test1Y)
              ) {
                System.out.println("Intersect: " + previousX + " " + test1Y);
                break;
              }

            }
          }
        }

        

        
      }

      System.out.println(coordinateList);
      System.out.println(Math.abs(horDist) + Math.abs(verDist));



    } catch (FileNotFoundException ex) {
      //File not found what should you do?
      System.out.println("File not found");
      return; //you can return from a void function just don't put a value.
    }
  }
}
