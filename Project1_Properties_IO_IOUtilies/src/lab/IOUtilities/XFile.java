package lab.IOUtilities;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class XFile {
	
	/**
	 * Write data into binary file
	 * @param data need to write
	 * @return path is path of file which include data
	 * */
	public static void write(byte[] data,String path) {
		try {			
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
	
	/**
	 * Read data into binary file
	 * @param path is path of file need to read
	 * @return data read from file
	 * */
	public static byte[] read(String path) {
		try {
			FileInputStream fis = new FileInputStream(path);
			int n = fis.available();
			byte[] data = new byte[n];
			fis.read(data);
			fis.close();
			
			System.out.println("Read file completed!");
			
			return data;
		} catch (FileNotFoundException e) {
			System.out.println("Read file error!");
			return null;
		} catch (IOException e) {
			System.out.println("Read file error!");
			return null;
		}
	}
	
	/**
	 * Download data from Internet resourse's
	 * @param address is resourse's address
	 * @return data read from file
	 * */
	public static byte[] download(String address) {
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			URL url = new URL(address);
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
			System.out.println("Download file completed!");
			return baos.toByteArray();
		} catch (MalformedURLException e) {
			System.out.println("Malformed URL");
			return null;
		} catch (FileNotFoundException e) {
			System.out.println("Download error!");
			return null;
		} catch (IOException e) {
			System.out.println("Download error!");
			return null;
		}
	}
	
}
