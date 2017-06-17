package com.crx;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CalculationServiceTest {

    private CalculationService calculationService = new CalculationService();

    @Test
    public void testOneHoleFirstHillLower() {
        Assert.assertEquals(1, calculationService.calculate(new ArrayList<>(Arrays.asList(3, 2, 4))));
    }

    @Test
    public void testOneHoleFirstHillHigher() {
        Assert.assertEquals(2, calculationService.calculate(new ArrayList<>(Arrays.asList(4, 1, 3))));
    }

    @Test
    public void testTwoHoles() {
        Assert.assertEquals(4, calculationService.calculate(new ArrayList<>(Arrays.asList(2, 1, 4, 1, 2, 3))));
    }

    @Test
    public void testThreeHoles() {
        Assert.assertEquals(5, calculationService.calculate(new ArrayList<>(Arrays.asList(2, 1, 4, 1, 2, 3, 1, 0, 1))));
    }

    @Test
    public void testOneBigHole() {
        Assert.assertEquals(8, calculationService.calculate(new ArrayList<>(Arrays.asList(4, 1, 1, 0, 2, 3, 0))));
    }

    @Test
    public void testAccedingHills() {
        Assert.assertEquals(0, calculationService.calculate(new ArrayList<>(Arrays.asList(0, 1, 2, 3))));
    }

    @Test
    public void testDescendingHills() {
        Assert.assertEquals(0, calculationService.calculate(new ArrayList<>(Arrays.asList(3, 2, 1, 0))));
    }

    @Test
    public void testAccedingAndDescendingHills() {
        Assert.assertEquals(0, calculationService.calculate(new ArrayList<>(Arrays.asList(0, 1, 2, 3, 3, 2, 1, 0))));
    }

    @Test
    public void testAccedingAndDescendingHillsWithGap() {
        Assert.assertEquals(6, calculationService.calculate(new ArrayList<>(Arrays.asList(0, 1, 2, 3, 0, 0, 3, 2, 1, 0))));
    }

    @Test
    public void testDescendingAndAccedingHills() {
        Assert.assertEquals(12, calculationService.calculate(new ArrayList<>(Arrays.asList(3, 2, 1, 0, 0, 1, 2, 3))));
    }

    @Test
    public void testRepeatingHills() {
        Assert.assertEquals(4, calculationService.calculate(new ArrayList<>(Arrays.asList(3, 1, 3, 1, 3))));
    }

    @Test
    public void testRepeatingLowerHills() {
        Assert.assertEquals(2, calculationService.calculate(new ArrayList<>(Arrays.asList(3, 1, 2, 1, 2))));
    }

    @Test
    public void testRepeatingHigherHills() {
        Assert.assertEquals(3, calculationService.calculate(new ArrayList<>(Arrays.asList(2, 1, 3, 1, 3))));
    }

    @Test
    public void testComplexHills() {
        Assert.assertEquals(7, calculationService.calculate(new ArrayList<>(Arrays.asList(3, 1, 4, 1, 4, 3, 1, 2, 1, 2, 1))));
    }

    @Test
    public void testNoHills() {
        Assert.assertEquals(0, calculationService.calculate(new ArrayList<>(Arrays.asList(2, 2))));
    }
    
    @Test
    public void testEmptyList() {
        Assert.assertEquals(0, calculationService.calculate(new ArrayList<>()));
    }

}
