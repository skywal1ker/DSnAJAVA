
import java.util.Scanner;
import java.io.*;

public class Hw2_p1 {

	static class Employee {

		private String name;
		private float salary;
		
		public Employee() {
		
		}
		
		public Employee(String n, float s) {
			name = n;
			salary = s;
		}
		
		public String getName() {return name;}
		public float getSalary() {return salary;}
		public void setName(String n) {name = n;}
		public void setSalary(float s) {salary = s;}
	
		public String toString() {
			String s = new String();
			s = s + "\tName = " + name;
			s = s + "\tSalary = " + salary;
			return s;
		}
	}

	
      /** 
   * @param input  = array of objects, low range and high range
   * This method calculates largest, lowest and average salaries, given range
   * @return //return count of employees with salary between range
   */ 
	public static int salaryBetween(Employee[] a, double low, double high) {

		//name of variable count
		//variable used for counting employees salary between 70,000 and 100000
		int count = 0;   

		//name of largest salary variable 
		//used to save the highest salary
		float largest = 0;  

		
		//name of lowest salary variable 
		//used to save the lowest salary
		float lowest = 0;  

		//name of SUM variable 
		//used to save the SUM Salary of ALL Employees
		float summ = 0;

		System.out.println("\nAll employees with salary between " + low + " and " + high);
		System.out.println();// this line to make a gap 

		for (Employee e : a) { 

			//Calculating Employees data with for loop with if statements


			//using lowest variable
			//using if statement below to find lowest value of salari in the list
			if (lowest == 0 || lowest > e.salary) { lowest = e.salary; } 

			//using largest variable
			//using if statement below to find largest value of salari in the list
			if (largest == 0 || e.salary > largest) { largest = e.salary; } 

			//using low and high input of method in if condition
			//checking if Employee Salary is in range
			//increminting count if condition true
			if (e.salary >= low && e.salary <= high ) { System.out.println(e); count ++; } 


			summ = summ + e.salary;                                              
			//total salary sum of all employees
		}
		
		System.out.println();
		// printing lower salary
		System.out.println("lowest salary = " + lowest); 

		//printing largest salary
		System.out.println("Highest salary = " + largest); 

		// calculating average salary of employees
		System.out.println("Average salary = " + summ/a.length);  

		//return count of employees with salary between range
		return count;
	}
	
	public static void main(String[] args) throws IOException {

		//
		int numEmp = 10;
		Employee[] empArray = new Employee[numEmp];


		// write a code segment here that reads input file and adds all employees		
		try {
			//here to create file object
			File myObj = new File("employee_info.txt");

			// this variable helps put data inside array
			int count = 0 ;

			//here to scan file
			Scanner myReader = new Scanner(myObj);

			//here I used while loop, it will be itearate untill data finished in the file that connected to read
			while (myReader.hasNextLine()) {

			// this variable to read line by line
			String data = myReader.nextLine();

			// this part to filling empty array
			// here i used method that grabs only string value, substring range and indexof 
			// but on the second part I used regular expression that allows grab only digits              
			empArray[count] = new Employee(data.substring(0, data.indexOf(" ")-1), Float.parseFloat(data.replaceAll("[^0-9]", "")));
			
			// this is for counting and for data store as well
			count += 1;
			}

			// after reading we need close the file
      		myReader.close();
		  } catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		  }

		// print all employees in the empArray
		System.out.println("\nAll employees\n");
		for (Employee e: empArray) { 
			System.out.println(e);
		}
		
		// set low and high
		// test with different values
		double low = 70000;
		double high = 100000;
		
		// // invoke salaryBetween method
		int numSalaryBetween = salaryBetween(empArray, low, high);
		
		System.out.println("\nNumber of employees with salary between " + low + 
		 		           " and " + high + " = " + numSalaryBetween);

	}
}









