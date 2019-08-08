package assignment2;

import java.io.File;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Filefinder{
	public void findfilesbyregex(String directory,String regexpattern){
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
		
}
public class Main {
	public static void main(String[] args) {
		Filefinder f=new Filefinder();
		f.findfilesbyregex("/home/zadmin/Desktop/mydetails","(.*/)*.+\\.(png|jpg|gif|bmp|jpeg|PNG|JPG|GIF|BMP|JPEG)$"
	);}
}