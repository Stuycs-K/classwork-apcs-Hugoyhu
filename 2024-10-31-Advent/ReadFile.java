//1 you need all three imports.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

  public static void main(String[] args) {
    //2 Opening a file requires a try/catch
    try {
      File file = new File(args[0]);//1
      Scanner input = new Scanner(file);

      //Main.printEachLine(input);

      while (input.hasNextLine()) {
        String line = input.nextLine();
        boolean found = false;
        for (int i = 0; i < line.length(); i++) {
          if (line.charAt(i) == '{')  {
            found = true;
          }
        }

        if (found) {
          System.out.println(line);
        }
      }

      input.close();//releases the file from your program

    } catch (FileNotFoundException ex) {
      //File not found what should you do?
      System.out.println("File not found");
      return; //you can return from a void function just don't put a value.
    }
  }
}