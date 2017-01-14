import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Pierre on 14/01/2017.
 */
public class PerfectHashTable {

    public static void main(String[] args) {
        int[] inputArray = {3,4,5,6,4,7,8,9,9,9,7,7,8,9,7,8,7,9};
        int m = 10;
//        LinkedChainHashFunction linkedChainHashFunction = new LinkedChainHashFunction(m);
         ArrayList<Couple> hashMap = new ArrayList<>();
        for(int i = 0; i <= m;i++){
            hashMap.add(new Couple(i));
        }
//        for(int i = 0; i <= inputArray.length - 1 ; i++){
//            hashMap.get(linkedChainHashFunction.hash(i)).arrayList.add(inputArray[i]);
//        }
//        System.out.println(hashMap.get(9).arrayList.get(0));
//        System.out.println(hashMap.get(7).arrayList.get(0));
//        System.out.println(hashMap.get(7).arrayList.get(1));
//        System.out.println(hashMap.get(8).arrayList.get(0));
//        System.out.println(PerfectHashFunction.generatePrimeNumber(10,100));

        PerfectHashFunction perfectHashFunction1 = new PerfectHashFunction(m);
        perfectHashFunction1.generateParameters();

    }
}
