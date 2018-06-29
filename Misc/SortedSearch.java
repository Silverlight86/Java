package Misc;

import java.util.Arrays;

/*
 * Implement function countNumbers that accepts a sorted array of integers and counts the number of array elements that are less than the parameter lessThan.

    For example, SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4) should return 2 because there are two array elements less than 4.
 */

public class SortedSearch {
  public static int countNumbers(int[] sortedArray, int lessThan) {
    int position = Arrays.binarySearch(sortedArray, lessThan);
    if (position < 0) {
      return (-(position) - 1);
    } else {
      return position;
    }
  }

  public static void main(String[] args) {
    System.out.println(SortedSearch.countNumbers(new int[] {1, 3, 4, 5, 7}, 4));
  }
}
