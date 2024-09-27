public class MyArrays {
  public static void main (String[] args) {
    System.out.println(
      "Expected [1, 2, 3, 4, 5], got " + arrayToString(new int[] {1,2,3,4,5})
    );

    System.out.println(
      "Expected [-3, 5, -13, 4, 0], got " + arrayToString(new int[] {-3, 5, -13, 4, 0})
    );

    System.out.println(
      "Expected [], got " + arrayToString(new int[] {})
    );
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
}
