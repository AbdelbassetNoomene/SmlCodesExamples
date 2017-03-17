package treemodel;

import java.io.File;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class TreeModelExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			long id;
			String firstName = "";
			String middleName = "";
			String lastName = "";

			ObjectMapper mapper = new ObjectMapper();

			JsonNode root = mapper.readTree(new File("C:\\Users\\smlcodes\\Desktop\\JSONFIles\\tree.json"));

			// Get id
			id = root.path("id").asLong();
			System.out.println("id : " + id);

			// Get Name
			JsonNode nameNode = root.path("name");
			if (nameNode.isMissingNode()) {
				// if "name" node is missing
			} else {

				firstName = nameNode.path("first").asText();
				// missing node, just return empty string
				middleName = nameNode.path("middle").asText();
				lastName = nameNode.path("last").asText();

				System.out.println("firstName : " + firstName);
				System.out.println("middleName : " + middleName);
				System.out.println("lastName : " + lastName);

			}

			// Get Contact
			JsonNode contactNode = root.path("contact");
			if (contactNode.isArray()) {
				// If this node an Arrray?
			}

			for (JsonNode node : contactNode) {
				String type = node.path("type").asText();
				String ref = node.path("ref").asText();
				System.out.println("type : " + type);
				System.out.println("ref : " + ref);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
