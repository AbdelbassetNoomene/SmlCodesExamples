package databinding;

import java.io.File;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonToJava {
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			// Convert JSON string from file to Object
			StudentBo StudentBo = mapper.readValue(new File("C:\\Users\\smlcodes\\Desktop\\JSONFIles\\JavaToJSON.json"),
					StudentBo.class);
			System.out.println(StudentBo.getId());
			System.out.println(StudentBo.getName());
			System.out.println(StudentBo.getAddress());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
