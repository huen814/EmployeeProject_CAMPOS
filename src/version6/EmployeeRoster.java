package version6;

import java.util.ArrayList;

public class EmployeeRoster {

    private final ArrayList<Employee> empList;

    public EmployeeRoster() {
        this.empList = new ArrayList<>();
    }

    public EmployeeRoster(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Initial capacity cannot be negative.");
        }
        this.empList = new ArrayList<>(initialCapacity);
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null) {
            return false;
        }
        empList.add(emp);
        return true;
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getEmpID() == empID) {
                return empList.remove(i);
            }
        }
        return null;
    }

    public Employee searchEmployee(int empID) {
        for (Employee emp : empList) {
            if (emp.getEmpID() == empID) {
                return emp;
            }
        }
        return null;
    }

    public int countEmployees() {
        return empList.size();
    }

    public int countHE() {
        int c = 0;
        for (Employee emp : empList) if (emp instanceof HourlyEmployee) c++;
        return c;
    }

    public int countPWE() {
        int c = 0;
        for (Employee emp : empList) if (emp instanceof PieceWorkerEmployee) c++;
        return c;
    }

    public int countCE() {
        int c = 0;
        for (Employee emp : empList) {
            if (emp instanceof CommissionEmployee && !(emp instanceof BasePlusCommissionEmployee)) c++;
        }
        return c;
    }

    public int countBPCE() {
        int c = 0;
        for (Employee emp : empList) if (emp instanceof BasePlusCommissionEmployee) c++;
        return c;
    }

    public void displayAllEmployees() {
        int i = 1;
        for (Employee emp : empList) {
            System.out.println(i++ + ". " + emp);
        }
    }

    // Dynamic dispatch through the abstract contract: no instanceof, no casting
    public void displayPayroll(int currentMonth) {
        for (Employee emp : empList) {
            double salary = emp.computeSalary(currentMonth);
            boolean bonusApplied = emp.getBirthdayBonus(currentMonth) > 0;
            System.out.printf("ID: %d | Name: %-26s | Payout: \u20b1%,.2f%s%n",
                    emp.getEmpID(), emp.getEmpName(), salary,
                    bonusApplied ? " (Bonus Applied)" : "");
        }
    }
}
