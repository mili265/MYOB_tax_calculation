import com.sun.tools.javac.Main;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IncomeCalculationTest {

    IncomeCalculation incomeCalculation = new IncomeCalculation();

    @Test
    void incomeCalculator() {
        double monthlyIncome = incomeCalculation.incomeCalculator(60000);
        Assert.assertTrue(monthlyIncome == 5000);
    }

    @Test
    void taxCalculation() {
        double tax = incomeCalculation.taxCalculation(60000);
        Assertions.assertEquals(500, Math.round(tax));

    }

    @Test
    void netIncome() {
        double income = incomeCalculation.netIncome(60000);
        Assertions.assertEquals(4500, Math.round(income));
    }

    @Test
    void netIncomeWhenSalaryIsZero() {
        double income = incomeCalculation.netIncome(0);
        Assertions.assertEquals(0, Math.round(income));
    }

    @Test
    void monthlyIncomeWhenSalaryIsNegative() {
        double monthlyIncome = incomeCalculation.incomeCalculator(-12345);
        Assertions.assertEquals(0, Math.round(monthlyIncome));
    }

    @Test
    void taxWhenSalaryIsNegative() {
        double tax = incomeCalculation.taxCalculation(0);
        Assertions.assertEquals(0, Math.round(tax));
    }

}