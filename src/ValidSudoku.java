public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        if (board.length != 9) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i].length != 9){
                return false;
            }
            boolean[] seen = new boolean[9];
            for (int j=0; j < board[i].length; j++) {
                char current = board[i][j];
                if (current >= '1' && current <= '9') {
                    int num = current - '1';
                    if (seen[num]) {
                        return false;
                    }
                    seen[num] = true;
                }
                else if (current != '.') {
                    return false;
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            boolean[] seenCol = new boolean[9];
            for (int i = 0; i < 9; i++) {
                char current = board[i][j];
                if (current >= '1' && current <= '9') {
                    int num = current - '1';
                    if (seenCol[num]) {
                        return false;
                    }
                    seenCol[num] = true;
                }
            }
        }

        for (int boxRow = 0; boxRow < 9; boxRow += 3) {
            for (int boxCol = 0; boxCol < 9; boxCol += 3) {
                boolean[] seenBox = new boolean[9];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char current = board[boxRow + i][boxCol + j];
                        if (current >= '1' && current <= '9') {
                            int num = current - '1';
                            if (seenBox[num]) {
                                return false;
                            }
                            seenBox[num] = true;
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }
}
