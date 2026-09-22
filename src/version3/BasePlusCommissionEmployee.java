package version3;

import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                                      double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = (baseSalary >= 0) ? baseSalary : 0;
    }

    @Override
    public double computeSalary(int currentMonth) {
        return baseSalary + super.computeSalary(currentMonth);
    }

    public void displayBasePlusCommissionEmployee() {
        super.displayCommissionEmployee();
        System.out.printf("Base Salary: %.2f | Total Compensation: %.2f%n", baseSalary, computeSalary());
    }

    @Override
    public String toString() {
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Total Sale: %.2f, Base Salary: %.2f, Total Salary: %.2f]",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(),
                getTotalSale(), baseSalary, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BasePlusCommissionEmployee) || !super.equals(obj)) return false;
        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
        return Double.compare(baseSalary, other.baseSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baseSalary);
    }

    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }
}