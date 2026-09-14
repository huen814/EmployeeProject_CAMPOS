/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/version1.Main.java to edit this template
 */
package version1;

import version2.MyDate;
import version2.Name;
/**
 *
 * @author User
 */
public class HourlyEmployee {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = new Name("N/A","N/A","N/A");
        this.birthDate = new MyDate(1,1,2000);
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, Name empName,MyDate birthDate) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public MyDate getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate){
        this.birthDate = birthDate;
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

    public double computeSalary() {
        double salary = 0;
        if (this.totalHoursWorked <= 40) {
            salary = this.totalHoursWorked * this.ratePerHour;
        } else {
            double regularPay = 40 * this.ratePerHour;
            double overtimeHours = this.totalHoursWorked - 40;
            double overtimePay = overtimeHours * (this.ratePerHour * 1.5);
            salary = regularPay + overtimePay;
        }

        if(this.birthDate != null && this.birthDate.month == 9){
            salary += 5000;
        }

        return salary;
    }

    @Override
    public String toString(){
        String fullName = empName.firstname + " " + empName.middleInitial + " " + empName.lastName;
        return String.format("HourlyEmployee [ID: %d, Name: %s, Hours: %.2f, Rate:  %.2f, Total Salary:  %.2f]",this.empID,fullName,this.totalHoursWorked,this.ratePerHour,this.computeSalary());
    }

    public void displayHourlyEmployee() {
        String fullName = this.empName.firstname + this.empName.middleInitial + this.empName.lastName;

        System.out.printf("ID: %d | Name: %s | Hours:  %.2f | Rate:  %.2f/hr ", this.empID, fullName, this.totalHoursWorked, this.ratePerHour);
    }

}