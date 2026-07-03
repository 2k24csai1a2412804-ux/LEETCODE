//  class Solution {
//     public boolean containsDuplicate(int[] nums) {
//        int  n=nums.length;

//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                if(nums[i] == nums[j]){
//                  return true;
//                 }
//             }
           
//         }
//          return false;
//     }
// }

class Solution {
    public boolean containsDuplicate(int[] nums) {

        int n = nums.length;

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {

            int num = nums[i];

            if(set.contains(num)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }
}