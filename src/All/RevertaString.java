package All;

import java.util.Arrays;

/**
 * Created by Pierre on 14/01/2017.
 */
public class RevertaString {
    public static void main(String[] args){
        String u = "trio";
        String a = "";
        for(int i = 0; i<= u.length()-1;i++){
            a = a.concat(String.valueOf(u.charAt(u.length() - 1 -i)));
        }

        System.out.println(a);
    }
}
