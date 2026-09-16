package version1;/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import version2.MyDate;
import version2.Name;
/**
 *
 * @author User
 */
public class CommissionEmployee {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private double totalSale;

    public CommissionEmployee() {
        this.empID = 0;
        this.empName = new Name("N/A","N/A","N/A");
        this.birthDate = new MyDate(1,1,2000);
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = new MyDate(1,1,2000);
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, Name empName,MyDate birthDate, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.totalSale = totalSale;
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

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public double computeSalary() {
        double commissionRate;

        if (this.totalSale < 50000) {
            commissionRate = 0.05;
        } else if (this.totalSale < 100000) {
            commissionRate = 0.10;
        } else if (this.totalSale < 500000) {
            commissionRate = 0.15;
        } else {
            commissionRate = 0.20;
        }

        double salary = commissionRate * this.totalSale;
        if(this.birthDate != null && this.birthDate.month == 9){
            salary += 500;
        }
        return salary;
    }

    @Override
    public String toString() {
        return String.format("CommissionEmployee: [ID: %d, Name: %s, DOB: %s, Total Sale: %.2f, Commission Rate: %.2f]",
                this.empID, this.empName, this.birthDate,this.totalSale, this.computeSalary());
    }

    public void displayCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Total Sale: %.2f", this.empID, this.empName,this.birthDate, this.totalSale);
    }

}
