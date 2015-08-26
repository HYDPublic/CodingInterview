public class PatternMatching {

	public int findMin(int[] arr) {
		//Base case
		return binarySearch(arr, 0, arr.length-1);
	}

	public int binarySearch(int[] arr, int left, int right) {
		//Empty array
		if(right < left) return -1;

		//One element
		if(right == left) return arr[left];

		int mid = (int)Math.floor((left + right)/2);

		//Special case like arr5, when min is right of mid.
		if(mid+1 > left && arr[mid+1] < arr[mid]) return arr[mid+1];

		//Mid is the minimum point
		if(mid > left && arr[mid] < arr[mid-1]) return arr[mid];

		//Decide left or right subsections otherwise
		if(arr[mid] > arr[right]) {
			return binarySearch(arr, mid+1, right);
		} else {
			return binarySearch(arr, left, mid-1);
		}

	}

	public static void main(String[] args) {

		int[] arr1 = {6, 7, 1, 2, 3, 4, 5};
		int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
		int[] arr3 = {2, 3, 4, 5, 6, 7, 1};
		int[] arr4 = {5, 6, 7, 1, 2, 3, 4};

		// Special cases like this require checking mid+1 for solution
		int[] arr5 = {3, 4, 5, 1, 2};

		System.out.println("Min value in array: " + new PatternMatching().findMin(arr1));

	}

}