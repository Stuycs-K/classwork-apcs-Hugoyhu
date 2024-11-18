import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Solver {
  public static void main (String[] args) {
    try {
      File file = new File("input.txt");
      Scanner scan = new Scanner(file);
      ListArray<String> instructionList = new ListArray<String>(1);
      while(scan.hasNextLine()) {
         instructionList.add(scan.nextLine());
      }

      int xCor = 2;
      int yCor = 3;

      for (int i = 0; i < instructionList.size(); i++) {
        Scanner scanEach = new Scanner(instructionList.get(i));
        ListArray<String> currentList = new ListArray<String>(1);
        while (scanEach.hasNextLine()) {
          currentList.add(scanEach.nextLine());
        }


      }


    } catch (FileNotFoundException ex) {
      //File not found what should you do?
      System.out.println("File not found");
      return; //you can return from a void function just don't put a value.
    }
  }
}
