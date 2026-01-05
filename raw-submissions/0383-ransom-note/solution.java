class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ele : magazine.toCharArray()){
            map.put(ele,map.getOrDefault(ele,0)+1);
        }
        for(char var : ransomNote.toCharArray()){
            if(!map.containsKey(var)|| map.get(var) == 0)
                return false;
            map.put(var, map.get(var) - 1);
        }
        return true;
    }
}
