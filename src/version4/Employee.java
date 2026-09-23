package version4;


import java.util.Objects;

public class Employee implements Cloneable {

    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;


    public static final double BIRTHDAY_BONUS = 5000.00;

    public Employee() {
        this.empID = 0;
        this.empName = new Name("N/A", "N/A", "N/A");
        this.birthDate = new MyDate(1, 1, 2000);
        this.dateHired = new MyDate(1, 1, 2000);

    }

    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        this.empID = empID;
        this.empName = empName;
        this.birthDate = birthDate;
        this.dateHired = dateHired;

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

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    public double getBirthdayBonus(int currentMonth) {
        if (birthDate != null && currentMonth != -1 && birthDate.month == currentMonth) {
            return BIRTHDAY_BONUS;
        }
        return 0.0;
    }


    public void displayEmployee(){
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s\n",empID,empName,birthDate,dateHired);
    }

    @Override
    public String toString(){
        return String.format("Employee [ID: %d, Name: %s, DOB: %s, Hired: %s]",empID,empName,birthDate,dateHired);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if(!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return empID == other.empID
        && Objects.equals(empName,other.empName)
        && Objects.equals(birthDate,other.birthDate)
        && Objects.equals(dateHired,other.dateHired);

    }

    @Override
    public int hashCode() {
        return Objects.hash(empID,empName,birthDate,dateHired);
    }

    @Override
    public Employee clone(){
        try{
            Employee cloned = (Employee) super.clone();
            cloned.empName = (this.empName != null) ? this.empName.clone() : null;
            cloned.birthDate = (this.birthDate != null) ? this.birthDate.clone() : null;
            cloned.dateHired = (this.dateHired != null) ? this.dateHired.clone() : null;
            return cloned;
        } catch (CloneNotSupportedException e){
            throw new AssertionError("Employee should be cloneable",e);
        }
    }
}
