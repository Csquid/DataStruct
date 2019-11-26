package sort;

import java.util.Random;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		sort sr = new sort();
		Scanner scan = new Scanner(System.in);
		
		System.out.print("범위: ");
		
		int nSize = scan.nextInt();
		int[] nArr = new int[nSize];
		
		for(int i = 0; i < nArr.length; i++) {
			Random rand = new Random();
			nArr[i] = rand.nextInt(nSize);
		}
		
		sr.StartSortParty(nArr);
	}
}
