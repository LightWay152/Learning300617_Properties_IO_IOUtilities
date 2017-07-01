package lab.Properties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class DictionaryApp {
	static Scanner scanner = new Scanner(System.in);
	static String path = "c:/temp/dictionary.properties";
	static String path2 = "c:/temp/dictionary2.xml";
	static Properties props = new Properties();
	
	public static void main(String[] args) {
		while(true){
			menu();
		}
	}

	private static void menu() {
		System.out.println("1. Search");
		System.out.println("2. Add new word");
		System.out.println("3. Open file");
		System.out.println("4. Save file");
		System.out.println("5. Exit");
		System.out.print("> Choose the option? ");
		
		int choose = scanner.nextInt();
		scanner.nextLine();
		
		switch(choose){
		case 1:
			search();
			break;
		case 2:
			addNewWord();
			break;
		case 3:
			/*case 3, 4: 
			 * only run 1 function or Properties or XML
			 * */
			openFileProperties();
			//openFileXml();
			break;
		case 4:
			/*case 3, 4: 
			 * only run 1 function or Properties or XML
			 * */
			saveFileProperties();
			//saveFileXml();
			break;
		case 5:
			System.exit(0);
			break;
		default:
			break;
		}
	}

	private static void saveFileXml() {
		try {
			props.storeToXML(new FileOutputStream(path2), "Dictionary2");
			System.out.println("Save file successfully!");
			System.out.println(props.toString());
		} catch (IOException e) {
			System.out.println("Save file error!");
		}
	}

	private static void openFileXml() {
		try {
			props.loadFromXML(new FileInputStream(path2));
			System.out.println("Open file successfully!");
			System.out.println(props.toString());
		} catch (FileNotFoundException e) {
			System.out.println("Open file error!");
		} catch (IOException e) {
			System.out.println("Open file error!");
		}
	}

	private static void saveFileProperties() {
		try {
			props.store(new FileWriter(path), "Dictionary");
			System.out.println("Save file successfully!");
			System.out.println(props.toString());
		} catch (IOException e) {
			System.out.println("Save file error!");
		}
	}

	private static void openFileProperties() {
		try {
			props.load(new FileReader(path));
			System.out.println("Open file successfully!");
			System.out.println(props.toString());
		} catch (FileNotFoundException e) {
			System.out.println("Open file error!");
		} catch (IOException e) {
			System.out.println("Open file error!");
		}
	}

	private static void addNewWord() {
		while(true){
			System.out.print("Word: ");
			String word = scanner.nextLine();
			System.out.print("Mean: ");
			String mean = scanner.nextLine();
			props.setProperty(word, mean);	
			
			System.out.print("Add new word (Y/N)? ");			
			if(scanner.nextLine().equalsIgnoreCase("N")){
				break;
			}
		}
	}

	private static void search() {
		System.out.print("Word: ");
		String word = scanner.nextLine();
		String mean = props.getProperty(word,"Word not found!");
		System.out.println("Mean: "+mean);
	}

}
