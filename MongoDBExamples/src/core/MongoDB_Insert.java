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
public class MongoDB_Insert {
	public static void main(String[] args) {

		try {

			Mongo mongo = new Mongo("localhost", 27017);
			DB db = mongo.getDB("smlcodes");

			DBCollection collection = db.getCollection("users");
			collection.remove(new BasicDBObject());

			// 1. BasicDBObject example
			System.out.println("1.BasicDBObject example...");
			System.out.println("===========================");
			BasicDBObject document = new BasicDBObject();
			document.put("username", "satyajohnny");
			document.put("password", "password254");

			BasicDBObject documentDetail = new BasicDBObject();
			documentDetail.put("street", "RAMALAYAM");
			documentDetail.put("city", "VIJAYAWADA");
			documentDetail.put("state", "ANDHRA PRADESH");
			document.put("address", documentDetail);
			collection.insert(document);

			DBCursor cursorDoc = collection.find();
			while (cursorDoc.hasNext()) {
				System.out.println(cursorDoc.next());
			}
			collection.remove(new BasicDBObject());

			// 2. BasicDBObjectBuilder example
			System.out.println("\n\n 2.BasicDBObjectBuilder Insert");
			System.out.println("===========================");
			BasicDBObjectBuilder documentBuilder = BasicDBObjectBuilder.start().add("username", "Anil").add("password",
					"Anigirekula123");

			BasicDBObjectBuilder documentBuilderDetail = BasicDBObjectBuilder.start().add("street", "NTR STREET")
					.add("city", "HYDERABAD").add("state", "TN");
			documentBuilder.add("detail", documentBuilderDetail.get());
			collection.insert(documentBuilder.get());

			DBCursor cursorDocBuilder = collection.find();
			while (cursorDocBuilder.hasNext()) {
				System.out.println(cursorDocBuilder.next());
			}
			collection.remove(new BasicDBObject());

			// 3. Map example
			System.out.println("\n\n 3.MAP Insert");
			System.out.println("===========================");
			Map<String, Object> documentMap = new HashMap<String, Object>();
			documentMap.put("username", "mapuser");
			documentMap.put("password", "mapassword");

			Map<String, Object> documentMapDetail = new HashMap<String, Object>();
			documentMapDetail.put("street", "JAMES STREET");
			documentMapDetail.put("city", "GEORGIO");
			documentMapDetail.put("state", "U.S");
			documentMap.put("detail", documentMapDetail);
			collection.insert(new BasicDBObject(documentMap));

			DBCursor cursorDocMap = collection.find();
			while (cursorDocMap.hasNext()) {
				System.out.println(cursorDocMap.next());
			}
			collection.remove(new BasicDBObject());

			// 4. JSON parse example
			System.out.println("\n\n 4.JSON Insert");
			System.out.println("===========================");

			String json = "{'username' : 'jsonuser','password' : 'JsonPass',"
					+ "'detail' : {'street' : 'FIGHTCLUB STREET', 'city' : 'MELBORN', 'state' : 'AUS'}}}";

			DBObject dbObject = (DBObject) JSON.parse(json);
			collection.insert(dbObject);

			DBCursor cursorDocJSON = collection.find();
			while (cursorDocJSON.hasNext()) {
				System.out.println(cursorDocJSON.next());
			}
			collection.remove(new BasicDBObject());

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (MongoException e) {
			e.printStackTrace();
		}

	}
}
