import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calc = new Calculator();

    @Test
    void inputVerification() {
        Calculator calc = new Calculator();
        assertTrue(calc.inputVerification(-200458));        //negative integer test
        assertTrue(calc.inputVerification(2983729.55));     //positive double test
        assertFalse(calc.inputVerification(3147483649.21)); //Value too large
    }

    @Test
    void intPlus() {
        assertEquals(10, calc.intPlus(7, 3));
        assertEquals(10000, calc.intPlus(1000, 9000));
        assertNotEquals(5, calc.intPlus(3.2, 4.8));
    }

    @Test
    void doubPlus() {
        assertEquals(10.77, calc.doubPlus(2.33, 8.44));
        assertEquals(200.0, calc.doubPlus(187.4085, 12.5915));
        assertNotEquals(11.22, calc.doubPlus(6, 2));
    }

    @Test
    void intSubtract() {
        assertEquals(0, calc.intSubtract(205, 205));
        assertNotEquals(50, calc.intSubtract(50, 50));
    }

    @Test
    void doubSubtract() {
        assertEquals(20.2, calc.doubSubtract(25.2, 5.0));
        assertNotEquals(0.0, calc.doubSubtract(255.302, 1));
    }

    @Test
    void intMultiply() {
        assertEquals(50, calc.intMultiply(5, 10));
        assertNotEquals(200, calc.intMultiply(2000, 0));
    }

    @Test
    void doubMultiply() {
        assertEquals(6.25, calc.doubMultiply(2.5,2.5));
        assertNotEquals(0, calc.doubMultiply(.4, 2.780));
    }

    @Test
    void intDivide() {
        assertEquals(10, calc.intDivide(100,10));
        assertNotEquals(0.5, calc.intDivide(5,0));
    }

    @Test
    void doubDivision() {
        assertEquals(1, calc.doubDivision(0.05, 0.05));
        assertNotEquals(0, calc.doubDivision(0.000001, 0.000001));
    }

    @Test
    void intSquareRoot() {
        assertEquals(2, calc.intSquareRoot(4));
        assertNotEquals(2, calc.intSquareRoot(5));
    }

    @Test
    void doubSquareRoot() {
        assertEquals(1.2, calc.doubSquareRoot(1.44));
        assertNotEquals(3.3, calc.doubSquareRoot(9.9));
    }

    @Test
    void intExponent() {
        assertEquals(16, calc.intExponent(4));
        assertNotEquals(6, calc.intExponent(6));
    }

    @Test
    void doubExponent() {
        assertEquals(20.25, calc.doubExponent(4.5));
        assertNotEquals(1.1, calc.doubExponent(1.1));
    }

    @Test
    void testReciprocal() {
        assertEquals(0.2, calc.reciprocal(5.0));
        assertNotEquals(0, calc.reciprocal(1));
    }
}