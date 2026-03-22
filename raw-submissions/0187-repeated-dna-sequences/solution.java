class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= n - 10; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < i + 10; j++) {
                sb.append(s.charAt(j));
            }
            list.add(sb.toString());
        }
        Collections.sort(list);
        List<String> res = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                if (res.isEmpty() || !res.get(res.size() - 1).equals(list.get(i))) {
                    res.add(list.get(i));
                }
            }
        }
        return res;
    }
}
