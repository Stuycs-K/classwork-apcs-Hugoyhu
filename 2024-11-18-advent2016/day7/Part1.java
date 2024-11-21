import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Part1 {
  public static void main (String[] args) {
    try {
      File file = new File("input.txt");
      Scanner scan = new Scanner(file);
      ArrayList<String> IPList = new ArrayList<String>(1);
      while(scan.hasNextLine()) {
         IPList.add(scan.nextLine());
      }

      int total = 0;

      for (int i = 0; i < IPList.size(); i++) {
        // for each IP
        String IP = IPList.get(i);

        String sub = "";
        boolean inBrackets = false;

        ArrayList<String> outside = new ArrayList<String>();
        ArrayList<String> inside = new ArrayList<String>();

        for (int j = 0; j < IP.length(); j++) {
          char current = IP.charAt(j);
          if (current == '[') {
            outside.add(sub);
            inBrackets = true;
            sub = "";
          } else if (current == ']') {
            inside.add(sub);
            inBrackets = false;
            sub = "";
          } else if (j == IP.length() - 1) {
            sub+= current;
            outside.add(sub);
          } else {
            sub += current;
          }
        }

        boolean status = true;
        for (int j = 0; j < inside.size(); j++) {
          if (checkABBA(inside.get(j))) {
            status = false;
          }
        }

        boolean inOutside = false;
        if (status) {
          for (int j = 0; j < outside.size(); j++) {
            if (checkABBA(outside.get(j))) {
              inOutside = true;
            }
          }
        }

        if (inOutside) {
          total++;
        }


      }

      System.out.println(total);


      


    }catch(

  FileNotFoundException ex)
  {
    // File not found what should you do?
    System.out.println("File not found");
    return; // you can return from a void function just don't put a value.
  }
  }

  public static boolean checkABBA (String str) {
    if (str.length() < 4) {
      return false;
    }

    for (int i = 3; i < str.length(); i++) {
      String sub = str.substring(i-3, i+1);
      if (
        (sub.charAt(0) == sub.charAt(3))
        && (sub.charAt(1) == sub.charAt(2))
        && (sub.charAt(1) != sub.charAt(2))
        ) {
          return true;
        }
      
    }
    return false;
  }
}
