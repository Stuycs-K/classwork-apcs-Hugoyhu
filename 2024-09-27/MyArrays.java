public class MyArrays {
  public static void main (String[] args) {
    // test cases for arrayToString
    System.out.println(
      "Expected [1, 2, 3, 4, 5], got " + arrayToString(new int[] {1,2,3,4,5})
    );

    System.out.println(
      "Expected [-3, 5, -13, 4, 0], got " + arrayToString(new int[] {-3, 5, -13, 4, 0})
    );

    System.out.println(
      "Expected [], got " + arrayToString(new int[] {})
    );


    // test cases for returnCopy
    int[] testIntArray = new int[] {1,2,3,4,5};
    int[] newCopy = returnCopy(testIntArray);

    System.out.println(
      "Original: " + testIntArray + "\nNew: " +  newCopy+
      "\nExpected: " + arrayToString(testIntArray) + ", got " + arrayToString(newCopy)
    );

    testIntArray = new int[] {};
    newCopy = returnCopy(testIntArray);

    System.out.println(
      "Original: " + testIntArray + "\nNew: " +  newCopy+
      "\nExpected: " + arrayToString(testIntArray) + ", got " + arrayToString(newCopy)
    );

    testIntArray = new int[] {0, -3, -56, 23030};
    newCopy = returnCopy(testIntArray);

    System.out.println(
      "Original: " + testIntArray + "\nNew: " +  newCopy+
      "\nExpected: " + arrayToString(testIntArray) + ", got " + arrayToString(newCopy)
    );


    // test concatArray
    

  }

  public static String arrayToString(int[] nums) {
    String s = "[";

    if (nums.length >= 1) {
      s += nums[0];
    }

    if (nums.length > 1) {
      for (int i = 1; i < nums.length; i++) {
        s += ", " + nums[i];
      }
    }

    s += "]";

    return s;
  }

  public static int[] returnCopy(int[] ary) {
    int[] newAry = new int[ary.length];
    for (int i = 0; i < ary.length; i++) {
      newAry[i] = ary[i];
    }
    return newAry;
  }
}
