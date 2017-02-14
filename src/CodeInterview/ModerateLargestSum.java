package CodeInterview;

public class ModerateLargestSum {
    public static int findLargestSum(int[] myArray){
        int maxSum = 0;
        int currentSum = 0;
        for(int i = 0; i<myArray.length ; i++){
            currentSum += myArray[i];
            if(currentSum > maxSum)
                maxSum = currentSum;
            if(currentSum <= 0){
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
