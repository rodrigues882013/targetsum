/**
 * Created by frodrigues.
 */

package br.com.targetsum;

public class Main {


    private static final int[] DATA = { 1, 2, 3, 4, 6};

    public static void main(String... args) {
        TargetSum obj = new TargetSum(6);
        obj.populateSubset(DATA, 0, DATA.length);
    }
}
