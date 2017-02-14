package CodeInterview;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ModerateMasterMind {
    private List<Recursion.Color> solution;

    public static void main(String[] args){
        ModerateMasterMind moderateMasterMind = new ModerateMasterMind(Arrays.asList(
                Recursion.Color.Black,
                Recursion.Color.Yellow,
                Recursion.Color.Blue,
                Recursion.Color.Green));
        List<Recursion.Color> myGuess = Arrays.asList(
                Recursion.Color.Yellow,
                Recursion.Color.Black,
                Recursion.Color.Blue,
                Recursion.Color.Green);
        moderateMasterMind.takeAGuess(myGuess);
    }

    public ModerateMasterMind(List<Recursion.Color> solution) {
        this.solution = solution;
    }

    public void takeAGuess(List<Recursion.Color> yourGuess) {
        if(yourGuess.size() != solution.size())
            throw new IllegalStateException("Your guess has the right number of item");
        int hit = 0;
        int pseudoHit = 0;
        Iterator<Recursion.Color> yourGuessIterator = yourGuess.iterator();
        Iterator<Recursion.Color> solutionIterator = solution.iterator();
        while(yourGuessIterator.hasNext()){
            Recursion.Color currentGuess = yourGuessIterator.next();
            Recursion.Color currentSolution = solutionIterator.next();
            if (solution.contains(currentGuess))
                pseudoHit++;
            if(currentGuess == currentSolution)
                hit++;
        }
        System.out.println("You got " + hit + " hit and " + pseudoHit + " pseudo hit");
    }
}