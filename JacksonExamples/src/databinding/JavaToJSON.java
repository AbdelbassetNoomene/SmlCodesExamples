package databinding;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.map.ObjectMapper;

public class JavaToJSON {
public static void main(String[] args) {
	
	StudentBo studentBo = new StudentBo();
	studentBo.setId(101);
	studentBo.setName("Satya Kaveti");
	
	List<String> adr = new ArrayList<>();
	adr.add("D.No:3-100");
	adr.add("NEAR RAMALAYAM");
	adr.add("VIJAYAWADA");
	adr.add("PINCODE:520007");
	studentBo.setAddress(adr);
	
	try{
	ObjectMapper mapper = new ObjectMapper();
	mapper.writeValue(new File("C:\\Users\\smlcodes\\Desktop\\JSONFIles\\skill.json"), studentBo);

	//Convert object to JSON string
	String jsonInString = mapper.writeValueAsString(studentBo);
	System.out.println("Converted object to JSON string \n"+jsonInString);

	//Convert object to JSON string and pretty print
	jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(studentBo);
	System.out.println("JSON :\n"+jsonInString);
	
	System.out.println("JAVA TO JSON COMPLETED !!");
	}catch (Exception e) {
			e.printStackTrace();
		}	
}
}
