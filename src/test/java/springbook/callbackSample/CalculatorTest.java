package springbook.callbackSample;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator;
    String numFilepath;

    @Before
    public void setUp() {
        this.calculator = new Calculator();
        this.numFilepath = "C:\\tobyTest\\src\\test\\java\\springbook\\callbackSample\\numbers.txt";
    }

    @Test
    public void sumOfNumbers() throws IOException {
        assertThat(calculator.calcSum(this.numFilepath), is(10));
    }

    @Test
    public void multiplyOfNumbers() throws IOException {
        assertThat(calculator.calcMultiply(this.numFilepath), is(24));
    }
}