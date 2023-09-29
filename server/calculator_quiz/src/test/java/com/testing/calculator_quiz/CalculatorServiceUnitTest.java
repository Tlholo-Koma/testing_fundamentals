package com.testing.calculator_quiz;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.testing.calculator_quiz.service.Addition;
import com.testing.calculator_quiz.service.Calculator;
import com.testing.calculator_quiz.service.Division;
import com.testing.calculator_quiz.service.Multiplication;


import org.junit.Assert;
import net.bytebuddy.implementation.bytecode.Subtraction;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorServiceUnitTest {

    @Mock
    Addition addition;
    @Mock
    Subtraction subtraction;
    @Mock
    Multiplication multiplication;
    @Mock
    Division division;


    @InjectMocks
    Calculator calculatorService; 

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Before
    public void init()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void calculateBasicBinaryTest() throws Exception
    {
        Double result = this.calculatorService.calculate("2+2");
        Assert.assertEquals(Double.valueOf(4.0), result);
    }
    @Test
    public void calculateBasicBinarySubTest() throws Exception
    {
        Double result = this.calculatorService.calculate("27-2");
        Assert.assertEquals(Double.valueOf(25.0), result);
    }

    @Test
    public void calculateBasicBinaryDecimalTest() throws Exception
    {
        Double result = this.calculatorService.calculate("2.7+2");
        Assert.assertEquals(Double.valueOf(4.7), result);
    }

    @Test
    public void calculateBasicBodmasTest() throws Exception
    {
        Double result = this.calculatorService.calculate("(58+3)/(12/2)");
        Assert.assertEquals(Double.valueOf(10.166666666666666), result);
    }
    @Test
    public void calculateBasicNegativeNumberTest() throws Exception
    {
        Double result = this.calculatorService.calculate("-12+2");
        Assert.assertEquals(Double.valueOf(-10), result);
    }
    @Test
    public void invalidExpressionTest() throws Exception
    {
        
        thrown.expect(Exception.class);
        thrown.expectMessage("Invalid expression");
        this.calculatorService.calculate("((2+2)");
    }

}
