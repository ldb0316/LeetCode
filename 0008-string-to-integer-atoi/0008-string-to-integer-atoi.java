import java.math.BigInteger;
import java.util.regex.Pattern;

class Solution {
    
    public int myAtoi(String s) {
        s = s.trim();
        String[] strArr = s.split("");
        
        String resultStr = "";
        boolean start = false;
        int life = 2;
        for(int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            
            if(life == 0) {
                break;
            }
            if(str.matches("([+-])") && i < 2 && resultStr.equals("")) {
                if(life == 2) {
                    resultStr += str;        
                }
                life--;
                continue;
            }
            if(str.matches("([0-9])")) {
                if((start && str.matches("([0-9])")) ||(!start && str.matches("([0-9])"))) {
                    resultStr += str;    
                    
                    start = true;
                } else  {
                    break;
                }
            } else if(start && !str.matches("([0-9])")) {
                break;
            } else {
                break;
            }
        }
        int result = 0;
        if(!resultStr.equals("") && resultStr.matches("^(-|\\+*)(\\d+)$")) {
            //resultStr.replaceAll("([+])", "");
            
            BigInteger bi = new BigInteger(resultStr);
            BigInteger max = new BigInteger("2147483647");
            BigInteger min = new BigInteger("-2147483648");
        
            result = bi.min(max).max(min).intValue();
        }
        
        return result;
    }
    
}