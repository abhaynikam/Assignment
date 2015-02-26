import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
  
public class Parser {
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
	public static void parseJavaFile(String fileName){
		String data = readFile(fileName);
		
		try{
			
			Pattern p = Pattern.compile("class \\w+");
			Pattern p1 = Pattern.compile("\\w+ \\w+ \\w+\\(\\)");
			Pattern p2 = Pattern.compile("\\w+ \\w+[=?|;]");
			
			Matcher m = p.matcher(data);
			Matcher m1 = p1.matcher(data);
			Matcher m2 = p2.matcher(data);
			System.out.println("\nClasses in file " + fileName);
			while(m.find()){
				System.out.println(m.group());
			}
			System.out.println("\nMethods in file " + fileName);
			while(m1.find()){
				System.out.println(m1.group());
			}
			System.out.println("\nProperties in file " + fileName);
			while(m2.find()){
				System.out.println(m2.group());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void parseRubyFile(String fileName){
		String data = readFile(fileName);
		
		try{
			
			Pattern p = Pattern.compile("class \\w+");
			Pattern p1 = Pattern.compile("def \\w+");
			Pattern p2 = Pattern.compile("@+\\w+");
			
			Matcher m = p.matcher(data);
			Matcher m1 = p1.matcher(data);
			Matcher m2 = p2.matcher(data);
			System.out.println("\nClasses in file " + fileName);
			while(m.find()){
				System.out.println(m.group());	
			}
			System.out.println("\nMethods in file " + fileName);
			while(m1.find()){
				System.out.println(m1.group());
			}
			System.out.println("\nProperties in file " + fileName);
			while(m2.find()){
				System.out.println(m2.group());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public static void parsePHPFile(String fileName){
		String data = readFile(fileName);
		
		try{
			
			Pattern p = Pattern.compile("class \\w+");
			Pattern p1 = Pattern.compile("\\w+ function \\w+");
			Pattern p2 = Pattern.compile("\\w+ \\$\\w+\\s");
			
			Matcher m = p.matcher(data);
			Matcher m1 = p1.matcher(data);
			Matcher m2 = p2.matcher(data);
			System.out.println("\nClasses in file " + fileName);
			while(m.find()){
				System.out.println(m.group());	
			}
			System.out.println("\nMethods in file " + fileName);
			while(m1.find()){
				System.out.println(m1.group());
			}
			System.out.println("\nProperties in file " + fileName);
			while(m2.find()){
				System.out.println(m2.group());
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
    public static void main(String[] args) {  
    	String file = null ;
    	
    	Scanner in = new Scanner(System.in);
    	try{
    		System.out.println("File to parse:");
			file = in.next();
			String data = readFile(file);
			Pattern p = Pattern.compile("main");
			Pattern p1 = Pattern.compile("function");
			//Pattern p2 = Pattern.compile("[^public]\\s*(String|int|Long|float)\\s*(\\w*)");
			
			Matcher m = p.matcher(data);
			Matcher m1 = p1.matcher(data);
			//Matcher m2 = p2.matcher(data);
			if(m.find()){
				System.out.println("Language:JAVA");
				parseJavaFile(file);
			}	
			
			else if(m1.find()){
				System.out.println("Language:PHP");
				parsePHPFile(file);
			}
			else{
				System.out.println("Language:RUBY");
				parseRubyFile(file);
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
    	
    }
       
}
