
import java.util.Scanner;

public class IncomeCalculation extends Employee {

    private static final Scanner scanner = new Scanner(System.in);
    //standard variables declaration for calculations
    public static int limit_20000 = 20000;
    public static int limit_40000 = 40000;
    public static int limit_80000 = 80000;
    public static int limit_180000 = 180000;
    public static int months = 12;
    public static double tax = 0;
    public final float taxRate_1 = 0.1f;
    public final float taxRate_2 = 0.2f;
    public final float taxRate_3 = 0.3f;
    public final float taxRate_4 = 0.4f;

    public static void main(String[] args) {
        String empName;
        double empSalary;
        double monthlyIncome;
        double netIncome;
        double taxResult;
        IncomeCalculation empResult = new IncomeCalculation();

        //Scanner Input
        Employee emp = new Employee();
        System.out.println("Enter Employee Name");
        empName = scanner.nextLine();
        emp.setName(empName);

        System.out.println("Enter Employee Salary");
        empSalary = scanner.nextDouble();
        emp.setSalary(empSalary);

        monthlyIncome = empResult.incomeCalculator(empSalary);
        taxResult = empResult.taxCalculation(empSalary);
        netIncome = empResult.netIncome(empSalary);

        //Print Standard Output
        System.out.println("Monthly Payslip for: " + empName);
        System.out.println("Gross Monthly Income: " + Math.round(monthlyIncome));
        System.out.println("Monthly Income Tax: " + Math.round(taxResult));
        System.out.println("Net Monthly Income: " + Math.round(netIncome));
    }

    //method for calculating Gross monthly income
    public double incomeCalculator(double salary) {
        double monSalary;
        if (salary > 0) {
            monSalary = salary / 12;
            return monSalary;
        } else {
            monSalary = 0;
            return monSalary;
        }


    }

    //method for calculating tax
    public double taxCalculation(double salary) {
        if (salary > limit_20000 && salary <= limit_40000) {
            tax = ((salary - limit_20000) * taxRate_1) / months;
            return tax;
        } else if (salary > limit_40000 && salary <= limit_80000) {
            tax = ((limit_20000) * taxRate_1 + (salary - limit_40000) * taxRate_2) / months;
            return tax;
        } else if (salary > limit_80000 && salary <= limit_180000) {
            tax = ((limit_20000) * taxRate_1 + (limit_40000) * taxRate_2 + (salary - limit_80000) * taxRate_3) / months;
            return tax;
        } else if (salary > limit_180000) {
            tax = ((limit_20000) * taxRate_1 + (limit_40000) * taxRate_2 +
                    (limit_180000 - limit_80000) * taxRate_3 + (salary - limit_180000) * taxRate_4) / months;
            return tax;
        } else {
            return tax;
        }

    }

    //method for calculating net Income
    public double netIncome(double salary) {
        double monthIncome = 0;
        double netIncome = 0;

        if (salary > 0) {
            tax = taxCalculation(salary);
            monthIncome = incomeCalculator(salary);

            netIncome = monthIncome - tax;
            return netIncome;
        } else {
            netIncome = 0;
            return netIncome;
        }
    }
}

