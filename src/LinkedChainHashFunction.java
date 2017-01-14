/**
 * Created by Pierre on 14/01/2017.
 */
public class LinkedChainHashFunction implements HashFunction {
    int m;

    public LinkedChainHashFunction(int m) {
        this.m = m;
    }

    @Override
    public int hash(int i) {
        return i % this.m;
    }
}
