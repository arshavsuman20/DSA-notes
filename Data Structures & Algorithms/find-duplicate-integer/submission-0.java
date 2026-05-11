class Solution {
    public int findDuplicate(int[] nums) {
        int slow=0, fast=0;
        while(true){
            slow=nums[slow]; //slow=slow.next;
            fast=nums[nums[fast]]; //fast=fast.next.next;
            if(slow==fast) break;
        }
        int sl=0;
        while(true){
            slow=nums[slow];
            sl=nums[sl];
            if(sl==slow) return slow;
        }
    }
}
