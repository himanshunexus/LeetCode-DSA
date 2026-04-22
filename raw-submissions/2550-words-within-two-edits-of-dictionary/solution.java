class Solution {
    private boolean isEqual(String queries , String dict){
        int count = 0;
        for(int i = 0 ; i < queries.length(); i++){
            if(queries.charAt(i)!= dict.charAt(i)){
                count++;
            }
        }
        return count <= 2;
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        for(String q : queries){
            for(String d : dictionary){
                if(isEqual(q,d)){
                    res.add(q);
                    break;
                }
            }
        }
        return res;
    }
}
