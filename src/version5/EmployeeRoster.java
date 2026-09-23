package version5;

import version5.BasePlusCommissionEmployee;
import version5.CommissionEmployee;
import version5.Employee;
import version5.HourlyEmployee;
import version5.PieceWorkerEmployee;

public class EmployeeRoster {

    private version5.Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        this.max = 10;
        this.empList = new version5.Employee[this.max];
        this.count = 0;
    }

    public EmployeeRoster(int max) {
        this.max = max;
        this.empList = new version5.Employee[this.max];
        this.count = 0;
    }

    boolean addEmployee(version5.Employee emp) {
        if (emp == null || this.count >= this.max) {
            return false;
        }
        this.empList[this.count] = emp;
        this.count++;
        return true;
    }

    public version5.Employee removeEmployee(int empID) {
        for (int i = 0; i < this.count; i++) {
            if (this.empList[i].getEmpID() == empID) {
                version5.Employee removed = this.empList[i];
                for (int j = i; j < this.count - 1; j++) {
                    this.empList[j] = this.empList[j + 1];
                }
                this.empList[this.count - 1] = null;
                this.count--;
                return removed;
            }
        }
        return null;
    }

    public version5.Employee searchEmployee(int empID) {
        for (int i = 0; i < this.count; i++) {
            if (this.empList[i].getEmpID() == empID) {
                return this.empList[i];
            }
        }
        return null;
    }

    public int countHE() {
        int c = 0;
        for (int i = 0; i < this.count; i++) {
            if (this.empList[i] instanceof version5.HourlyEmployee) c++;
        }
        return c;
    }

    public int countPWE() {
        int c = 0;
        for (int i = 0; i < this.count; i++) {
            if (this.empList[i] instanceof version5.PieceWorkerEmployee) c++;
        }
        return c;
    }

    public int countCE() {
        int c = 0;
        for (int i = 0; i < this.count; i++) {
            if (this.empList[i] instanceof version5.CommissionEmployee
                    && !(this.empList[i] instanceof version5.BasePlusCommissionEmployee)) {
                c++;
            }
        }
        return c;
    }

    public int countBPCE() {
        int c = 0;
        for (int i = 0; i < this.count; i++) {
            if (this.empList[i] instanceof version5.BasePlusCommissionEmployee) c++;
        }
        return c;
    }

    public void displayHE() {
        for (int i = 0; i < this.count; i++) {
            if (this.empList[i] instanceof version5.HourlyEmployee) {
                version5.HourlyEmployee he = (version5.HourlyEmployee) this.empList[i];
                he.displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {
        for (int i = 0; i < this.count; i++) {
            if (this.empList[i] instanceof version5.PieceWorkerEmployee) {
                version5.PieceWorkerEmployee pwe = (version5.PieceWorkerEmployee) this.empList[i];
                pwe.displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {
        for (int i = 0; i < this.count; i++) {
            if (this.empList[i] instanceof version5.CommissionEmployee
                    && !(this.empList[i] instanceof version5.BasePlusCommissionEmployee)) {
                version5.CommissionEmployee ce = (version5.CommissionEmployee) this.empList[i];
                ce.displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE() {
        for (int i = 0; i < this.count; i++) {
            if (this.empList[i] instanceof version5.BasePlusCommissionEmployee) {
                version5.BasePlusCommissionEmployee bpce = (version5.BasePlusCommissionEmployee) this.empList[i];
                bpce.displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees() {
        for (int i = 0; i < this.count; i++) {
            version5.Employee emp = this.empList[i];
            System.out.printf("%d. ID: %d | Name: %s | Type: %s%n",
                    i + 1, emp.getEmpID(), emp.getEmpName(), emp.getClass().getSimpleName());
        }
    }

    public void displayPayroll(int currentMonth) {
        for (int i = 0; i < this.count; i++) {
            Employee emp = this.empList[i];
            double salary = 0.0;
            String label = "";

            if (emp instanceof version5.HourlyEmployee) {
                version5.HourlyEmployee he = (version5.HourlyEmployee) emp;
                salary = he.computeSalary(currentMonth);
                label = "Hourly";
            } else if (emp instanceof version5.PieceWorkerEmployee) {
                version5.PieceWorkerEmployee pwe = (version5.PieceWorkerEmployee) emp;
                salary = pwe.computeSalary(currentMonth);
                label = "Piece Worker";
            } else if (emp instanceof version5.BasePlusCommissionEmployee) {
                version5.BasePlusCommissionEmployee bpce = (version5.BasePlusCommissionEmployee) emp;
                salary = bpce.computeSalary(currentMonth);
                label = "Base Plus Commission";
            } else if (emp instanceof version5.CommissionEmployee) {
                version5.CommissionEmployee ce = (version5.CommissionEmployee) emp;
                salary = ce.computeSalary(currentMonth);
                label = "Commission";
            }

            double baseSalary = 0.0;
            if (emp instanceof version5.HourlyEmployee) baseSalary = ((HourlyEmployee) emp).computeSalary(-1);
            else if (emp instanceof version5.PieceWorkerEmployee) baseSalary = ((PieceWorkerEmployee) emp).computeSalary(-1);
            else if (emp instanceof version5.BasePlusCommissionEmployee) baseSalary = ((BasePlusCommissionEmployee) emp).computeSalary(-1);
            else if (emp instanceof version5.CommissionEmployee) baseSalary = ((CommissionEmployee) emp).computeSalary(-1);

            boolean bonusApplied = salary > baseSalary;

            System.out.printf("[%s] ID: %d | Name: %s | Salary: \u20b1%,.2f%s%n",
                    label, emp.getEmpID(), emp.getEmpName(), salary,
                    bonusApplied ? " (Birthday Bonus Applied)" : "");
        }
    }
}