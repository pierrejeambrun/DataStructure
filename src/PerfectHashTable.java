import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Pierre on 14/01/2017.
 */
public class PerfectHashTable {

    public static void main(String[] args) {
        int[][] inputArray = {{1,7},{56,42},{89,44},{76,45},{34,43},{65,48}, {47,72}};
        int m = 10;
        LinkedChainHashFunction linkedChainHashFunction = new LinkedChainHashFunction(m);
         ArrayList<Couple> hashMap = new ArrayList<>();
        for(int i = 0; i <= m;i++){
            hashMap.add(new Couple(i));
        }
        for(int i = 0; i <= inputArray.length - 1 ; i++){
            hashMap.get(linkedChainHashFunction.hash(inputArray[i][0])).arrayList.add(inputArray[i]);
        }
        System.out.println(hashMap.get(6).arrayList.get(0)[1]);
        System.out.println(PerfectHashFunction.generatePrimeNumber(10,100));

//        PerfectHashFunction perfectHashFunction1 = new PerfectHashFunction(m);
//        perfectHashFunction1.generateParameters();

    }
}
