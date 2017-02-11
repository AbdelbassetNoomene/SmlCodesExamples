package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class SpringMongo_Update {

	public static void main(String[] args) {
		// For Annotation
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		System.out.println("1- find and update");
		Query query1 = new Query();
		query1.addCriteria(Criteria.where("name").is("BALU"));
		Employee emp1 = mongoOperation.findOne(query1, Employee.class);
		System.out.println("Before Update : " + emp1);
		emp1.setAge(75);
		mongoOperation.save(emp1);
		Employee emp1_1 = mongoOperation.findOne(query1, Employee.class);
		System.out.println("After Update : " + emp1_1 + "\n------------------");
		
		

		System.out.println("2- select single field only");
		Query query2 = new Query();
		query2.addCriteria(Criteria.where("name").is("CHANDU"));
		query2.fields().include("name");
		query2.fields().include("age");
		Employee emp2 = mongoOperation.findOne(query2, Employee.class);
		System.out.println("Before Update : " + emp2);
		emp2.setAge(88);
		mongoOperation.save(emp2);
		Employee emp11 = mongoOperation.findOne(query2, Employee.class);
		System.out.println("After Update : " + emp11 + "\n------------------");
	}

}
