/*
Problem 1.6 - Cracking the Coding Interview

Given an image represented by an NxN matrix, where each pixel is 4 bytes,
write a method to rotate the image 90 degrees.
Can you do this in place?

NOTE: O(n^2) is best we can do, as any solution must touch all n^2 elements.

This implementation simply iterates the array in row-major order, mapping
to a new array in column-major order (from last column to first, in this case)

This is equivalent to the solution in the book, but that solution uses "layers", 
outermost in or innermost out.

Sample output:

n: 5
5

Original array
01234
01234
01234
01234
01234

Rotated array
00000
11111
22222
33333
44444

James Earle - August 30, 2015
*/
import java.io.*;

public class OneSix {

	int[][] image;

	public OneSix(int n) {
		image = new int[n][n];
		System.out.println(n);

		//Places values in each cell so we can see the changes after rotation.
		init(image);
		print(image, "\nOriginal array");

		image = rotate(image);
		print(image, "\nRotated array");

	}

	public void init(int[][] image) {
		for(int i=0;i<image.length;i++) {
			for(int j=0;j<image[i].length;j++) {
				image[i][j] = j;
			}
		}
	}

	public void print(int[][] image, String msg) {
		System.out.println(msg);
		for(int i=0;i<image.length;i++) {
			for(int j=0;j<image[i].length;j++) {
				System.out.print(image[i][j]);
			}
			System.out.println();
		}
	}

	/*
		[0][0] --> [0][length-1]
		[0][1] --> [1][length-1]
		etc.
	*/
	public int[][] rotate(int[][] image) {
		int[][] result = new int[image.length][image.length];
		int col = image.length-1;

		for(int i=0;i<image.length;i++) {
			for(int j=0;j<image[i].length;j++) {
				result[j][col] = image[i][j];
			}
			col--;
		}
		return result;
	}

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.print("n: ");
			int n = Integer.valueOf(reader.readLine());
			new OneSix(n);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}