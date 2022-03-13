import java.util.Arrays;
import java.util.Scanner;

public class sort {
   public static void main(String[] args) {
      int arr[] = new int[5];
      int i;
      arr[0] = 10;
      arr[1] = 20;
      arr[2] = -9;
      arr[3] = 8;
      arr[4] = 98;
      int min = 0, max = 0;
      for (i = 0; i < 5; i++) {
         if (max < arr[i])
            max = arr[i];
         if (min > arr[i])
            min = arr[i];
      }
      System.out.println("数组的最大值是:" + max);
      System.out.println("数组的最小值是:" + min);
      //
      System.out.println("think test 1");
      int arr2[] = new int[5];
      arr2 = arr;
      Arrays.sort(arr2, 0, 5);
      for (int j = 0; j < 5; ++j) {
         System.out.println(arr[j]);
      }

      System.out.println("think test 2");
      int x = 98;
      for (int j = 0; j < 5; ++j) {
         if (arr[j] == x) {
            System.out.println("value = 98 " + "index = " + j);
         }
      }

   }
}
