class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> upper = new HashSet<>();
        HashSet<Character> lower = new HashSet<>();
        for(char c : word.toCharArray()){
            if(Character.isLowerCase(c)) lower.add(c);
            else upper.add(c);
        }
        int count = 0;
        for(char a : lower){
            if(upper.contains(Character.toUpperCase(a))) count++;
        }
        return count;
    }
}
