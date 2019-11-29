package package com.esure.cars;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.nio.file.*;
public class CarsInput {
	static Scanner s;
	static ArrayList<String> colours=new ArrayList<String>();
	public static void getCars(String filePath) {
		try {
			s= new Scanner(Paths.get(filePath));
			while(s.hasNextLine()) {
				String line=s.nextLine();
				if(line.contains("colour")) {
					line=line.replaceAll("colour", "");
					line=line.replaceAll("\"", "");
					line=line.replaceAll(":","");
					if(colours.size()>0) {
						boolean ispresent=false;
						for(int i=0; i<colours.size();i++) {
							if(colours.get(i).equals(line)) {
								ispresent=true;
							}
						}
						if(!ispresent) {
							colours.add(line);
							System.out.println(line);
						}
					}
					else {
						colours.add(line);
						System.out.println(line);
					}
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		CarsInput.getCars("cars.json");
	}

}
