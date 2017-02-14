package CodeInterview;

import java.util.ArrayList;
import java.util.Arrays;

public class ModerateTicTacToeWinner {
    int[][] board;
    ArrayList<int[]> winningCombinations;


    public static void main(String[] args) {
        ModerateTicTacToeWinner moderateTicTacToeWinner = new ModerateTicTacToeWinner();
        moderateTicTacToeWinner.board[0][0] = 1;
        moderateTicTacToeWinner.board[1][1] = 1;
        moderateTicTacToeWinner.board[2][2] = 1;
        System.out.println(moderateTicTacToeWinner.hasWin(1));

    }

    public ModerateTicTacToeWinner() {
        board = new int[3][3];
        winningCombinations = new ArrayList<>(Arrays.asList(new int[]{1, 1, 1}, new int[]{2, 2, 2}));
    }

    // See if team one or two has won.
    public boolean hasWin(int team) {
        ArrayList<int[]> boardCombinations = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            boardCombinations.add(board[i]);
            int[] line = new int[board.length];
            for (int j = 0; j < board.length; j++) {
                line[j] = board[j][i];
            }
            boardCombinations.add(line);
        }
        int[] diag1 = new int[board.length];
        int[] diag2 = new int[board.length];
        for (int i = 0; i < board.length; i++) {
            diag1[i] = board[i][i];
            diag2[i] = board[i][board.length - 1 - i];
        }
        boardCombinations.addAll(Arrays.asList(diag1, diag2));
        for (int[] array : boardCombinations) {
            if (Arrays.equals(array, winningCombinations.get(team - 1)))
                return true;
        }
        return false;
    }

}
