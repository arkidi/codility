package counting;

/*
    A non-empty array A consisting of N integers is given.

    A permutation is a sequence containing each element from 1 to N once, and only once.

    For example, array A such that:

        A[0] = 4
        A[1] = 1
        A[2] = 3
        A[3] = 2
    is a permutation, but array A such that:

        A[0] = 4
        A[1] = 1
        A[2] = 3
    is not a permutation, because value 2 is missing.

    The goal is to check whether array A is a permutation.

    Write a function:

    class Solution { public int solution(int[] A); }

    that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

    For example, given array A such that:

        A[0] = 4
        A[1] = 1
        A[2] = 3
        A[3] = 2
    the function should return 1.

    Given array A such that:

        A[0] = 4
        A[1] = 1
        A[2] = 3
    the function should return 0.

    Write an efficient algorithm for the following assumptions:

    N is an integer within the range [1..100,000];
    each element of array A is an integer within the range [1..1,000,000,000].

*/

public class PermCheck {

    public static void main(String[] args) {

        int[] A = new int[] {4, 2, 3, 1};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {

        int[] marks = new int [A.length + 1];
        int sumOfElements = 0;
        int expertedSumOfElements = 0;

        for(int i = 0; i < A.length; i ++) {

            if(A[i] >= marks.length) return 0;
            if(marks[A[i]] != 0) return 0;

            marks[A[i]] = 1;

            sumOfElements += A[i];
            expertedSumOfElements += i + 1;
        }

        return (sumOfElements == expertedSumOfElements) ? 1 : 0;
    }
}
