package com.example.emp.employee_management;

import com.example.emp.employee_management.model.Employee;
import com.example.emp.employee_management.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {

		ApplicationContext c=SpringApplication.run(EmployeeManagementApplication.class, args);

		EmployeeService ser= c.getBean(EmployeeService.class);
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter your choice");
			System.out.println("1.AddEmployee\n 2.UpdateSalary \n 3.DeleteEmployee \n 4.GetEmployeeById \n 5.GetAllEmployee");

			int ch=sc.nextInt();
			switch (ch)
			{
				case 1:
					System.out.println("enter the details of the employee");
					System.out.println("enter the id of employee");
					int id=sc.nextInt();
					sc.nextLine();
					System.out.println("enetr thr name of the employee");
					String name=sc.nextLine();
					System.out.println("enter the role");
					String role=sc.nextLine();
					System.out.println("enter the salary");
					double sal=sc.nextDouble();
					Employee e=new Employee(id,name,role,sal);
					ser.addEmployee(e);
					break;
				case 2:
					System.out.println("enter the details of the employee");
					System.out.println("enter the id of employee");
					int id2=sc.nextInt();
					sc.nextLine();
					System.out.println("enter the new salary");
					double newsal=sc.nextDouble();
					ser.updateSalary(id2,newsal);
					break;
				case 3:
					System.out.println("enter the details of the employee");
					System.out.println("enter the id of employee");
					int id3=sc.nextInt();
					ser.deleteEmployee(id3);
					break;
				case 4:
					System.out.println("enter the id of employee");
					int id4=sc.nextInt();
					System.out.println(ser.getEmployee(id4));
					break;
				case 5:
					for(Employee val:ser.getAllEmployee())
					{
						System.out.println(val.toString());
					}
					break;
				case 6:
					System.exit(0);
				 default:
					 System.out.println("please enter a valid choice");
			}
		}



	}

}
