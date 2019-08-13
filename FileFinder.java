package assignmnet1;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileFinder {
	static public void findfilesbyregex(String directory,String regexpattern){
		try {
			File path = new File(directory);
			File [] files = path.listFiles();
			for (int i = 0; i < files.length; i++){
				if (files[i].isFile()){
					Pattern pattern = Pattern.compile(regexpattern);
					Matcher matcher = pattern.matcher(files[i].getName()); 
					 if (matcher.matches()) {
					      System.out.println(files[i]);
					 }
					}
				}
			}catch (Exception e) {
				e.printStackTrace();
				}
		}
	public static void main(String[] args) {
		findfilesbyregex("/home/zadmin/Desktop/mydetails","(.*/)*.+\\.(png|jpg|gif|bmp|jpeg|PNG|JPG|GIF|BMP|JPEG)$");
	}

}
