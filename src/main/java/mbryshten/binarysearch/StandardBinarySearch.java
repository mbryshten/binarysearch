package mbryshten.binarysearch;

public class StandardBinarySearch implements BinarySearch {

	@Override
	public int binSearch(int[] arr, int val) {
		
		if(arr == null || arr.length == 0) {
			return NOT_FOUND;
		}
		
		int low = 0;
		int high = arr.length - 1;
		
		int mid = (low+high)/2;
		
		while(low <= high) {
		
			if(arr[mid] == val) {
				break;
			}
			
			if(arr[mid] < val) {				
				low = mid + 1;				
			} else if(arr[mid] > val) {
				high = mid - 1;
			}
			
			mid = (low+high)/2;
						
		}
		
		if(low > high) {
			return -1;
		}
				
		return mid;
	}
}
