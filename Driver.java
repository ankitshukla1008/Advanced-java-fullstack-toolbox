// Write a simple Java program to manage employee details. Prompt the user to input the number of employee
// records they want to store. For each employee, collect the following information:
// 1. Employee ID (an integer)
// 2. Employee Name
// 3. Employee Address
// 4. Employee Mobile Number
// 5. Employee Salary (a floating-point number)
// Once the information is collected, display the entered employee details. Ensure the program handles input
// gracefully and provides clear prompts for the user.

import java.util.Scanner;
class Storage {
 int id;
 String name, address, mobile;
 double salary;
 Storage(int id, String name, String address, String mobile, double salary) {
 this.id = id;
 this.name = name;
 this.address = address;
 this.mobile = mobile;
 this.salary = salary;
 }
}
class Driver {
 public static void main(String args[]) {
 Scanner scanner = new Scanner(System.in);
 System.out.print("How many employee records do you want to store: ");
 int N = scanner.nextInt();
 Storage[] obj = new Storage[N];
 Scanner scan = new Scanner(System.in);
 for (int i = 0; i < N; i++) {
 System.out.print("Enter ID, Name, Address, Mobile, and Salary of " + (i + 1) + "th employee: ");
 int id = scanner.nextInt();
 String name = scan.nextLine();
 String address = scan.nextLine();
 String mobile = scan.nextLine();
 double salary = scanner.nextDouble();
 obj[i] = new Storage(id, name, address, mobile, salary);
 }
 System.out.println();
 System.out.println("Entered employee details are as follows: ");
 for (Storage o : obj) {
 System.out.println("ID: " + o.id);
 System.out.println("Name: " + o.name);
 System.out.println("Address: " + o.address);
 System.out.println("Mobile: " + o.mobile);
 System.out.println("Salary: " + o.salary);
 System.out.println();
 }
 scanner.close();
 }
}
