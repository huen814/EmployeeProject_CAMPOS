package version5;

import version5.Employee;
import version5.MyDate;
import version5.Name;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {

    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() { return totalPiecesFinished; }
    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = (totalPiecesFinished >= 0) ? totalPiecesFinished : 0;
    }

    public double getRatePerPiece() { return ratePerPiece; }
    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = (ratePerPiece >= 0) ? ratePerPiece : 0;
    }

    public double computeSalary(int currentMonth) {
        double basePay = totalPiecesFinished * ratePerPiece;
        int bonusFactor = totalPiecesFinished / 100;
        double bonusPay = bonusFactor * (10 * ratePerPiece);
        return basePay + bonusPay + super.getBirthdayBonus(currentMonth);
    }

    public double computeSalary(){
        return computeSalary(-1);
    }

    public void displayPieceWorkerEmployee() {
        super.displayEmployee();
        System.out.printf("Pieces Finished: %d | Rate/Piece: %.2f%n", totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Pieces: %d, Rate: %.2f, Total Salary: %.2f]",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(),
                totalPiecesFinished, ratePerPiece, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PieceWorkerEmployee) || !super.equals(obj)) return false;
        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;
        return totalPiecesFinished == other.totalPiecesFinished
                && Double.compare(ratePerPiece, other.ratePerPiece) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }
}