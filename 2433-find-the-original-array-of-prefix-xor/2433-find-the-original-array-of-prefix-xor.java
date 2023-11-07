class Solution {
    public int[] findArray(int[] pref) {
        
        int length = pref.length;
        
        int before = 0;
        int[] result = new int[length];
        
        for(int i = 0 ; i < length ; i++) {
            if(i == 0) {
                before = pref[i];
                result[i] = before;
            } else {
                result[i] = pref[i]^before;
                before = pref[i];
            }
        }
        return result;
    }
}