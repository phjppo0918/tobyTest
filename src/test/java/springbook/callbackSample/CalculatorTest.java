package springbook.callbackSample;

import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void sumOfNumbers() throws IOException {
        Calculator calculator = new Calculator();
        int sum = calculator.calcSum("C:\\tobyTest\\src\\test\\java\\springbook\\callbackSample\\numbers.txt");
        assertThat(sum, is(10));
    }
}