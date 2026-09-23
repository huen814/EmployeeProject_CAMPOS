/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/version1.Main.java to edit this template
 */
package version4;

import java.util.Objects;

/**
 *
 * @author User
 */
public class HourlyEmployee extends Employee {

    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        super(empID,empName,birthDate,dateHired);
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, float totalHoursWorked, double ratePerHour) {
        super(empID,empName,birthDate,dateHired);
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }


    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public double computeSalary(int currentMonth) {
        double basePay;
        if (totalHoursWorked <= 40) {
            basePay = totalHoursWorked * ratePerHour;
        } else {
            double regularPay = 40 * ratePerHour;
            double overtimeHours = totalHoursWorked - 40;
            double overtimePay = overtimeHours * (ratePerHour * 1.5);
            basePay = regularPay + overtimePay;
        }

        return basePay + super.getBirthdayBonus(currentMonth);
    }

    public double computeSalary(){
        return computeSalary(-1);
    }

    public void displayHourlyEmployee() {
        super.displayEmployee();
        System.out.printf("Hours: %.2f | Rate: %.2f/hr", totalHoursWorked, ratePerHour);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if (!(obj instanceof HourlyEmployee) || !super.equals(obj)) return false;
        HourlyEmployee other = (HourlyEmployee) obj;
        return Float.compare(totalHoursWorked, other.totalHoursWorked) == 0
                && Double.compare(ratePerHour, other.ratePerHour) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour);
    }

    @Override
    public HourlyEmployee clone() {
        return (HourlyEmployee) super.clone();
    }

}