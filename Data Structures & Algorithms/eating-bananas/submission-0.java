class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1; int high=findmax(piles);
        while(low<=high){
            int mid=(low+high)/2;
            int totalh=totalhours(piles,mid);
            if(totalh<=h){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    int findmax(int[] arr){
        int m=Integer.MIN_VALUE; int n=arr.length;
        for(int i=0;i<n;i++){m=Math.max(m,arr[i]);}
        return m;
    }
    int totalhours(int[] arr,int h){
        int totalh=0;int n=arr.length;
        for(int i=0;i<n;i++){
            totalh+=Math.ceil((double)arr[i] / (double) h);
        }
        return totalh;
    }
}