package streamingapi;

import java.io.File;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

public class JsonParserExample {
	public static void main(String[] args) {

		try {

			JsonFactory jfactory = new JsonFactory();

			/*** read from file ***/
			JsonParser jParser = jfactory.createJsonParser(new File("C:\\Users\\smlcodes\\Desktop\\JSONFIles\\skill.json"));

			// loop until token equal to "}"
			while (jParser.nextToken() != JsonToken.END_OBJECT) {

				String fieldname = jParser.getCurrentName();
				if ("name".equals(fieldname)) {

					// current token is "name",
					// move to next, which is "name"'s value
					jParser.nextToken();
					System.out.println(jParser.getText()); // display mkyong

				}

				if ("age".equals(fieldname)) {

					// current token is "age",
					// move to next, which is "name"'s value
					jParser.nextToken();
					System.out.println(jParser.getIntValue()); // display 29

				}

				if ("messages".equals(fieldname)) {

					jParser.nextToken(); // current token is "[", move next

					// messages is array, loop until token equal to "]"
					while (jParser.nextToken() != JsonToken.END_ARRAY) {

						// display msg1, msg2, msg3
						System.out.println(jParser.getText());

					}

				}

			}
			jParser.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
}
