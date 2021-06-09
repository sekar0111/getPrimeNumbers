package week1.day1.assignments;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetPrimeNumber {
	
	private static ArrayList<Integer> arrayOfPrimeNos = new ArrayList<Integer>();
	
	public static void getPrimeNumbersBelow (int target, int secondTraget) {
		
		/*
		 *  This method will get the Prime number from 1 to target parameter
		 *  secondTarget will get the nth position from the Prime Number
		 */
		
		int currentNumber = 1;
		//int prime = 0;
		
		for (int i = 1; i <= target; i++) {
			
			int count = 0;
			
			for (int j = 2; j <= currentNumber; j++) {
				
				if (currentNumber % j == 0) {
					
					count = count + 1;	
				}
				
			}
			
			if (count==1) {
				//System.out.println(currentNumber);
				//prime+=1;
				arrayOfPrimeNos.add(currentNumber);
			}
			currentNumber+=1;
		
		}
		if(arrayOfPrimeNos.size()>1) {	
			
			System.out.println("There are "+arrayOfPrimeNos.size()+" prime numbers between 1 to "+target);
//			for (int k=0; k<arrayOfPrimeNos.size();k++) {
//			System.out.println(arrayOfPrimeNos.get(k));
//			}
			System.out.println("And the "+secondTraget+" prime number is: "+arrayOfPrimeNos.get(secondTraget-1));
		}
		else {
			System.out.println("No prime number found");
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		getPrimeNumbersBelow(10, 2);
		write("C:\\Users\\Sathish\\Desktop", "Prime Numbers.xlsx", "10_Prime nos");
		
	}
	
	public static void write(String filePath, String fileName, String fileSheet) throws Exception {
		
		File file = new File(filePath+"\\"+fileName);
		
		FileInputStream fin = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fin);
		XSSFSheet sheet = workbook.createSheet(fileSheet);
		
		for(int i =0; i<GetPrimeNumber.arrayOfPrimeNos.size(); i++) {
		sheet.createRow(i).createCell(0).setCellValue(arrayOfPrimeNos.get(i).toString());
		}
		fin.close();
		FileOutputStream out = new FileOutputStream(file);
		workbook.write(out);
		System.out.println("Prime numbers are successfully writen in "+fileSheet+ " sheet of "+filePath+"\\"+fileName);
		out.close();
	}

}
