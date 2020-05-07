package com.geblob.hydrogen.sand;

public class SqtTest {
    public static void main(String[] args) {
        System.out.println(computeSqt(9));
    }

    public static int computeSqt(int n) {
        int initVal = n / 2;

        for (int remain = 1; remain < initVal; ) {
            if ((remain = n / initVal) < initVal) {
                initVal = (initVal - remain) / 2 + remain;
            }
        }
        return initVal;
    }
}
