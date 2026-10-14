package version6;

public class Main {

    private static final String LINE = "======================================================================";

    public static void main(String[] args) {

        // 0. Instantiation blocking: Employee is abstract, so this line would NOT compile:
        // Employee e = new Employee(1, new Name("A", "B", "C"), new MyDate(1, 1, 2000), new MyDate(1, 1, 2020));

        System.out.println(LINE);
        System.out.println("1. TESTING ENCAPSULATION & DEFENSIVE COPYING");
        System.out.println(LINE);

        MyDate birth = new MyDate(15, 12, 1995);
        HourlyEmployee emp = new HourlyEmployee(101, new Name("Alice", "M", "Smith"),
                birth, new MyDate(1, 6, 2022), 45.00f, 200.00);

        System.out.println("Original Birth Month: " + emp.getBirthDate().getMonth()
                + " (" + emp.getBirthDate().getMonthName() + ")");

        System.out.println("Attempting external tampering: emp.getBirthDate().setMonth(9)...");
        emp.getBirthDate().setMonth(9);
        birth.setMonth(9); // also tamper with the original object passed to the constructor

        System.out.println("Employee's Actual Birth Date after tampering attempt: " + emp.getBirthDate());
        boolean protectedState = emp.getBirthDate().getMonth() == 12;
        System.out.println("Result: " + (protectedState
                ? "SUCCESS (Internal state protected via defensive copying)"
                : "FAILED (Internal state was modified)"));

        System.out.println();
        System.out.println(LINE);
        System.out.println("2. TESTING EXCEPTION HANDLING & INPUT VALIDATION");
        System.out.println(LINE);

        System.out.printf("Attempting to create HourlyEmployee with rate: %.2f...%n", -150.00);
        try {
            new HourlyEmployee(102, new Name("David", "A", "White"),
                    new MyDate(1, 1, 1997), new MyDate(1, 7, 2023), 40.00f, -150.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Exception: [" + e.getClass().getSimpleName() + "] " + e.getMessage());
        }

        System.out.println();
        System.out.println("Attempting to assign invalid calendar date: 31 Feb 2026...");
        try {
            new MyDate(31, 2, 2026);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Exception: [" + e.getClass().getSimpleName() + "] " + e.getMessage());
        }

        System.out.println();
        System.out.println(LINE);
        System.out.println("3. POLYMORPHIC PAYROLL EXECUTION (Target Month: Sep)");
        System.out.println("[Dynamic Dispatch via Abstract Contract computeSalary()]");
        System.out.println(LINE);

        EmployeeRoster roster = new EmployeeRoster();
        roster.addEmployee(new HourlyEmployee(101, new Name("Alice", "M", "Smith"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.00f, 200.00));
        roster.addEmployee(new PieceWorkerEmployee(201, new Name("Bob", "C", "Jones", "Jr."),
                new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 90, 45.00));
        roster.addEmployee(new CommissionEmployee(301, new Name("Maria", "L", "Reyes"),
                new MyDate(20, 9, 1995), new MyDate(1, 3, 2021), 100000));
        roster.addEmployee(new BasePlusCommissionEmployee(401, new Name("Kevin", "S", "Tan"),
                new MyDate(10, 5, 1990), new MyDate(1, 2, 2020), 150000, 9500));

        roster.displayPayroll(9);
        System.out.println(LINE);
    }
}
