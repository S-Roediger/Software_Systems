package ss.week4.test;

import org.junit.Before;
import org.junit.Test;

import ss.week4.Polynomial;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PolynomialTest {

    private static final double DELTA = 1e-15;
    private static final double CONSTANT_VALUE = Math.PI;
    private Polynomial p;
    private double[] arr;

    @Before
    public void setUp() {
    	arr = new double[] {1, 2, 3};
        p = new Polynomial(arr);
    }

    @Test
    public void testApply() {
        assertEquals(1.0, p.apply(0), DELTA);
        assertEquals(2.0, p.apply(-1), DELTA);
        assertEquals(6.0, p.apply(1), DELTA);
    }

    @Test
    public void testDerivative() {
        assertTrue(p.derivative() instanceof Polynomial);
        assertEquals(2.0, p.derivative().apply(0), DELTA);
    }
    
    @Test
    public void testIntegral() {
    	assertTrue(p.integral() instanceof Polynomial);
    	assertEquals(3.0, p.integral().apply(1), DELTA);
    }
}
