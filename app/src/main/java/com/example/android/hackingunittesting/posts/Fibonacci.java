package com.example.android.hackingunittesting.posts;

/**
 * Created by pranit on 24/7/17.
 */

class Fibonacci {
    public static int compute(int n) {
        int result = 0;

        if (n <= 1) {
            result = n;
        } else {
            result = compute(n - 1) + compute(n - 2);
        }

        return result;
    }
}
