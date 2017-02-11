package spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class SpringMongo_Delete {

	public static void main(String[] args) {
		// For Annotation
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");


		Query query1 = new Query();
		query1.addCriteria(Criteria.where("name").is("DELIP").and("age").is(43));
		Employee emp2 = mongoOperation.findOne(query1, Employee.class);
		mongoOperation.remove(query1, Employee.class);


		System.out.println("\nAll users : ");
		List<Employee> allEmployees = mongoOperation.findAll(Employee.class);
		for (Employee user : allEmployees) {
			System.out.println(user);
		}
		//mongoOperation.dropCollection(Employee.class);
		
		System.out.println("ALL Employees DELETED");
		System.out.println("================\n THE END MONGODB\n ==============");

	}

}
