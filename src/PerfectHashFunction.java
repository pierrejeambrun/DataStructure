import java.util.ArrayList;

/**
 * Created by Pierre on 14/01/201
 */
public class PerfectHashFunction implements HashFunction {
    int a;
    int b;
    int p;
    int m;

    public PerfectHashFunction(int a, int b, int p, int m) {
        this.a = a;
        this.b = b;
        this.p = p;
        this.m = m;
    }

    public PerfectHashFunction(int m) {
        this.m = m;
    }

    public void generateParameters(){
        this.p=generatePrimeNumber(m+1, m+1000);
        this.a =(int)Math.floor(Math.random()*(this.p-2) ) + 1;
        this.b = (int)Math.floor(Math.random()*(this.p-1));
    }

    public static int generatePrimeNumber(int start, int end){
        int max = end;
        ArrayList<Integer> primeArray = new ArrayList<>();
        System.out.println("Generate Prime numbers between 1 and " + max);
        for (int i = start; i<=end; i++) {
            boolean isPrimeNumber =  true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }

            if (isPrimeNumber) {

                primeArray.add(i);
            }

        }
        return primeArray.get((int)Math.floor(Math.random()*primeArray.size()));
    }

    @Override
    public int hash(int i) {
        return ((this.a*i + this.p) % this.p)% this.m;
    }
}
