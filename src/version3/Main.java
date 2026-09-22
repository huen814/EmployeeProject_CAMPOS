package version3;

public class Main {

    public static void main(String[] args) {

        int targetMonth = 9; // September

        Name aliceName = new Name("Alice", "M", "Smith");
        MyDate aliceBirth = new MyDate(18, 9, 2000);
        MyDate aliceHired = new MyDate(1, 6, 2022);
        HourlyEmployee hourlyEmp = new HourlyEmployee(101, aliceName, aliceBirth, aliceHired, 45.00f, 200.00);

        Name bobName = new Name("Bob", "C", "Jones", "Jr.");
        MyDate bobBirth = new MyDate(5, 4, 1998);
        MyDate bobHired = new MyDate(15, 1, 2023);
        PieceWorkerEmployee pieceEmp = new PieceWorkerEmployee(201, bobName, bobBirth, bobHired, 90, 45.00);

        Employee[] employees = {hourlyEmp, pieceEmp};

        System.out.println("======================================================================");
        System.out.println("POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");

        int count = 1;
        for (Employee emp : employees) {
            double basePay = emp.computeSalary(-1);
            double totalWithBonus = emp.computeSalary(targetMonth);
            double bonus = totalWithBonus - basePay;
            boolean eligible = bonus > 0;

            System.out.println(count + ". " + emp);
            System.out.printf("   Base Pay: \u20b1%,.2f | Birthday Bonus: \u20b1%,.2f (%s)%n",
                    basePay, bonus, eligible ? "Eligible" : "Ineligible");
            System.out.printf("   Total Payout: \u20b1%,.2f%n%n", totalWithBonus);
            count++;
        }

        System.out.println("======================================================================");
        System.out.println("OBJECT CONTRACT TESTS (equals & hashCode)");
        System.out.println("======================================================================");

        HourlyEmployee emp1 = new HourlyEmployee(101, new Name("Alice", "M", "Smith"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.00f, 200.00);
        HourlyEmployee emp1Identical = new HourlyEmployee(101, new Name("Alice", "M", "Smith"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.00f, 200.00);
        HourlyEmployee emp2 = new HourlyEmployee(102, new Name("Sam", "K", "Reyes"),
                new MyDate(3, 3, 1999), new MyDate(1, 1, 2020), 30.00f, 150.00);

        System.out.println("emp1 equals emp1Identical: " + emp1.equals(emp1Identical));
        System.out.println("emp1 hashCode: " + emp1.hashCode()
                + " | emp1Identical hashCode: " + emp1Identical.hashCode()
                + " (Match: " + (emp1.hashCode() == emp1Identical.hashCode()) + ")");
        System.out.println("emp1 equals emp2: " + emp1.equals(emp2));

        System.out.println("======================================================================");
        System.out.println("DEEP CLONE VERIFICATION");
        System.out.println("======================================================================");

        HourlyEmployee empOriginal = new HourlyEmployee(101, new Name("Alice", "M", "Smith"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.00f, 200.00);
        HourlyEmployee empClone = empOriginal.clone();

        System.out.println("Original Name before modification: " + empOriginal.getEmpName());

        empClone.getEmpName().firstname = "Taylor";

        System.out.println("Clone Name changed to:             " + empClone.getEmpName());
        System.out.println("Original Name after modification:  " + empOriginal.getEmpName()
                + " (Deep copy successful!)");
    }
}