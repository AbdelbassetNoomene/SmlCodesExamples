package core;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;
public class MongoDB_Update {

	public static void getDocs(DBCollection collection) {
		DBCursor cursor = collection.find();
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}
	public static void main(String[] args) throws Exception {
		
		Mongo mongo = new Mongo("localhost", 27017);
		DB db = mongo.getDB("smlcodes");

		DBCollection collection = db.getCollection("users");
		getDocs(collection);

		
		//1.Find document  username = ‘Anil’, and update city='BANGLORE'
		System.out.println("1.Update \n=======");
		
		BasicDBObject newDocument = new BasicDBObject();
		  newDocument.put("city", "BANGLORE");

		  BasicDBObject searchQuery = new BasicDBObject().append("username", "Anil");

		  collection.update(searchQuery, newDocument);
		getDocs(collection);

		 
		
		
	}
	
}
