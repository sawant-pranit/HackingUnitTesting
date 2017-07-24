package com.example.android.hackingunittesting.posts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by pranit on 24/7/17.
 */

@RunWith(Parameterized.class)
public class FibonacciTest {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { 0, 0 }, { 1, 1 }, { 2, 1 }, { 3, 2 }, { 4, 3 }, { 5, 5 }, { 6, 8 }
        });
    }

    @Parameterized.Parameter // first data value (0) is default
    public /* NOT private */ int fInput;

    @Parameterized.Parameter(1)
    public /* NOT private */ int fExpected;

    @Test
    public void test() {
        System.out.format("fExpected: %d, fInput: %d\n", fExpected, fInput);
        assertEquals(fExpected, Fibonacci.compute(fInput));
    }
    
}

