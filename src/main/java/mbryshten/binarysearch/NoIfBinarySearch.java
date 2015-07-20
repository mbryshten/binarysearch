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
		
		// Iterate until we find the value or until low range shifts to the right of high range
		while(low <= high && midValue != val) {
			
			int diff = val - midValue;
			
			/*
			 * Here comes some math logic to avoid use of any conditional statements.
			 * diff can be ither -1 or +1 after the following operation. 
			 * It can't be 0 since it is condition in the while loop.
			 */
			
			diff = diff/Math.abs(diff);
			
			// if diff==-1 that means we leave low value the same, and if it diff==1 we assign low value of (mid + 1)
			low = (mid + mid*diff)/2 + (1+diff)/2 + (low + low*(-diff))/2;
			
			// the, we change the sign of diff, which would be equivalent to performing ELSE block
			diff = diff*-1;
			
			// and do the same logic for high value as we did for low
			high = (mid + mid*diff)/2 - (1+diff)/2 + (high + high*(-diff))/2;			
			
			// change mid and miValue values before next iteration
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
		}catch(ArithmeticException e) {			
			// Special case if dividing by zero - we treat it as we found the value
			res = 1;
		}
		
		// Result of the following will be either position of the number (if res==1) or -1 if res==-1
		mid = (mid + mid*res)/2 - (1 - res)/2;
				
		return mid;
	}
}
