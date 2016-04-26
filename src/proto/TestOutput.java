package proto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestOutput {
		public static void main(String[] args) {
			if (args.length == 0) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Add meg az ellenőrizendő kimeneti teszteset számát: ");
				String testNumber = sc.next();
				try {
					int counter = 0;
					
					boolean fail = false;
					
					BufferedReader expectedReader = new BufferedReader(new FileReader("expectedOutputs/testOut" + testNumber ));
					BufferedReader outReader = new BufferedReader(new FileReader("output/testOut" + testNumber));
					System.out.println(testNumber  + ". teszteset futtatasa:");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					String expected = expectedReader.readLine();
					String given = outReader.readLine();
					while(expected != null) {
						if (expected.equals(given))
							++counter;
						else {
							fail = true;
							System.out.println(String.valueOf(counter+1) + ". sor: nem egyezik a kimenet az elvart kimenettel!");
							System.out.println("Vart kimenet:   " + expected);
							System.out.println("Kapott kimenet: " + given);
						}
						expected = expectedReader.readLine();
						given = outReader.readLine();
					}
					if (fail)
						System.out.println("A teszt eredmenye: a kimenet nem egyezik a vart kimenettel.");
					else if (outReader.readLine() != null)
						System.out.println("A teszt eredmenye: a kimenet nem egyezik a vart kimenettel.");
					else
						System.out.println("A teszt eredmenye: megfelelo kimenet.");
					expectedReader.close();
					outReader.close();
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					br.readLine();
				}
				catch (IOException e) {
					System.out.println(testNumber);
					e.printStackTrace();
					System.out.println("Hibas bemeneti fajl.");
				}			
			}
		}
}
