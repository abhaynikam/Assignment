import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
  
public class Test {
	public static String readFile(String filename){
		String readFileLine = null;
		String data = null;
		try{
			BufferedReader br = new BufferedReader(new FileReader(filename));
			while((readFileLine = br.readLine()) != null){
				data = data+readFileLine;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return data;
		
		
	}
	public static void parseJavaFile(){
		String file = "input_File.txt";
		String data = readFile(file);
		
		try{
			
			Pattern p = Pattern.compile("class\\s*(\\w*)");
			Pattern p1 = Pattern.compile("public\\s*(String|int|Long|void)\\s*(\\w*)");
			//Pattern p2 = Pattern.compile("[^public]\\s*(String|int|Long|float)\\s*(\\w*)");
			
			Matcher m = p.matcher(data);
			Matcher m1 = p1.matcher(data);
			//Matcher m2 = p2.matcher(data);
			while(m.find()){
				System.out.println(m.group());
				
			}
			while(m1.find()){
				System.out.println(m1.group());
			}
			/*while(m2.find()){
				System.out.println(m2.group());
			}*/
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void parseRubyFile(){
		String file = "input_File.txt";
		String data = readFile(file);
		
		try{
			
			Pattern p = Pattern.compile("class\\s*(\\w*)");
			Pattern p1 = Pattern.compile("def\\s*(\\w*)\\s*[^()]");
			//Pattern p2 = Pattern.compile("[^public]\\s*(String|int|Long|float)\\s*(\\w*)");
			
			Matcher m = p.matcher(data);
			Matcher m1 = p1.matcher(data);
			//Matcher m2 = p2.matcher(data);
			while(m.find()){
				System.out.println(m.group());	
			}
			while(m1.find()){
				System.out.println(m1.group());
			}
			
			/*while(m2.find()){
				System.out.println(m2.group());
			}*/
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public static void parsePHPFile(){
		String file = "input_File.txt";
		String data = readFile(file);
		
		try{
			
			Pattern p = Pattern.compile("class\\s*(\\w*)");
			Pattern p1 = Pattern.compile("(public|protected)\\s*function\\s*(\\w*)\\s*[^()]");
			//Pattern p2 = Pattern.compile("[^public]\\s*(String|int|Long|float)\\s*(\\w*)");
			
			Matcher m = p.matcher(data);
			Matcher m1 = p1.matcher(data);
			//Matcher m2 = p2.matcher(data);
			while(m.find()){
				System.out.println(m.group());	
			}
			while(m1.find()){
				System.out.println(m1.group());
			}
			
			/*while(m2.find()){
				System.out.println(m2.group());
			}*/
			
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
    public static void main(String[] args) {  
    	String file = "input_File.txt";
    	String data = readFile(file);
    	try{
			
			Pattern p = Pattern.compile("main");
			Pattern p1 = Pattern.compile("function");
			//Pattern p2 = Pattern.compile("[^public]\\s*(String|int|Long|float)\\s*(\\w*)");
			
			Matcher m = p.matcher(data);
			Matcher m1 = p1.matcher(data);
			//Matcher m2 = p2.matcher(data);
			if(m.find()){
				System.out.println("Language:JAVA");
				parseJavaFile();
			}	
			
			else if(m1.find()){
				System.out.println("Language:PHP");
				parsePHPFile();
			}
			else{
				System.out.println("Language:RUBY");
				parseRubyFile();
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
    	
    }
       
}