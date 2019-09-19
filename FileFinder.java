package assignmnet1;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileFinder {
	/*given files and regular expression finds all the files matching regular expression*/
	static public void findFilesByRegex(File[] files, String regexPattern) {
		try {
			for (File file: files) {
				//if it is file match with regular expression
				if (file.isFile()) {
					Pattern pattern = Pattern.compile(regexPattern);
					Matcher matcher = pattern.matcher(file.getName());
					if (matcher.matches()) {
						System.out.println(file);
					}
				}
				//if it is a directory search inside directory
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

