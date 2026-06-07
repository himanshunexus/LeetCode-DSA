class Solution {
    public List<String> generateValidStrings(int n, int k) {
        List<String> ans = new ArrayList<>();
        dfs(0 , n , k , 0, '0' , new StringBuilder() , ans);
        return ans;
    }
    private void dfs(int idx , int n , int k, int cost , char prev , StringBuilder sb , List<String> ans){
        if(cost > k) return;
        if(idx == n){
            ans.add(sb.toString());
            return;
        }
        sb.append('0');
        dfs(idx + 1 , n , k , cost , '0' , sb , ans);
        sb.deleteCharAt(sb.length() - 1);
        if(prev != '1'){
            sb.append('1');
            dfs(idx + 1 , n , k , cost + idx , '1' , sb , ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
