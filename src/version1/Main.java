package version1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Main {

    public static void main(String[] args) {

        HourlyEmployee houremp = new HourlyEmployee(101, "Alice Smith", 45.00f, 200.00);

        System.out.println("---Hourly Employee Test--");
        System.out.println("[displayHourlyEmployee()]");
        houremp.displayHourlyEmployee();
        System.out.println("\n\n[toString()]");
        System.out.println(houremp.toString());

        CommissionEmployee emp = new CommissionEmployee(301, "Jane Doe", 5000.00);

        System.out.println("\n\n---Commission Employee Test---");
        System.out.println("[displayCommissionEmployee()]");
        emp.displayCommissionEmployee();

        System.out.println("\n\n[toString()]");
        System.out.println(emp);
    }
}

