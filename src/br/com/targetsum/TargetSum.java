/**
 * Created by frodrigues.
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


        if (sumInStack == targetSum) {
            print(stack);
        }

        for (int currentIndex = fromIndex; currentIndex < endIndex; currentIndex++) {

            if (sumInStack + data[currentIndex] <= targetSum) {
                stack.push(data[currentIndex]);
                sumInStack += data[currentIndex];


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
