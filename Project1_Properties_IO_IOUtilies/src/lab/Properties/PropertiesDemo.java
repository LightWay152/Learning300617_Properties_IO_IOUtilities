package lab.Properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) {
		/*setProperty - getProperty of Properties*/
		Properties props = new Properties();
		props.setProperty("one", "Mot");
		props.setProperty("school", "Truong Hoc");
		props.setProperty("university", "Truong Dai Hoc");
		props.setProperty("love", "Tinh Yeu");
		props.setProperty("education", "Giao Duc");
		
		String mean1 = props.getProperty("university");
		System.out.println(mean1);
		
		String mean2 = props.getProperty("computer");
		System.out.println(mean2);
		
		String mean3 = props.getProperty("computer","word not found");
		System.out.println(mean3);
		
		/*Write properties file*/
		String path = "c:/temp/dictionary.properties";
		try {
			props.store(new FileWriter(path), "Dictionary");
			System.out.println("Write file successfully!");
		} catch (IOException e) {
			System.out.println("File not found!");
		}
		
		/*Read properties file*/
		Properties props2 = new Properties();
		try {
			props2.load(new FileReader(path));
			System.out.println("Read file successfully!");
			System.out.println(props2.toString());
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			System.out.println("File not found!");
		}
		
	}

}
