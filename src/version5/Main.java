package version5;

public class Main {

    private static final String LINE = "======================================================================";

    public static void main(String[] args) {

        System.out.println(LINE);
        System.out.println("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        System.out.println(LINE);

        EmployeeRoster roster = new EmployeeRoster();

        HourlyEmployee he1 = new HourlyEmployee(101, new Name("Alice", "M", "Smith"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.00f, 200.00);
        PieceWorkerEmployee pwe1 = new PieceWorkerEmployee(201, new Name("Bob", "C", "Jones", "Jr."),
                new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 90, 45.00);
        CommissionEmployee ce1 = new CommissionEmployee(301, new Name("Maria", "L", "Reyes"),
                new MyDate(20, 9, 1995), new MyDate(1, 3, 2021), 100000);
        BasePlusCommissionEmployee bpce1 = new BasePlusCommissionEmployee(401, new Name("Kevin", "S", "Tan"),
                new MyDate(10, 5, 1990), new MyDate(1, 2, 2020), 150000, 9500);

        System.out.println("Enrolled: " + he1.getEmpName() + " (Hourly) -> " + roster.addEmployee(he1));
        System.out.println("Enrolled: " + pwe1.getEmpName() + " (Piece Worker) -> " + roster.addEmployee(pwe1));
        System.out.println("Enrolled: " + ce1.getEmpName() + " (Commission) -> " + roster.addEmployee(ce1));
        System.out.println("Enrolled: " + bpce1.getEmpName() + " (Base Plus Commission) -> " + roster.addEmployee(bpce1));
        System.out.println("Add null -> " + roster.addEmployee(null));
        System.out.println("Total Roster Size: " + roster.countEmployees() + " employees");

        System.out.println();
        System.out.println("--- ROSTER COMPOSITION COUNTS ---");
        System.out.println("Hourly: " + roster.countHE());
        System.out.println("Piece Worker: " + roster.countPWE());
        System.out.println("Commission (Pure): " + roster.countCE());
        System.out.println("Base Plus Commission: " + roster.countBPCE());

        System.out.println();
        System.out.println(LINE);
        System.out.println("PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("[No downcasting; dynamic dispatch via Employee.computeSalary()]");
        System.out.println(LINE);
        roster.displayPayroll(9);

        System.out.println();
        System.out.println(LINE);
        System.out.println("COLLECTION REMOVAL TEST");
        System.out.println(LINE);

        int idToRemove = 201;
        Employee removed = roster.removeEmployee(idToRemove);
        if (removed != null) {
            System.out.println("Removing Employee ID " + idToRemove + "... Successfully removed.");
        } else {
            System.out.println("Employee ID " + idToRemove + " not found.");
        }
        System.out.println("Updated Roster Size: " + roster.countEmployees());

        System.out.println();
        System.out.println("Current Active Employees:");
        roster.displayAllEmployees();
        System.out.println(LINE);
    }
}
