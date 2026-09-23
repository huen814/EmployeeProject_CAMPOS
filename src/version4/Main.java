package version4;

public class Main {

    public static void main(String[] args) {

        System.out.println("======================================================================");
        System.out.println("EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT");
        System.out.println("======================================================================");

        EmployeeRoster roster = new EmployeeRoster(6);

        HourlyEmployee he1 = new HourlyEmployee(101, new Name("Alice", "M", "Smith"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.00f, 200.00);
        PieceWorkerEmployee pwe1 = new PieceWorkerEmployee(201, new Name("Bob", "C", "Jones", "Jr."),
                new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 90, 45.00);
        CommissionEmployee ce1 = new CommissionEmployee(301, new Name("Maria", "L", "Reyes"),
                new MyDate(20, 9, 1995), new MyDate(1, 3, 2021), 200000);
        BasePlusCommissionEmployee bpce1 = new BasePlusCommissionEmployee(401, new Name("Kevin", "S", "Tan"),
                new MyDate(10, 5, 1990), new MyDate(1, 2, 2020), 150000, 10000);
        HourlyEmployee he2 = new HourlyEmployee(102, new Name("David", "A", "White"),
                new MyDate(1, 1, 1997), new MyDate(1, 7, 2023), 40.00f, 200.00);

        System.out.println("Added: " + he1.getEmpName() + " (Hourly) -> " + (roster.addEmployee(he1) ? "Success" : "Failed"));
        System.out.println("Added: " + pwe1.getEmpName() + " (Piece Worker) -> " + (roster.addEmployee(pwe1) ? "Success" : "Failed"));
        System.out.println("Added: " + ce1.getEmpName() + " (Commission) -> " + (roster.addEmployee(ce1) ? "Success" : "Failed"));
        System.out.println("Added: " + bpce1.getEmpName() + " (Base Plus Commission) -> " + (roster.addEmployee(bpce1) ? "Success" : "Failed"));
        System.out.println("Added: " + he2.getEmpName() + " (Hourly) -> " + (roster.addEmployee(he2) ? "Success" : "Failed"));

        HourlyEmployee he3 = new HourlyEmployee(103, new Name("Sam", "K", "Cruz"),
                new MyDate(2, 2, 1992), new MyDate(1, 3, 2021), 38.00f, 180.00);
        System.out.println("Added: " + he3.getEmpName() + " (Hourly) -> " + (roster.addEmployee(he3) ? "Success" : "Failed"));

        HourlyEmployee overflow = new HourlyEmployee(104, new Name("Over", "F", "Low"),
                new MyDate(1, 1, 1990), new MyDate(1, 1, 2020), 40.00f, 100.00);
        System.out.println("Attempting to add beyond capacity (Over, F. Low) -> "
                + (roster.addEmployee(overflow) ? "Success" : "Failed (Roster Full)"));

        System.out.println();
        System.out.println("--- ROSTER COMPOSITION COUNTS ---");
        System.out.println("Total Employees: " + 6 + " / " + 6);
        System.out.println("Hourly Employees: " + roster.countHE());
        System.out.println("Piece Worker Employees: " + roster.countPWE());
        System.out.println("Commission Employees (Pure): " + roster.countCE());
        System.out.println("Base Plus Commission Employees: " + roster.countBPCE());


        System.out.println();
        System.out.println("======================================================================");
        System.out.println("ROSTER PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");
        roster.displayPayroll(9);

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION");
        System.out.println("======================================================================");

        int idToRemove = 201;
        Employee removed = roster.removeEmployee(idToRemove);
        if (removed != null) {
            System.out.println("Removing Employee ID " + idToRemove + " (" + removed.getEmpName() + ")... Successfully removed.");
        } else {
            System.out.println("Employee ID " + idToRemove + " not found.");
        }

        System.out.println();
        System.out.println("Remaining Employees in Roster:");
        roster.displayAllEmployees();
    }
}