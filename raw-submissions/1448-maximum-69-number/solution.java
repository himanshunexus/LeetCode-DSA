class Solution {
    public int maximum69Number(int num) {
        String st = String.valueOf(num);
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i)=='6') {
                st = st.substring(0, i) + '9' + st.substring(i + 1);
                break;
            }
        }
        return Integer.parseInt(st);
    }
}
