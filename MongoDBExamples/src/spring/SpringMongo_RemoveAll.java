package spring;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;

public class SpringMongo_RemoveAll {

	public static void main(String[] args) {
		// For Annotation
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		System.out.println("List Of all Saved Employees \n===================");
		List<Employee> employees = mongoOperation.findAll(Employee.class);

		for (Employee employee : employees) {
			System.out.println(employee);
			mongoOperation.remove(employee);
		}
		
		

	}

}
