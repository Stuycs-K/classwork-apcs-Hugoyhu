import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Part2 {
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

        ArrayList<String> insideABA = new ArrayList<String>();
        for (int j = 0; j < inside.size(); j++) {
          ArrayList<String> newValues = checkABA(inside.get(j));

          for (int z = 0; z < newValues.size(); z++) {
            insideABA.add(newValues.get(z));
          }
        }

        ArrayList<String> outsideABA = new ArrayList<String>();
        for (int j = 0; j < outside.size(); j++) {
          ArrayList<String> newValues = checkABA(outside.get(j));
          for (int z = 0; z < newValues.size(); z++) {
            outsideABA.add(newValues.get(z));
          }
        }

        boolean stat = false;
        for (int j = 0; j < insideABA.size(); j++) {
            String currentSub = insideABA.get(j);
            for (int z = 0; z < outsideABA.size(); z++) {
                String bob = "" + outsideABA.get(z).charAt(1) + outsideABA.get(z).charAt(0) + outsideABA.get(z).charAt(1);
                if (currentSub.equals(bob)) {
                    stat = true;
                }
            }
        }

        if (stat) {
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

  public static ArrayList<String> checkABA (String str) {
    if (str.length() < 3) {
      return new ArrayList<String>(0);
    }

    ArrayList<String> ABAList = new ArrayList<String>();
    for (int i = 2; i < str.length(); i++) {
      String sub = str.substring(i-2, i+1);
      if (
        (sub.charAt(0) == sub.charAt(2))
        && (sub.charAt(1) != sub.charAt(2))
        ) {
          ABAList.add(sub);
        }
      
    }
    return ABAList;
  }
}
