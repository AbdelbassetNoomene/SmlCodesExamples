package spring;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class SpringMongo_Insert {

	public static void main(String[] args) {
		// For Annotation
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		System.out.println("1 - insert a Employee, put 'employee' as collection name");
		Employee emp1 = new Employee("101", "1.akil@one.com", "AKHIL", 30, "Hyderabad");
		mongoOperation.save(emp1, "employee");

		System.out.println("2- insert a Emmployee, put bean name as collection name");
		Employee emp2 = new Employee("102", "2.balu@two.com", "BALU", 25, "Vijayawada");
		mongoOperation.save(emp2);

		System.out.println("3 - insert a list of employees");
		Employee emp3 = new Employee("103", "3.chandu@two.com", "CHANDU", 35, "Mumbai");
		Employee emp4 = new Employee("104", "4.delip@two.com", "DELIP", 43, "Delhi");
		Employee emp5 = new Employee("105", "5.Ervin@two.com", "ERVIN", 29, "Kolkata");
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(emp3);
		empList.add(emp4);
		empList.add(emp5);
		mongoOperation.insert(empList, Employee.class);

		System.out.println("List Of all Saved Employees \n===================");
		List<Employee> employees = mongoOperation.findAll(Employee.class);

		for (Employee employee : employees) {
			System.out.println(employee);
			//mongoOperation.remove(employee);
		}
	}
}
