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
public class PieceWorkerEmployee {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this.empID = 0;
        this.empName = new Name("N/A","N/A","N/A");
        this.birthDate = new MyDate(1,1,2000);
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, Name empName,MyDate birthDate) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.totalPiecesFinished = totalPiecesFinished;
        this.ratePerPiece = ratePerPiece;
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

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = ratePerPiece;
    }

    public double computeSalary() {
        double basePay = totalPiecesFinished * ratePerPiece;
        int bonusFactor = totalPiecesFinished / 100;
        double bonusPay = bonusFactor * (10 * ratePerPiece);

        double salary = basePay + bonusPay;

        if(this.birthDate != null && this.birthDate.month == 9){
            salary += 500;
        }

        return salary;
    }

    @Override
    public String toString() {
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, DOB: %s, Pieces: %d, Rate: %.2f, Total Salary: %.2f]", this.empID, this.empName, this.birthDate, this.totalPiecesFinished, this.ratePerPiece, this.computeSalary());
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Pieces Finished: %d | Rate/Piece: %.2f", this.empID, this.empName, this.birthDate,this.totalPiecesFinished, this.ratePerPiece);

    }

}
