package sorting;
import java.util.Arrays;

/*
    1. Distinct
    Compute number of distinct values in an array.

    Write a function
    class Solution { public int solution(int[] A); }
    that, given an array A consisting of N integers, returns the number of distinct values in array A.

    For example, given array A consisting of six elements such that:
     A[0] = 2    A[1] = 1    A[2] = 1
     A[3] = 2    A[4] = 3    A[5] = 1

    the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.
    Write an efficient algorithm for the following assumptions:

    N is an integer within the range [0..100,000];
    each element of array A is an integer within the range [−1,000,000..1,000,000].
*/

public class DistinctSorting {

    public static void main(String[] args) {
        int[] A = new int[] {2, 1, 1, 2, 3, 1}; //3
        //int[] A = new int[] {5, 3, 1, 2, 4};  //5
        //int[] A = new int[] {1};              //1
        System.out.printf("\n%d", solution(A));
    }

    public static int solution(int[] A) {
        int N = A.length;
        if(0 == N) return 0;

//        Arrays.sort(A);
//        for(int i = 0; i < N; i++) {
//            System.out.printf("%d ", A[i]);
//        }

        quickSort(A, 0, N - 1);
        for(int i = 0; i < N; i++) {
            System.out.printf("%d ", A[i]);
        }

        int distinctNum = 1;
        for(int i = 1; i < N; i++) {
            //비트 EXCLUSIVE OR(=XOR) 양쪽 비트 중 어느 하나라도 서로 다를 때만 1 같을 때는 0
            if(0 != (A[i - 1] ^ A[i]))
                distinctNum++;
        }
        return distinctNum;
    }

    public static void quickSort(int[] arr, int beg, int end) {
        int middle = (beg + end) /2;
        int pivot = arr[middle];

        int left  = beg;
        int right = end;
        int temp;

        while(left < right) { //left와 right가 만나면 loop 종료
            while(arr[left] < pivot) left++;
            while(arr[right] > pivot) right--;

            if (left <= right) {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }

        if (beg < right) quickSort(arr, beg, right);
        if (end > left) quickSort(arr, left, end);
    }
}