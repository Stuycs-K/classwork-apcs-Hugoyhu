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

  public static ArrayList<String> makeReversedList( ArrayList<String> original) {
    ArrayList<String> ans = new ArrayList<String>(original.size());
    for (int i = original.size() - 1; i >= 0; i--) {
      ans.add(original.get(i));
    }
    return ans;
  }

  public static ArrayList<String> mixLists( ArrayList<String> a,  ArrayList<String> b){
    int minSize = Math.min(a.size(), b.size());
    ArrayList<String> newList = new ArrayList<String>(a.size() + b.size());

    for (int i = 0; i < minSize; i++) {
      newList.add(a.get(i));
      newList.add(b.get(i));
    }

    if (a.size() > b.size()) {
      for (int i = b.size(); i < a.size(); i++) {
        newList.add(a.get(i));
      } 
    } else if (a.size() < b.size()) {
      for (int i = a.size(); i < b.size(); i++) {
        newList.add(b.get(i));
      }
    }

    return newList;
  } 
  

}
