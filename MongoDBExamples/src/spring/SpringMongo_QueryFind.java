package spring;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class SpringMongo_QueryFind {

	public static void main(String[] args) {
		// For Annotation
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
		MongoOperations mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");

		System.out.println("1 - findOne- with BasicQuery example");
		BasicQuery query1 = new BasicQuery("{ age : { $lt : 40 } }");
		Employee emp1 = mongoOperation.findOne(query1, Employee.class);
		System.out.println("query1 - " + query1.toString());
		System.out.println("emp1 - " + emp1);
		System.out.println("-----------------------------");

		System.out.println("2 - findOne AND example");
		Query query2 = new Query();
		query2.addCriteria(Criteria.where("name").is("DELIP").and("age").is(43));
		Employee emp2 = mongoOperation.findOne(query2, Employee.class);
		System.out.println("query2 - " + query2.toString());
		System.out.println("emp2 - " + emp2);
		System.out.println("-----------------------------");

		System.out.println("3 - findlist $and $lt, $gt example");
		Query query4 = new Query();
		query4.addCriteria(Criteria.where("age").lt(40).andOperator(Criteria.where("age").gt(10)));
		List<Employee> emp4 = mongoOperation.find(query4, Employee.class);
		System.out.println("query4 - " + query4.toString());
		for (Employee employee : emp4) {
			System.out.println("emp4 - " + employee);
		}
		System.out.println("-----------------------------");

		System.out.println("4 - find list and sorting example");
		Query query5 = new Query();
		query5.addCriteria(Criteria.where("age").gte(20));
		query5.with(new Sort(Sort.Direction.DESC, "age"));
		List<Employee> emp5 = mongoOperation.find(query5, Employee.class);
		System.out.println("query5 - " + query5.toString());
		for (Employee employee : emp5) {
			System.out.println("emp5 - " + employee);
		}
		System.out.println("-----------------------------");

		System.out.println(" 5- find by regex example");
		Query query6 = new Query();
		query6.addCriteria(Criteria.where("name").regex("A.*U", "i"));
		List<Employee> emp6 = mongoOperation.find(query6, Employee.class);
		System.out.println("query6 - " + query6.toString());
		for (Employee user : emp6) {
			System.out.println("emp6 - " + user);
		}
	}
}
