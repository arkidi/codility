package binarysearch;

/*
    You are given integers K, M and a non-empty array A consisting of N integers. Every element of the array is not greater than M.

    You should divide this array into K blocks of consecutive elements. The size of the block is any integer between 0 and N. Every element of the array should belong to some block.

    The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y]. The sum of empty block equals 0.

    The large sum is the maximal sum of any block.

    For example, you are given integers K = 3, M = 5 and array A such that:

      A[0] = 2
      A[1] = 1
      A[2] = 5
      A[3] = 1
      A[4] = 2
      A[5] = 2
      A[6] = 2
    The array can be divided, for example, into the following blocks:

    [2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
    [2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
    [2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
    [2, 1], [5, 1], [2, 2, 2] with a large sum of 6.
    The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.

    Write a function:

    class Solution { public int solution(int K, int M, int[] A); }

    that, given integers K, M and a non-empty array A consisting of N integers, returns the minimal large sum.

    For example, given K = 3, M = 5 and array A such that:

      A[0] = 2
      A[1] = 1
      A[2] = 5
      A[3] = 1
      A[4] = 2
      A[5] = 2
      A[6] = 2
    the function should return 6, as explained above.

    Write an efficient algorithm for the following assumptions:

    N and K are integers within the range [1..100,000];
    M is an integer within the range [0..10,000];
    each element of array A is an integer within the range [0..M].
 */

public class MinMaxDivision {

    public static void main(String[] args) {
        int[] A = new int[]{2, 1, 5, 1, 2, 2, 2};
        int M = 5;
        int K = 3;
        System.out.println(solution(K, M, A));

    }

    public static int solution(int k, int m, int[] a) {
        int sum = 0;
        int largestEl = 0;
        for (int i = 0; i < a.length; i++) {
            largestEl = largestEl >= a[i] ? largestEl : a[i];
            sum += a[i];
        }

        int idealMin = Math.max((int)Math.ceil(sum/k), largestEl);
        System.out.printf("idealMin:%d, largestEl:%d\n", idealMin, sum); //idealMin:5, largestEl:15

        return binarySearchIterative(idealMin, sum, a, k);
    }

    public static int binarySearchIterative(int min, int max, int[] a, int k) {
        int res = 0;
        int beg = min;
        int end = max;

        while (beg <= end) {
            int middle = (beg + end) / 2;
            if (verifySolution(middle, a, k)) {
                end = middle - 1;
                res = middle;
            } else {
                beg = middle + 1;
            }
        }

        return res;
    }


    //x = middle
    public static boolean verifySolution(int middle, int[] a, int k) {

        int tmp = 0;
        int count = 1;

        //int[] A = new int[]{2, 1, 5, 1, 2, 2, 2};
        for(int i = 0; i < a.length; i++) {
            if(tmp + a[i] <= middle)
                tmp += a[i];
            else {
                count++;
                tmp = a[i];
                if(count > k)
                    return false;
            }
        }
        return true;
    }


}
