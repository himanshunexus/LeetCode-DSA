class Solution {
    public String makeLargestSpecial(String s) {
        if (s.length() <= 2) return s;
        List<String> list = new ArrayList<>();
        int cnt = 0; 
        int start = 0; 

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') cnt++;
            else cnt--;
            if (cnt == 0) {
                String sub = "1" + makeLargestSpecial(s.substring(start + 1, i)) + "0";
                list.add(sub);
                start = i + 1;
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
}
