public class ArrayMethods {
  // Hugo Hu, hhu60@stuy.edu, Skylar Huang, shuang60@stuy.edu
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

  public static int arr2DSum(int[][] ary) {
    int out = 0;
    for (int i = 0; i < ary.length; i++) {
      for (int j = 0; j < ary[i].length; j++) {
        out += ary[i][j];
      }
    }

    return out;
  }

  public static int[][] swapRC (int[][] ary) {
    int[][] newArray = new int[ary[0].length][ary.length];

    for (int layerOne = 0; layerOne < ary.length; layerOne++) {
      for (int layerTwo = 0; layerTwo < ary[layerOne].length; layerTwo++){
        newArray[layerTwo][layerOne] = ary[layerOne][layerTwo];
      }
      
    }
    return newArray;
  }

  public static void main (String[] args) {
    // test arrayToString int[]
    System.out.println(arrToString(new int[] {2, 3, 4, 9}));


    // test arrToString int[][]
    System.out.println(arrToString(new int[][] {
      {2, 3, 4},
      {5, 6, 7},
      {2, 4, 0}
    }));

    System.out.println(arrToString(new int[][] {
      {},
      {5, 6, 7, -5, 5},
      {2, 4, 0}
    }));

    System.out.println(arrToString(new int[][] {
      {},
      {},
      {}
    }));

    // test arr2DSum int[][]
    System.out.println(arr2DSum(new int[][] {
      {2, 3, 4},
      {5, 6, 7},
      {2, 4, 0}
    }));

    System.out.println(arr2DSum(new int[][] {
      {},
      {5, 6, 7, -5, 5},
      {2, 4, 0}
    }));

    System.out.println(arr2DSum(new int[][] {
      {},
      {},
      {}
    }));


    // test swapRC int[][]
    System.out.println(arrToString(swapRC(new int[][] {
      {2, 3, 4},
      {5, 6, 7},
      {2, 4, 0}
    })));

    System.out.println(arrToString(swapRC(new int[][] {
      {2, 3, 4, 3, 5},
      {5, 6, 7, 2, 2},
      {2, 4, 0, -5, 0}
    })));

    System.out.println(arrToString(swapRC(new int[][] {
      {1},
      {1},
      {1}
    })));


  }
}
