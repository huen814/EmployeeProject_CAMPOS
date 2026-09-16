package version1;
import version2.MyDate;
import version2.Name;

import java.sql.SQLOutput;
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

        Name aliceName = new Name("Alice","M","Smith");
        MyDate aliceBirth = new MyDate(12,9,2004);
        HourlyEmployee houremp = new HourlyEmployee(101, aliceName,aliceBirth, 45.00f, 200.00);

        System.out.println("Name:  " + aliceName);
        System.out.println("Date: " + aliceBirth);
        System.out.println("\n");


        System.out.println("---Hourly Employee Payroll Test--");
        System.out.println("[displayHourlyEmployee()]");
        houremp.displayHourlyEmployee();
        System.out.println("\n\n[toString()]");
        System.out.println(houremp.toString());

        Name janeName = new Name("Jane","Z","Doe");
        MyDate janeBirth = new MyDate(11,9,2005);
        CommissionEmployee comemp = new CommissionEmployee(102,janeName,janeBirth,5000.00);
      //  CommissionEmployee emp = new CommissionEmployee(301, "Jane Doe", 5000.00);

        System.out.println("\n\n---Commission Employee Test---");
        System.out.println("[displayCommissionEmployee()]");
        comemp.displayCommissionEmployee();
        System.out.println("\n\n[toString()]");
        System.out.println(comemp.toString());
    }
}

