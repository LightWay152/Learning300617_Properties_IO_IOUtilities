package lab.IO;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class IODemo {
	static String path = "c:/temp/data.txt";

	public static void main(String[] args) {
		/*FileInputStream - FileOutputStream*/
		//demo1();//write data into file
		//demo2();//read data from file
		
		/*ByteArrayInputStream - ByteArrayOutputStream*/
		demo3();//read and write data from URL into file
	}
	
	private static void demo3() {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			//URL url = new URL("http://img.f29.vnecdn.net/2017/06/30/biet-phu-Yen-Bai-7489-1498810065.jpg");
			URL url = new URL("http://bongdaplus.vn/");
			InputStream is = url.openStream();
			byte[] block = new byte[4*1024];
			while(true){
				int n = is.read(block);
				if(n <= 0){
					break;
				}
				baos.write(block,0,n);	
			}
			is.close();
			
			//baos.writeTo(new FileOutputStream("c:/temp/picture.jpg"));
			baos.writeTo(new FileOutputStream("c:/temp/football.html"));
			System.out.println("Download file completed!");
		} catch (MalformedURLException e) {
			System.out.println("Malformed URL");
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			System.out.println("File not found!");
		}
	}

	private static void demo2() {
		try {
			FileInputStream fis = new FileInputStream(path);
			int n = fis.available();
			byte[] data = new byte[n];
			fis.read(data);
			fis.close();
			
			System.out.println("Read file completed!");
			
			String text = new String(data);
			System.out.println(text);
		} catch (FileNotFoundException e) {
			System.out.println("Read file error!");
		} catch (IOException e) {
			System.out.println("Read file error!");
		}
	}

	private static void demo1() {
		try {
			byte[] data = "Cong cha nhu nui Thai Son".getBytes();
			
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(data);
			fos.close();
			
			System.out.println("Save file completed!");
		} catch (FileNotFoundException e) {
			System.out.println("Save file error!");
		} catch (IOException e) {
			System.out.println("Save file error!");
		}
	}

}
