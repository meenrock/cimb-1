package com.cimb.question1;

import com.cimb.question1.models.Price;
import com.cimb.question1.util.*;
import com.google.gson.Gson;

public class service {
    public static void Question1() {
        int[] prices = {7,5,1,2,2,3,4,5,9,7};
        int[] badPrices = {1,2,2,2,2,2};
        int[] outlierPrices = {7,7,7,7,0,0,0};
        Price min = minimumPrice(prices);
        Price maximum = maximumProfit(min,prices);
        Gson gson = new Gson();
        String day = gson.toJson(maximum.getPosition());
        String profit = gson.toJson(maximum.getAmount());
        System.out.println("The day that you should invest in is : " + day + " With profit : " + profit);
    }
    public static Price minimumPrice(int[] stockPrices) {
        if (stockPrices.length > 0) {
            Price newMinimum = new Price();
            newMinimum.setAmount(stockPrices[0]);
            newMinimum.setPosition(0);
            // Traversing array once O(N) time complexity
            for (int i = 0; i < stockPrices.length; i++) {
                if (stockPrices[i] <= newMinimum.getAmount()) {
                    newMinimum.setAmount(stockPrices[i]);
                    newMinimum.setPosition(i);
                }
            }
            return newMinimum;
        }
        return new Price();
    }

    public static Price maximumProfit(Price minimumPrice, int[] stockPrices) {
        if (minimumPrice.getAmount() == 0) {
            return new Price();
        }
        if (minimumPrice.getPosition() == 0) {
            return new Price();
        }
        if (stockPrices.length > 0) {
            Price newHigh = new Price();
            for (int i = minimumPrice.getPosition(); i < stockPrices.length; i++) {
                if (stockPrices[i] > newHigh.getAmount()) {
                    newHigh.setAmount(stockPrices[i]);
                    newHigh.setPosition(i);

                }
            }
            if (newHigh.getAmount() <= minimumPrice.getAmount()) {
                return new Price();
            }
            Price profit = new Price();
            profit.setAmount(util.calculateDifferences(newHigh.getAmount(), minimumPrice.getAmount()));
            profit.setPosition(newHigh.getPosition() + 1);
            return profit;
        }
        return new Price();
    }
}
