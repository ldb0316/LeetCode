class Solution {
    public int[] getConcatenation(int[] nums) {
        
        int length = nums.length;
        
        int[] result = new int[length*2];
        
        for(int i = 0 ; i < length ; i++) {
            result[i] = nums[i];
        }
        
        for(int i = length ; i < length*2 ; i++) {
            result[i] = nums[i-length];
        }
        
        return result;
    }
}