/**
 * Created by frodrigues on 24/11/15.
 */

package br.com.targetsum;

import java.util.Stack;


public class TargetSum {

    private int targetSum;
    private int sumInStack = 0;

    private Stack<Integer> stack;

    public TargetSum(int _targetSum){
        targetSum = _targetSum;
        stack = new Stack<Integer>();
    }

    public void populateSubset(int[] data, int fromIndex, int endIndex) {

        /*
        * Check if sum of elements stored in Stack is equal to the expected
        * target sum.
        *
        * If so, call print method to print the candidate satisfied result.
        */
        if (sumInStack == targetSum) {
            print(stack);
        }

        for (int currentIndex = fromIndex; currentIndex < endIndex; currentIndex++) {

            if (sumInStack + data[currentIndex] <= targetSum) {
                stack.push(data[currentIndex]);
                sumInStack += data[currentIndex];

                /*
                * Make the currentIndex +1, and then use recursion to proceed
                * further.
                */
                populateSubset(data, currentIndex + 1, endIndex);
                sumInStack -= (Integer) stack.pop();
            }
        }
    }
    private void print(Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        sb.append(targetSum).append(" = ");
        for (Integer i : stack) {
            sb.append(i).append("+");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }
}
