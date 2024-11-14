import java.util.ArrayList;

public class ArrayListPractice {
  public static ArrayList<String> createRandomArray(int size) {
    int n = 0;
    ArrayList<String> stringList = new ArrayList<String>(size);

    while(n < size) {
      int random = (int)(11.0 * Math.random());
      if (random == 0) {
        stringList.add("");
      } else {
        stringList.add("" + random);
      }
      n++;
    }

    return stringList;
  }

  public static void replaceEmpty (ArrayList<String> original) {
    for (int i = 0; i < original.size(); i++) {
      if (original.get(i).equals("")) {
        original.set(i, "Empty");
      }
    }
  }
}
