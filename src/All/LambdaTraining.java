package All;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by pierre on 04/02/17.
 */
public class LambdaTraining {
    public static void main(String[] args) {
        List<Integer> myArray = Arrays.asList(3, 4, 5);
        List<Integer> collect = myArray.stream().map(x -> 2 * x).collect(Collectors.toList());
        for (Integer a : collect) {
            System.out.println(a);
        }
        Function<Integer, Function<Integer, Integer>> myFunction = x -> y -> x * y;
        Function<Integer, Integer> apply = myFunction.apply(3);
        System.out.println(apply.apply(5));
        System.out.println(apply.apply(10));
        myFunction.apply(4).apply(6);
    }
}
