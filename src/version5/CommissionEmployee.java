package version5;


import version5.Employee;
import version5.MyDate;
import version5.Name;

import java.util.Objects;

public class CommissionEmployee extends Employee {

    private double totalSale;

    public CommissionEmployee() {
        super();
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        super(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
    }

    public double getTotalSale() { return totalSale; }
    public void setTotalSale(double totalSale) {
        this.totalSale = (totalSale >= 0) ? totalSale : 0;
    }

    public double getCommissionRate() {
        if (totalSale < 50000) return 0.05;
        else if (totalSale < 100000) return 0.10;
        else if (totalSale < 500000) return 0.15;
        else return 0.20;
    }

    public double computeSalary(int currentMonth) {
        double commission = totalSale * getCommissionRate();
        return commission + super.getBirthdayBonus(currentMonth);
    }

    public double computeSalary(){
        return computeSalary(-1);
    }

    public void displayCommissionEmployee() {
        super.displayEmployee();
        System.out.printf("Total Sale: %.2f | Commission Rate: %.2f%n", totalSale, getCommissionRate());
    }

    @Override
    public String toString() {
        return String.format("CommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Total Sale: %.2f, Commission Rate: %.2f, Total Salary: %.2f]",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(),
                totalSale, getCommissionRate(), computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CommissionEmployee) || !super.equals(obj)) return false;
        CommissionEmployee other = (CommissionEmployee) obj;
        return Double.compare(totalSale, other.totalSale) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalSale);
    }

    @Override
    public CommissionEmployee clone() {
        return (CommissionEmployee) super.clone();
    }
}