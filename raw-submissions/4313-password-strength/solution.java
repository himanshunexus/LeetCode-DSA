class Solution {
    public int passwordStrength(String password) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        boolean[] digit = new boolean[10];
        boolean[] special = new boolean[4];
        String sp = "!@#$";
        for(char c : password.toCharArray()){
            if(c >= 'a' && c <= 'z') lower[c - 'a'] = true;
            else if(c >= 'A' && c <= 'Z') upper[c - 'A'] = true;
            else if(c >= '0' && c <= '9') digit[c - '0'] = true;
            else{
                int idx = sp.indexOf(c);
                if(idx != -1) special[idx] = true;
            }
        }
        int score = 0;
        for(boolean b : lower) if(b) score += 1;
        for(boolean b : upper) if(b) score += 2;
        for(boolean b : digit) if(b) score += 3;
        for(boolean b : special) if(b) score += 5;
        return score;
    }
}
