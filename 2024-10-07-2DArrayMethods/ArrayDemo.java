import java.util.Arrays;
public class ArrayDemo{
  public static void main(String[]args){
    //write your tests here!
    //You can now use Arrays.toString(yourArray) instead of writing arrayToString again.
    //Compare Arrays.toString(yourArray) to YOUR arrayToString() method to make sure yours is correct
    //do not use any other Arrays.method()

    int[][] test2DArray = new int[][] {
      {},
      {},
      {},
      {}
    };
    System.out.println(
      "Check arrToString: " + (arrToString(test2DArray) == Arrays.deepToString(test2DArray))
    );
    System.out.println(
      "Expected: 0. Output: " + countZeros2D(test2DArray)
    );

    test2DArray = new int[][] {
      {0, 12, 4, -3, -344, 100, 0},
      {},
      {0},
      {2}
    };
    System.out.println(
      "Check arrToString: " + (arrToString(test2DArray) == Arrays.deepToString(test2DArray))
    );
    System.out.println(
      "Expected: 3. Output: " + countZeros2D(test2DArray)
    );


    test2DArray = new int[][]{{1,2},{3}};
    System.out.println(
      "Check arrToString: " + (arrToString(test2DArray) == Arrays.deepToString(test2DArray))
    );

    System.out.println(
      "Expected: <table><tr><td>1</td><td>2</td></tr><tr><td>3</td></tr></table>\n" +
      "Received: " + htmlTable(test2DArray)
    );

    test2DArray = new int[][]{
      {},
      {3, 5, 0, -5}
    };
    System.out.println(
      "Check arrToString: " + (arrToString(test2DArray) == Arrays.deepToString(test2DArray))
    );

    System.out.println(
      "Expected: <table><tr></tr><tr><td>3</td><td>5</td><td>0</td><td>-5</td></tr></table>\n" +
      "Received: " + htmlTable(test2DArray)
    );

  }

  //0. Include your prior methods to help you print a 1D/2D array of ints.
  public static String arrToString(int[] nums) {
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

  //The name of different methods can be the same,
  //as long as the parameters are different! (type and/or quantity must be different)
  //Pro tip: you should be using your 1D arrToString in this method!
  public static String arrToString(int[][]ary){
      String s = "[";
      if (ary.length >= 1){
        s += arrToString(ary[0]);
      }
      if (ary.length > 1){
        for (int i = 1; i < ary.length; i++){
          s += ", " + arrToString(ary[i]);
        }
      }
      return s + "]";
  }

  //1. Calculate and return how many elements equal zero in the 2D array.
  public static int countZeros2D(int[][] nums){
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = 0; j < nums[i].length; j++) {
        if (nums[i][j] == 0) {
          count ++;
        }
      }
    }
    return count;
  }

  //2. Calculate the sum of a 2d array
  /*Return the sum of all of the values in the 2D array
   *Use a nested loop instead of a helper method*/
   public static int arr2DSum(int[][] ary) {
     int out = 0;
     for (int i = 0; i < ary.length; i++) {
       for (int j = 0; j < ary[i].length; j++) {
         out += ary[i][j];
       }
     }

     return out;
   }

  //3. Modify a given 2D array of integer as follows:
  //Replace all the negative values:
  //-When the row number is the same as the column number replace
  //that negative with the value 1
  //-All other negatives replace with 0
  public static void replaceNegative(int[][] vals) {
    for (int i = 0; i < vals.length; i++) {
      for (int j = 0; j < vals[i].length; j++) {
        if (vals[i][j] < 0) {
          if (i == j) {
            vals[i][j] = 1;
          } else {
            vals[i][j] = 0;
          }
        }
      }
    }
  }

  //4. Make a copy of the given 2d array.
  //When testing : make sure that changing the original does NOT change the copy.
  //DO NOT use any built in methods that "copy" an array.
  //You SHOULD write a helper method for this.
  //If you don't see a good way to do that, you should stop and look at prior methods.
  public static int[] copy(int[] nums) {
    int[] newArray = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      newArray[i] = nums[i];
    }

    return newArray;
  }

  public static int[][] copy(int[][] nums){
    int[][] newArray = new int[nums.length][];
    for (int i = 0; i < nums.length; i++) {
      newArray[i] = copy(nums[i]);
    }

    return newArray;
  }

  //5. Rotate an array by returning a new array with the rows and columns swapped.
  //   You may assume the array is rectangular and neither rows nor cols is 0.
  //   e.g. swapRC({{1,2,3},{4,5,6}}) returns {{1,4},{2,5},{3,6}}
  public static int[][] swapRC (int[][] ary) {
    int[][] newArray = new int[ary[0].length][ary.length];

    for (int layerOne = 0; layerOne < ary.length; layerOne++) {
      for (int layerTwo = 0; layerTwo < ary[layerOne].length; layerTwo++){
        newArray[layerTwo][layerOne] = ary[layerOne][layerTwo];
      }

    }
    return newArray;
  }

  //6. Make an HTML table by putting a table tag around the entire 2d array,
  //   tr tags around each row, and td tags around each value.
  //   You may use a helper method
  //   Note there is no whitespace in the string, it all one line with no spaces/tabs.
  //   e.g. htmlTable(new int[][]{{1,2},{3}})  returns:
  // "<table><tr><td>1</td><td>2</td></tr><tr><td>3</td></tr></table>"
  public static String htmlTable(int[][]nums){
    String outputHTML = "<table>";

    for (int i = 0; i < nums.length; i++) {
      outputHTML += "<tr>";
      for (int j = 0; j < nums[i].length; j++) {
        outputHTML += "<td>" + nums[i][j] + "</td>";
      }
      outputHTML += "</tr>";
    }
    outputHTML += "</table>";
    return outputHTML;
  }
}
