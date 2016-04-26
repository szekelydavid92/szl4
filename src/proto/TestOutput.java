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
				String testNumber = sc.nextLine();
				try {
					int counter = 0;
					boolean fail = false;
					BufferedReader expectedReader = new BufferedReader(new FileReader("expectedOutputs/testOut" + testNumber));
					BufferedReader outReader = new BufferedReader(new FileReader("output/testOut" + testNumber));
					System.out.println(testNumber  + ". teszteset futtatasa:");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					String expected = null;
					while( (expected = expectedReader.readLine()) != null) {
						if (expected.equals(outReader.readLine()))
							++counter;
						else {
							fail = true;
							System.out.println(String.valueOf(counter+1) + ". sor: nem egyezik a kimenet az elvart kimenettel!");
						}
					}
					if (fail)
						System.out.println("A teszt eredmenye: nem megfelelo kimenet.");
					else if (outReader.readLine() != null)
						System.out.println("A teszt eredmenye: nem megfelelo kimenet.");
					else
						System.out.println("A teszt eredmenye: megfelelo kimenet.");
					expectedReader.close();
					outReader.close();
					BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
					br.readLine();
				}
				catch (IOException e) {
					System.out.println("Hibas bemeneti fajl.");
				}			
			}
		}
}
