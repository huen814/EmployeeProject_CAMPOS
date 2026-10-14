package version6;

import java.util.Objects;

public abstract class Employee implements Cloneable {

    public static final double BIRTHDAY_BONUS = 5000.00;

    private final int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    protected Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        if (empID <= 0) {
            throw new IllegalArgumentException("Employee ID must be positive.");
        }
        if (empName == null) throw new NullPointerException("Employee name cannot be null");
        if (birthDate == null) throw new NullPointerException("Birth date cannot be null");
        if (dateHired == null) throw new NullPointerException("Date hired cannot be null");

        this.empID = empID;
        this.empName = empName.clone();
        this.birthDate = birthDate.clone();
        this.dateHired = dateHired.clone();
    }

    public final int getEmpID() {
        return empID;
    }

    public Name getEmpName() { return this.empName.clone(); }
    public MyDate getBirthDate() { return this.birthDate.clone(); }
    public MyDate getDateHired() { return this.dateHired.clone(); }

    public void setEmpName(Name empName) {
        if (empName == null) throw new NullPointerException("Employee name cannot be null");
        this.empName = empName.clone();
    }

    public void setBirthDate(MyDate birthDate) {
        if (birthDate == null) throw new NullPointerException("Birth date cannot be null");
        this.birthDate = birthDate.clone();
    }

    public void setDateHired(MyDate dateHired) {
        if (dateHired == null) throw new NullPointerException("Date hired cannot be null");
        this.dateHired = dateHired.clone();
    }

    public final double getBirthdayBonus(int currentMonth) {
        return (birthDate.getMonth() == currentMonth) ? BIRTHDAY_BONUS : 0.0;
    }

    public abstract double computeSalary(int currentMonth);

    public abstract double computeSalary();

    public abstract void displayEmployee();

    // Shared validation helper for subclasses
    protected static void requireNonNegative(double value, String message) {
        if (!(value >= 0)) {
            throw new IllegalArgumentException(message);
        }
    }

    protected String baseInfo() {
        return String.format("ID: %d | Name: %s | DOB: %s | Hired: %s", empID, empName, birthDate, dateHired);
    }

    @Override
    public String toString() {
        return String.format("%s [ID: %d, Name: %s, DOB: %s, Hired: %s]",
                getClass().getSimpleName(), empID, empName, birthDate, dateHired);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return empID == other.empID
                && Objects.equals(empName, other.empName)
                && Objects.equals(birthDate, other.birthDate)
                && Objects.equals(dateHired, other.dateHired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empID, empName, birthDate, dateHired);
    }

    @Override
    public Employee clone() {
        try {
            Employee cloned = (Employee) super.clone();
            cloned.empName = this.empName.clone();
            cloned.birthDate = this.birthDate.clone();
            cloned.dateHired = this.dateHired.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Employee should be cloneable", e);
        }
    }
}
