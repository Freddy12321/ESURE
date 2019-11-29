package package com.esure.cars;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CarsOutput {
	public static void getOutCars(String colour, String fileName) {
		ArrayList<String> cars=new ArrayList<String>();
		ArrayList<String> car= new ArrayList<String>();
		try {
			Scanner s=new Scanner(Paths.get(fileName));
			PrintWriter out= new PrintWriter("outputCars.json");
			while(s.hasNextLine()) {
				String line= s.nextLine();
				if(line.contains("brand")) {
					car.add(line);
					for(int i=0; i<4; i++) {
						car.add(s.nextLine());
					}
					if(car.get(4).contains(colour)) {
						cars.addAll(car);
					}
					car.clear();
				}
				else {
					if(s.hasNextLine()) {
						s.nextLine();
					}
				}
			}
			out.println("{\n    \"cars\": [\n        {");
			for(int i=0; i<cars.size();i++) {
				out.println(cars.get(i));
				if(i%5==4) {
					out.println("        },\n        {");
				}
				System.out.println(cars.get(i));
			}
			out.println("        }\n    ]\n}");
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		getOutCars("blue", "cars.json");
	}
}
