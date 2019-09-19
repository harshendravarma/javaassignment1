package assignmnet1;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileFinder {
	static public void findFilesByRegex(File[] files, String regexPattern) {
		try {
			for (File file: files) {
				
				if (file.isFile()) {
					Pattern pattern = Pattern.compile(regexPattern);
					Matcher matcher = pattern.matcher(file.getName());
					if (matcher.matches()) {
						System.out.println(file);
					}
				}		
				else if (file.isDirectory()) {
					File[] subFiles = new File(file.getPath()).listFiles();
					if (subFiles != null) {
						findFilesByRegex(subFiles, regexPattern);
					}
				}
				
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		File[] files = new File("/home/").listFiles();
		 Scanner scanner = new Scanner(System.in);
	        while(true)
	        {
	            System.out.println("Enter the regular expression");
	            String regexPattern = scanner.next();
	            findFilesByRegex(files,regexPattern);
	        }
	}

}

