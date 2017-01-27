package streamingapi;

import java.io.File;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;

public class JsonGeneratorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			JsonFactory jfactory = new JsonFactory();

			/*** write to file ***/
			JsonGenerator jGenerator = jfactory.createJsonGenerator(new File("C:\\Users\\kaveti_s\\Desktop\\JSONFIles\\skill.json"), JsonEncoding.UTF8);
			jGenerator.writeStartObject(); // {

			jGenerator.writeStringField("name", "Satya"); // "name" : "Satya"
			jGenerator.writeNumberField("age", 27); // "age" : 27

			jGenerator.writeFieldName("skills"); // "skills" :
			jGenerator.writeStartArray(); // [

			jGenerator.writeString("JAVA"); // "JAVA"
			jGenerator.writeString("Struts"); // "Struts"
			jGenerator.writeString("Springs"); // "Springs"

			jGenerator.writeEndArray(); // ]

			jGenerator.writeEndObject(); // }
			
			System.out.println("Json file created !!");

			jGenerator.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
