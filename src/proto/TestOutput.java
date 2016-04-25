package proto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TestOutput {
	// Argumentum n�lk�l mindent �sszehasonl�t.
		// 1 argumentum eset�n meg kell adni egy f�jlnevet.
		public static void main(String[] args) {
//			if (args.length == 0) {
//				int testFileCount = new File("expected/").listFiles().length;
//				for(int i = 0; i != testFileCount; ++i) {
//					try {
//						int counter = 0;
//						boolean fail = false;
//						BufferedReader expectedReader = new BufferedReader(new FileReader("expected/test" + String.valueOf(i+1) + ".txt"));
//						BufferedReader outReader = new BufferedReader(new FileReader("out/test" + String.valueOf(i+1) + ".txt"));
//						System.out.println(String.valueOf(i+1) + ". teszteset futtatasa:");
//						System.out.println("---------------------------------------");
//						String expected = null;
//						while( (expected = expectedReader.readLine()) != null) {
//							if (expected.equals(outReader.readLine()))
//								++counter;
//							else {
//								fail = true;
//								System.out.println(String.valueOf(counter+1) + ". sor: nem egyezik a kimenet az elvart kimenettel!");
//							}
//						}
//						if (fail)
//							System.out.println("A teszt eredmenye: helytelen kimenet.");
//						else if (outReader.readLine() != null)
//							System.out.println("A teszt eredmenye: helytelen kimenet.");
//						else
//							System.out.println("A teszt eredmenye: helyes kimenet.");
//						expectedReader.close();
//						outReader.close();
//						System.out.println();
//						BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//						br.readLine();
//					}		
//					catch (IOException e) {
//						System.out.println("Hibas bemeneti fajlok.");
//					}
//				}
//			}
			if (args.length == 0) {
				Scanner sc = new Scanner(System.in);
				System.out.println("Add meg az ellenőrizendő kimeneti tesztesetet: ");
				String testNumber = sc.nextLine();
				try {
					int counter = 0;
					boolean fail = false;
					BufferedReader expectedReader = new BufferedReader(new FileReader("expectedOutputs/testOut" + testNumber));//args[0]));
					BufferedReader outReader = new BufferedReader(new FileReader("output/testOut" + testNumber));//args[0]));
					System.out.println(/*args[0]*/ testNumber  + ". teszteset futtatasa:");
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
