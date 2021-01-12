/**
 * Multidimensional Arrays:
 * datatype[][] arr;
 * 
 * 
 * Object arrays
 */


package com.hexaware.samplecodes.demopack;

public class Tutorial110121 {
  public void array2D() {
    int[][] arr1 = new int[3][3];

    // int[][] arr = {{1,2,3},
    //                {4,5,6},
    //                {7,8,9}};
    
    for(int row = 0; row < 3; row++){
      for(int col = 0; col < 3; col++){
        arr1[row][col] = row + col + 2;
      }
    }

    for(int row = 0; row < 3; row++){
      for(int col = 0; col < 3; col++){
        System.out.print(arr1[row][col] + " ");
      }
      System.out.println();
    }
  }
}
