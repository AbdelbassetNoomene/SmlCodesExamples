package ignoretest;

public class StringUtil {
	
	private String str1;	
	private String str2;
	private String str3;
	
	public StringUtil(String str1, String str2) {		 
		this.str1 = str1;
		this.str2 = str2;
	}
	
	public String addStrings(){
		str3 = str1+str2;
		System.out.println("addStrings : "+str3);
		return str1+str2;
	}
	
	public String upperCase(){
		str3 = (str1+str2).toUpperCase();
		System.out.println("upperCase : "+str3);
		return str3;
	}
 

}
