package tests.entities;

import entities.Financing;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import tests.tests.factory.FinancingFactory;

public class FinancingTest {
    @Test
    public void createnewShouldCreateNewInstanceWhenValidValuesParameters() {
        //Arrange
        double totalAmount = 100000.0;
        double income = 2000.0;
        int months = 80;
        double expectedValue = 1000.0;

        //Act
        Financing financing = new Financing(totalAmount, income, months);

        //Asserts
        Assertions.assertEquals(expectedValue, financing.quota());
    }

    @Test
    public void createnewShouldThrowExceptionWhenCreateNewInstanceWithInvalidValuesParameters() {
        //Asserts
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            //Arrange
            double totalAmount = 100000.0;
            double income = 2000.0;
            int months = 20;

            //Act
            Financing financing = new Financing(totalAmount, income, months);
        });
    }

    @Test
    public void updateAmountShouldMustUpdateTheValueAmountWhenValidParametersAreReceived () {
        //Arrange
        double totalAmount = 80000.0;
        double income = 2000.0;
        int months = 80;
        double expectedValue = 1000.0;

        //Act
        Financing financing = new Financing(totalAmount, income, months);
        financing.setTotalAmount(100000.0);

        //Asserts
        Assertions.assertTrue(expectedValue == financing.quota());
    }

    @Test
    public void updateAmountShouldThrowExceptionWhenInvalidParametersAreReceived() {
        //Asserts
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            //Arrange
            double totalAmount = 80000.0;
            double income = 2000.0;
            int months = 80;

            //Act
            Financing financing = new Financing(totalAmount, income, months);
            financing.setTotalAmount(180000.0);
        });
    }

    @Test
    public void setIncomeShouldMustTheUpdateTheValueIncomeWhenValidParametersAreReceived() {
        //Arrange
        double expectedValue = 1000.0;

        //Act
        Financing financing = FinancingFactory.createEmptyValidFinancing();
        financing.setIncome(4000.0);

        //Asserts
        Assertions.assertTrue(expectedValue == financing.quota());
    }

    @Test
    public void setIncomeShouldThrowExceptionWhenInvalidParametersAreReceived() {
        //Asserts
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            //Arrange
            Financing financing = FinancingFactory.createEmptyValidFinancing();

            //Act
            financing.setIncome(1500.0);
        });
    }

    @Test
    public void setMonthsShouldMustUpdateValuesWhenValidParametersAreReceived() {
        //Arrange
        int expectedValue = 90;
        Financing financing = FinancingFactory.createEmptyValidFinancing();

        //Act
        financing.setMonths(expectedValue);

        //Asserts
        Assertions.assertEquals(expectedValue, financing.getMonths());
    }

    @Test
    public void setMonthsShouldThrowExceptionWhenInvalidParametersAreReceived() {
        //Asserts
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            //Arrange
            Financing financing = FinancingFactory.createEmptyValidFinancing();

            //Act
            financing.setMonths(10);
        });
    }

    @Test
    public void entryShouldCalculedRightValueOfTheEntry() {
        //Arrange
        double totalAmount = 100000.0;
        double income = 2000.0;
        int months = 80;
        double expectedValue = 20000.0;

        //Act
        Financing financing = new Financing(totalAmount, income, months);

        //Asserts
        Assertions.assertEquals(expectedValue, financing.entry());
    }

    @Test
    public void quotaShouldCalculedRightValueOfTheQuota() {
        //Arrange
        double totalAmount = 150000.0;
        double income = 3000.0;
        int months = 80;
        double expectedValue = 1500.0;

        //Act
        Financing financing = new Financing(totalAmount, income, months);

        //Asserts
        Assertions.assertEquals(expectedValue, financing.quota());
    }
}
