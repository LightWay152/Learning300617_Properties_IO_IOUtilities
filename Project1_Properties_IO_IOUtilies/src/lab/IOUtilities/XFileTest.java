package lab.IOUtilities;

public class XFileTest {

	public static void main(String[] args) {
		byte[] data = XFile.read("c:/temp/picture.jpg");
		XFile.write(data, "c:/temp/picture2.jpg");
		
		byte[] data2 = XFile.download("http://img.f25.kinhdoanh.vnecdn.net/2017/06/30/bau-Duc-9852-1498823983.jpg");
		XFile.write(data2, "c:/temp/bau-duc.jpg");
	}

}
