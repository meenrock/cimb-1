package com.cimb.question1;

import com.cimb.question1.models.Price;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static com.cimb.question1.service.maximumProfit;
import static com.cimb.question1.service.minimumPrice;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ServiceTest {
    @Mock
    Price minimumPriceObj;

    @Mock
    Price newHighPriceObj;

    @InjectMocks
    com.cimb.question1.service minimumPrice;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {

    }

    @Test
    public void shouldFindMinimumNumber() {
        int[] prices = {7,5,1,2,2,3,4,5,9,7};
        Price newPricer = new Price();
        newPricer.setAmount(1);
        newPricer.setPosition(2);
        Price result = minimumPrice(prices);
        Assert.assertEquals(newPricer.getAmount(),result.getAmount());
        Assert.assertEquals(newPricer.getPosition(),result.getPosition());
    }

    @Test
    public void shouldNotFindMinimumNumberReturnZeroAndFinalPos() {
        int[] prices = {7,7,0,0,0,0,0};
        Price newPricer = new Price();
        newPricer.setAmount(0);
        newPricer.setPosition(6);
        Price result = minimumPrice(prices);
        Assert.assertEquals(newPricer.getAmount(),result.getAmount());
        Assert.assertEquals(newPricer.getPosition(),result.getPosition());
    }

    @Test
    public void shouldReturnMaximumProfitPosition() {
        int[] prices = {7,5,1,2,2,3,4,5,9,7};
        Price minimumPrice = new Price();
        minimumPrice.setAmount(1);
        minimumPrice.setPosition(2);
        Price trueAnswer = new Price();
        trueAnswer.setAmount(8);
        trueAnswer.setPosition(9);
        Price result = maximumProfit(minimumPrice,prices);
        Assert.assertEquals(trueAnswer.getAmount(),result.getAmount());
        Assert.assertEquals(trueAnswer.getPosition(),result.getPosition());
    }

    @Test
    public void shouldNotFoundProfitPositionReturnZero() {
        int[] prices = {7,7,0,0,0,0,0};
        Price minimumPrice = new Price();
        minimumPrice.setAmount(0);
        minimumPrice.setPosition(6);
        Price trueAnswer = new Price();
        trueAnswer.setAmount(0);
        trueAnswer.setPosition(0);
        Price result = maximumProfit(minimumPrice,prices);
        Assert.assertEquals(trueAnswer.getAmount(),result.getAmount());
        Assert.assertEquals(trueAnswer.getPosition(),result.getPosition());
    }

}
