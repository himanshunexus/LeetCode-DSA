class Solution {
    public boolean canBeEqual(String s1, String s2) {
        char[] sc = s2.toCharArray();
        if (s1.charAt(0) != sc[0]) {
            char tmp = sc[0];
            sc[0] = sc[2];
            sc[2] = tmp;
        }
        if (s1.charAt(1) != sc[1]) {
            char tmp = sc[1];
            sc[1] = sc[3];
            sc[3] = tmp;
        }
        return s1.equals(new String(sc));
    }
}
