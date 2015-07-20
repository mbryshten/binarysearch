package mbryshten.binarysearch;

public class NoIfBinarySearch implements BinarySearch {

	@Override
	public int binSearch(int[] arr, int val) {
		
		if(arr == null || arr.length == 0) {
			return NOT_FOUND;
		}
		
		int low = 0;
		int high = arr.length - 1;
		int mid = (low+high)/2;			
		
		int midValue = arr[mid];
		
		while(low <= high && midValue != val) {
			
			int diff = val - midValue;
			
			diff = diff/Math.abs(diff);
			
			low = (mid + mid*diff)/2 + (1+diff)/2 + (low + low*(-diff))/2;
			
			diff = diff*-1;
			
			high = (mid + mid*diff)/2 - (1+diff)/2 + (high + high*(-diff))/2;			
			
			mid = (low+high)/2;
			
			midValue = arr[mid];						
		}
		
		// res would be less than 0 if we did not find the value
		int res = high - low;
		
		// if res == 1 then we found the value
		// if res == -1 then we did not find the value and need to return -1
		try
		{
			res = res/Math.abs(res);
		} catch(ArithmeticException e) {
			
			// Special case if dividing by zero - we treat it as we found the value
			res = 1;
		}
		
		mid = (mid + mid*res)/2 - (1 - res)/2;
				
		return mid;
	}
}
