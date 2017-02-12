package All;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class CodeInterviewRecursion {
    private int choiceCount;

    public static void main(String[] args) {
        CodeInterviewRecursion codeInterviewRecursion = new CodeInterviewRecursion();
        ArrayList<Integer> forbiddenSquares = new ArrayList<>();
        forbiddenSquares.add(3);
        forbiddenSquares.add(5);
        System.out.println(codeInterviewRecursion.countPath(3, 1, 1, forbiddenSquares));
        ArrayList<Integer> myArray = new ArrayList<>(Arrays.asList(3, 2, 6));
        ArrayList<ArrayList<Integer>> subsets = codeInterviewRecursion.getSubsets(myArray, 0);
        System.out.println(subsets.size());
        printPar(8);
        Color[][] image = new Color[][]{{Color.Black, Color.Yellow}, {Color.Yellow, Color.Yellow}};
        colorNeighbours(image,1,1,Color.Blue);
        for (Color[] colors : image) {
            for (Color color : colors) {
                System.out.println(color);
            }
        }
        System.out.println(makeChange(15, 0, 0, 0));
    }

    public static int fibonacci(int n) {
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public int countPath(int squareDimensions, int currentBottom, int currentRight, ArrayList<Integer> offLimits) {

        if (offLimits == null || offLimits.isEmpty())
            offLimits = new ArrayList<>(-1);
        if (currentBottom == squareDimensions || currentRight == squareDimensions)
            return choiceCount++;

        if (!offLimits.contains((currentBottom) * squareDimensions + currentRight))
            countPath(squareDimensions, currentBottom + 1, currentRight, offLimits);
        if (!offLimits.contains((currentBottom - 1) * squareDimensions + currentRight + 1))
            countPath(squareDimensions, currentBottom, currentRight + 1, offLimits);
        return choiceCount;
    }

    public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if (set.size() == index) {
            allsubsets = new ArrayList<>();
            allsubsets.add(new ArrayList<>()); // Empty set
        } else {
            allsubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<>();
            for (ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<>();
                newsubset.addAll(subset); //
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }

    public static ArrayList<String> permutation(String myString) {
        ArrayList<String> permutations = new ArrayList<>();
        if (myString == null) {
            return null;
        } else if (myString.length() == 0) {
            permutations.add("");
            return permutations;
        }
        char first = myString.charAt(0);
        String remainder = myString.substring(1);
        ArrayList<String> words = permutation(remainder);
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                words.add(insertCharAt(word, first, i));
            }
        }
        return permutations;
    }

    public static String insertCharAt(String s, char a, int i) {
        return s.substring(0, i).concat(String.valueOf(a)).concat(s.substring(i));
    }

    public static void printPar(int l, int r, char[] str, int count) {
        if (r < 0 | l < 0) {
            return;
        }
        if (r == 0 && l == 0) {
            System.out.println(str);
        } else {
            if (l > 0) {
                str[count] = '(';
                printPar(l - 1, r, str, count + 1);
            }
            if (r > l) {
                str[count] = ')';
                printPar(l, r - 1, str, count + 1);
            }
        }
    }

    public static void printPar(int count) {
        char[] str = new char[2 * count];
        printPar(count, count, str, 0);
    }

    public static void colorNeighbours(Color[][] image, int pixelColumn, int pixelLine, Color colorToPaintIt, Color myPixelColor) {
        if (pixelColumn >= image.length || pixelColumn < 0 || pixelLine >= image[0].length || pixelLine < 0) {
            return;
        }
        if (image[pixelColumn][pixelLine] != myPixelColor)
            return;
        image[pixelColumn][pixelLine] = colorToPaintIt;
        colorNeighbours(image, pixelColumn + 1, pixelLine, colorToPaintIt, myPixelColor);
        colorNeighbours(image, pixelColumn - 1, pixelLine, colorToPaintIt, myPixelColor);
        colorNeighbours(image, pixelColumn, pixelLine + 1, colorToPaintIt, myPixelColor);
        colorNeighbours(image, pixelColumn, pixelLine - 1, colorToPaintIt, myPixelColor);
    }

    public static void colorNeighbours(Color[][] image, int pixelColumn, int pixelLine, Color colorToPaintIt) {
        Color myPixelColor = image[pixelColumn][pixelLine];
        colorNeighbours(image, pixelColumn, pixelLine, colorToPaintIt, myPixelColor);
    }

    public static int makeChange(int monney, int currentSum, int countofways, int denom) {
        Queue<Integer> tata = new ArrayDeque<>();
        if (currentSum > monney)
            return countofways;
        if (currentSum == monney) {
            countofways++;
            return countofways;
        }
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        if (denom <= 1)
            a = makeChange(monney, currentSum + 1, countofways, 1);
        if (denom <= 5)
            b = makeChange(monney, currentSum + 5, countofways, 5);
        if (denom <= 10)
            c = makeChange(monney, currentSum + 10, countofways, 10);
        if (denom <= 25)
            d = makeChange(monney, currentSum + 25, countofways, 25);

        return a + b + c + d;
    }

    public enum Color {
        Black, Red, White, Blue, Green, Yellow;
    }
}

