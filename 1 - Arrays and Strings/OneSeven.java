/*
Problem 1.7 - Cracking the Coding Interview

Write a method such that if an element in an MxN matrix is set to 0, 
its entire row and column are set to 0.

James Earle - September 2, 2015
*/
import java.io.*;
public class OneSeven {

	//Integers between 1-15 in array.
	static final int MAX = 15;
	BufferedReader reader;

	public OneSeven(){
		reader = new BufferedReader(new InputStreamReader(System.in));
		int m, n;
		String line;

		try{ 
			System.out.print("M: ");
			m = Integer.valueOf(reader.readLine());

			System.out.print("N: ");
			n = Integer.valueOf(reader.readLine());

			int[][] example = generateArray(m, n);
			print(example, "Before");

			int row = (int)(Math.random() * (m - 1));
			int col = (int)(Math.random() * (n - 1));

			setZero(row, col, example);
			print(example, "After");
		} catch(IOException e) {
			e.printStackTrace();
		}	
	}

	public void setZero(int row, int col, int[][] arr) {
		//Bounds checking
		if(row >= 0 && row <= arr.length && col >= 0 && col < arr[row].length) {
			arr[row][col] = 0; //O(1)
			zeroRow(row, arr); //O(n)
			zeroCol(col, arr); //O(m)
			//Timw:  O(m + n)
			//Space: O(mn)
		} else {
			System.out.println("row and col are out of bounds.");
		}
	}

	public void zeroRow(int row, int[][] arr) {
		for(int i=0;i<arr[row].length;i++) {
			arr[row][i] = 0;
		}
	}

	public void zeroCol(int col, int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			arr[i][col] = 0;
		}
	}

	//For testing, generates an array size MxN with random numbers 1-15
	public int[][] generateArray(int m, int n) {
		int[][] result = new int[m][n];

		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				result[i][j] = (int)(Math.random() * MAX);
			}
		}

		return result;
	}

	public void print(int[][] arr, String msg) {
		System.out.println("\n" + msg);
		for(int[] i : arr) {
			for(int j : i) {
				System.out.print(j + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new OneSeven();
	}
}