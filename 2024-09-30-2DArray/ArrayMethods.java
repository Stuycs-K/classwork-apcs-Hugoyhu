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

  public static void main (String[] args) {
    // test arrayToString int[]
    System.out.println("\nTesting arrayToString int[]");

    System.out.println(arrToString(new int[] {2, 3, 4, 9}));


    // test arrToString int[][]
    System.out.println("\nTesting arrayToString int[][]");

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
    System.out.println("\nTesting arr2DSum");
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
    System.out.println("\nTesting swapRC");
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

    // test replaceNegative int[][]
    System.out.println("\nTesting replaceNegative");
    int[][] testArray2D = new int[][] {
      {2, 3, -4},
      {-5, -9, -7},
      {2, 4, 0}
    };

    replaceNegative(testArray2D);

    System.out.println(arrToString(testArray2D));

    testArray2D = new int[][] {
      {0, 3, -4},
      {8, -9, -9, -7},
      {}
    };

    replaceNegative(testArray2D);

    System.out.println(arrToString(testArray2D));


    // test copy
    System.out.println("\nTesting copy");
    int[][] original2DArray = new int[][] {
      {0, 3, -4},
      {8, -9, -9, -7},
      {}
    };

    int[][] new2DArray;

    new2DArray = copy(original2DArray);

    System.out.println("New:           " + arrToString(new2DArray));

    original2DArray = new int[][] {
      {0},
      {8, 8, -1},
      {-1,-1}
    };

    System.out.println("Orig. Changed: " + arrToString(new2DArray));



    original2DArray = new int[][] {
      {},
      {},
      {}
    };

    new2DArray = copy(original2DArray);

    System.out.println("New:           " + arrToString(new2DArray));

    original2DArray = new int[][] {
      {0},
      {8, 8, -1},
      {-1,-1}
    };

    System.out.println("Orig. Changed: " + arrToString(new2DArray));


  }
}
