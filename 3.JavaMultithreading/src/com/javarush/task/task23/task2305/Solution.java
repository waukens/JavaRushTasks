package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {

        Solution[] arr = new Solution[2];
        Solution firstSolution = new Solution();
        Solution.InnerClass firstInnerClassSol1 = firstSolution.new InnerClass();
        Solution.InnerClass secondInnerClassSol1 = firstSolution.new InnerClass();
        firstSolution.innerClasses[0] = firstInnerClassSol1;
        firstSolution.innerClasses[1] = secondInnerClassSol1;

        Solution secondSolution = new Solution();
        Solution.InnerClass firstInnerClassSol2 = secondSolution.new InnerClass();
        Solution.InnerClass secondInnerClassSol2 = secondSolution.new InnerClass();
        secondSolution.innerClasses[0] = firstInnerClassSol2;
        secondSolution.innerClasses[1] = secondInnerClassSol2;

        arr[0] = firstSolution;
        arr[1] = secondSolution;

        return arr;
    }

    public static void main(String[] args) {

    }
}
