package CodeInterview;

import java.util.ArrayList;
import java.util.List;

public class ModerateTrailingZero {
    public static void main(String[] args){
        System.out.println(numberOfTrailingZero(20));
    }

    public static int numberOfTrailingZero(int n){
      List<Boolean> twoDivisor =  new ArrayList<>();
      List<Boolean> fiveDivisor =  new ArrayList<>();
      for(int i = 0; i <= n; i++){
          int number = i;
          while(number % 2 == 0){
              if(number < 2)
                  break;
              number = number/2;
              twoDivisor.add(true);
          }
          number = i;
          while(number % 5 == 0){
              if(number < 5)
                  break;
              number = number/5;
              fiveDivisor.add(true);
          }
      }
      return Math.min(twoDivisor.size(), fiveDivisor.size());
    };
}
