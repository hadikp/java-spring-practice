package drill;

import java.util.Arrays;
import java.util.Comparator;

public class Palindrome {

    public boolean palidrome(String p) {
        String[] pSplit = p.split("");
       StringBuilder sb = new StringBuilder();
        String preverse ="";
        for(int i = pSplit.length-1; i >= 0 ; i--) {
            sb.append(pSplit[i].trim());
            //preverse += pSplit[i];
        }
        if (p.equals(sb.toString())) {
            return true;
        }
        return false;
    }
}
