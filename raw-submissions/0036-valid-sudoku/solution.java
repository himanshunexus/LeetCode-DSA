class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length , m = board[0].length;
        for(int r = 0; r < n; r++){
            for(int c = 0; c < m; c++){
                HashSet<Character> rSet = new HashSet<>();
                for(int i = 0; i < n; i++){
                    if(rSet.contains(board[i][c])) return false;
                    if(board[i][c] !='.'){
                        rSet.add(board[i][c]);
                    }
                }
                HashSet<Character> cSet = new HashSet<>();
                for(int z = 0; z < n; z++){
                    if(cSet.contains(board[r][z])) return false;
                    if(board[r][z] !='.'){
                        cSet.add(board[r][z]);
                    }
                }

            }
            for(int k = 0; k < 9; k += 3){
                for(int z = 0; z < 9; z += 3){
                    HashSet<Character> boxSet = new HashSet<>();
                    for(int i = 0; i < 3; i++){
                        for (int v = 0; v < 3; v++) {
                            char val = board[k + i][z + v];
                            if (val != '.') {
                                if (boxSet.contains(val)) return false;
                                boxSet.add(val);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}

// 3 * 3 check 1 to 9 row and 1 to 9 col 
