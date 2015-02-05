import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileInterpreter {
	
	
	
	public static void identifyLanguage(String fileName){
		String readFile = null;
		String data = null;
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while((readFile = br.readLine()) != null){
				data = data+readFile;
			}
			if(data.contains("main")){
				System.out.println("Language:JAVA");
			}else if(data.contains("php")){
				System.out.println("Language:PHP");
			}else {
				System.out.println("Language:RUBY");
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void identifyClassNameJava(String fileName){
		String readFile = null;
		String data = null;
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while((readFile = br.readLine()) != null){
				if(readFile.contains("class") && readFile.contains("extends")){
					String splitted[] = readFile.split(" ");
					for(int i=0;i<splitted.length;i++){
						if(splitted[i].contains("extends")){
							System.out.println("Class Name:"+splitted[i-1]);	
						}
					}
				}else if(readFile.contains("class")){
					String splitted[] = readFile.split(" ");
					for(int i=0;i<splitted.length;i++){
						if(splitted[i].contains("{")){
							System.out.println("Class Name:"+splitted[i-1]);	
						}
					}
				}
			}
			
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void identifyClassNameRuby(String fileName){
		String readFile = null;
		String data = null;
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while((readFile = br.readLine()) != null){
				if(readFile.contains("class")){
					String splitted[] = readFile.split(" "); 
					System.out.println("Class Name:"+splitted[1]);
				}
			}
			
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void identifyClassNamePHP(String fileName){
		String readFile = null;
		String data = null;
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while((readFile = br.readLine()) != null){
				if(readFile.contains("class") && readFile.contains("extends")){
					String splitted[] = readFile.split(" ");
					for(int i=0;i<splitted.length;i++){
						if(splitted[i].contains("extends")){
							System.out.println("Class Name:"+splitted[i-1]);	
						}
					}
				}else if(readFile.contains("class")){
					String splitted[] = readFile.split(" ");
					for(int i=0;i<splitted.length;i++){
						if(splitted[i].contains("{")){
							System.out.println("Class Name:"+splitted[i-1]);	
						}
					}
				}
			}
			
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void listMethodsJava(String fileName){
		String readFile = null;
		String data = null;
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while((readFile = br.readLine()) != null){
				if(readFile.contains("public")|readFile.contains("protected")|readFile.contains("private")){
					String splitted[] = readFile.split(" ");
					
					for(int i=0;i<splitted.length;i++){
						if(splitted[i].contains("(")){
							System.out.print("Method Name:");
							for(int j=0;j<splitted[i].length();j++){
								
								if(splitted[i].charAt(j) != '('){
									System.out.print(splitted[i].charAt(j));
								}else{
									break;
								}
							}
						}
					}
					System.out.println();
					System.out.println("Access Specifer:"+splitted[0].trim());
				}
			}
			
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void listMethodsPHP(String fileName){
		String readFile = null;
		String data = null;
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while((readFile = br.readLine()) != null){
				if(readFile.contains("function")){
					String splitted[] = readFile.split(" ");
					for(int i=0;i<splitted.length;i++){
						if(splitted[i].contains("(")){
							System.out.println("Method Name:"+splitted[i]);
						}
					}
				}
			}
			
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void listMethodsRuby(String fileName){
		String readFile = null;
		String data = null;
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while((readFile = br.readLine()) != null){
				if(readFile.contains("def")){
					String splitted[] = readFile.split(" ");
					for(int i=0;i<splitted.length;i++){
						if(splitted[i].contains("(")){
							System.out.println("Method Name :"+splitted[i].trim());
						}
					}
				}
			}
			
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void listPropertiesRuby(String fileName){
		String readFile = null;
		String data = null;
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while((readFile = br.readLine()) != null){
				if(readFile.contains("@")){
					String splitted[] = readFile.split(" ");
					System.out.println("Variable:"+splitted[0].trim());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void listPropertiesPHP(String fileName){
		String readFile = null;
		String data = null;
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while((readFile = br.readLine()) != null){
				if(readFile.contains("public")){
					String splitted[] = readFile.split(" ");
					for(int i=0;i<splitted.length;i++){
						if(splitted[i].contains("$")){
							System.out.println("Varaibles :"+splitted[i].trim());
						}
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void listPropertiesJava(String fileName){
		String readFile = null;
		String data = null;
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while((readFile = br.readLine()) != null){
				if(readFile.contains("String") | readFile.contains("int") | readFile.contains("Long") | readFile.contains("boolean") | readFile.contains("Float")){
					String splitted[] = readFile.split(" ");
					if(readFile.contains("("))
						continue;
					else if(readFile.contains("public")|readFile.contains("protected")|readFile.contains("private")){
						System.out.println("Varaibles :"+splitted[2]);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		String fileName = "input_File.txt";
		
		String readFile = null;
		String data = null;
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while((readFile = br.readLine()) != null){
				data = data+readFile;
			}
			if(data.contains("main")){
				System.out.println("Language:JAVA");
				identifyClassNameJava(fileName);
				listMethodsJava(fileName);
				listPropertiesJava(fileName);
			}else if(data.contains("php")){
				System.out.println("Language:PHP");
				identifyClassNamePHP(fileName);
				listMethodsPHP(fileName);
				listPropertiesPHP(fileName);
			}else {
				System.out.println("Language:RUBY");
				identifyClassNameRuby(fileName);
				listMethodsRuby(fileName);
				listPropertiesRuby(fileName);
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
