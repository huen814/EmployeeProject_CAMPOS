package version4;

public class EmployeeRoster {

    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        this.max = 10;
        this.empList = new Employee[this.max];
        this.count = 0;
    }

    public EmployeeRoster(int max) {
        this.max = max;
        this.empList = new Employee[this.max];
        this.count = 0;
    }

    boolean addEmployee(Employee emp) {
        if (emp == null || this.count >= this.max) {
            return false;
        }
        this.empList[this.count] = emp;
        this.count++;
        return true;
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < this.count; i++) {
            if (this.empList[i].getEmpID() == empID) {
                Employee removed = this.empList[i];
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

    public Employee searchEmployee(int empID) {
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
            if (this.empList[i] instanceof HourlyEmployee) c++;
        }
        return c;
    }

    public int countPWE() {
        int c = 0;
        for (int i = 0; i < this.count; i++) {
            if (this.empList[i] instanceof PieceWorkerEmployee) c++;
        }
        return c;
    }

    public int countCE() {
        int c = 0;
        for (int i = 0; i < this.count; i++) {
            if (this.empList[i] instanceof CommissionEmployee
                    && !(this.empList[i] instanceof BasePlusCommissionEmployee)) {
                c++;
            }
        }
        return c;
    }

    public int countBPCE() {
        int c = 0;
        for (int i = 0; i < this.count; i++) {
            if (this.empList[i] instanceof BasePlusCommissionEmployee) c++;
        }
        return c;
    }

    public void displayHE() {
        for (int i = 0; i < this.count; i++) {
            if (this.empList[i] instanceof HourlyEmployee) {
                HourlyEmployee he = (HourlyEmployee) this.empList[i];
                he.displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {
        for (int i = 0; i < this.count; i++) {
            if (this.empList[i] instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee pwe = (PieceWorkerEmployee) this.empList[i];
                pwe.displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {
        for (int i = 0; i < this.count; i++) {
            if (this.empList[i] instanceof CommissionEmployee
                    && !(this.empList[i] instanceof BasePlusCommissionEmployee)) {
                CommissionEmployee ce = (CommissionEmployee) this.empList[i];
                ce.displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE() {
        for (int i = 0; i < this.count; i++) {
            if (this.empList[i] instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee bpce = (BasePlusCommissionEmployee) this.empList[i];
                bpce.displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees() {
        for (int i = 0; i < this.count; i++) {
            Employee emp = this.empList[i];
            System.out.printf("%d. ID: %d | Name: %s | Type: %s%n",
                    i + 1, emp.getEmpID(), emp.getEmpName(), emp.getClass().getSimpleName());
        }
    }

    public void displayPayroll(int currentMonth) {
        for (int i = 0; i < this.count; i++) {
            Employee emp = this.empList[i];
            double salary = 0.0;
            String label = "";

            if (emp instanceof HourlyEmployee) {
                HourlyEmployee he = (HourlyEmployee) emp;
                salary = he.computeSalary(currentMonth);
                label = "Hourly";
            } else if (emp instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee pwe = (PieceWorkerEmployee) emp;
                salary = pwe.computeSalary(currentMonth);
                label = "Piece Worker";
            } else if (emp instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee bpce = (BasePlusCommissionEmployee) emp;
                salary = bpce.computeSalary(currentMonth);
                label = "Base Plus Commission";
            } else if (emp instanceof CommissionEmployee) {
                CommissionEmployee ce = (CommissionEmployee) emp;
                salary = ce.computeSalary(currentMonth);
                label = "Commission";
            }

            double baseSalary = 0.0;
            if (emp instanceof HourlyEmployee) baseSalary = ((HourlyEmployee) emp).computeSalary(-1);
            else if (emp instanceof PieceWorkerEmployee) baseSalary = ((PieceWorkerEmployee) emp).computeSalary(-1);
            else if (emp instanceof BasePlusCommissionEmployee) baseSalary = ((BasePlusCommissionEmployee) emp).computeSalary(-1);
            else if (emp instanceof CommissionEmployee) baseSalary = ((CommissionEmployee) emp).computeSalary(-1);

            boolean bonusApplied = salary > baseSalary;

            System.out.printf("[%s] ID: %d | Name: %s | Salary: \u20b1%,.2f%s%n",
                    label, emp.getEmpID(), emp.getEmpName(), salary,
                    bonusApplied ? " (Birthday Bonus Applied)" : "");
        }
    }
}