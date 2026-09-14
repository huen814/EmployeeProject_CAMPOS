/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/version1.Main.java to edit this template
 */
package version1;

/**
 *
 * @author User
 */
public class HourlyEmployee {

    private int empID;
    private String empName;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, String empName, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = totalHoursWorked;
        this.ratePerHour = ratePerHour;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
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
        if (this.totalHoursWorked <= 40) {
            return this.totalHoursWorked * this.ratePerHour;
        } else {
            double regularPay = 40 * this.ratePerHour;
            double overtimeHours = this.totalHoursWorked - 40;
            double overtimePay = overtimeHours * (this.ratePerHour * 1.5);
            return regularPay + overtimePay;
        }
    }

    @Override
    public String toString(){
        return String.format("HourlyEmployee [ID: %d, Name: %s, Hours: %.2f, Rate:  %.2f, Total Salary:  %.2f]",this.empID,this.empName,this.totalHoursWorked,this.ratePerHour,this.computeSalary());
    }

    public void displayHourlyEmployee() {
        System.out.printf("ID: %d | Name: %s | Hours:  %.2f | Rate:  %.2f/hr ", this.empID, this.empName, this.totalHoursWorked, this.ratePerHour);
    }

}