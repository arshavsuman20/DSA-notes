class Solution {
    public int lengthOfLIS(int[] arr) {
        int n=arr.length;
		ArrayList<Integer> temp=new ArrayList<>();
		temp.add(arr[0]);
		for(int i = 1; i<n ; i++){
			if(arr[i] > temp.get(temp.size()-1)){
				temp.add(arr[i]);
			}
			else{
				int ind = Collections.binarySearch(temp, arr[i]);
				if(ind<0) ind = -(ind+1);
				temp.set(ind, arr[i]);
			}
		}
		return temp.size();
	}
}