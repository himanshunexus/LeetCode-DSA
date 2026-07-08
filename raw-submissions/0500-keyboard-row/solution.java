class Solution {
    public String[] findWords(String[] words) {

        Set<Character> r1 = new HashSet<>
        (Arrays.asList('q','w','e','r','t','y','u','i','o','p'));
        Set<Character> r2 = new HashSet<>
        (Arrays.asList('a','s','d','f','g','h','j','k','l'));
        Set<Character> r3 = new HashSet<>
        (Arrays.asList('z','x','c','v','b','n','m'));

        List<String> result = new ArrayList<>();
        for (String w : words) {
            String lower = w.toLowerCase();
            char firstChar = lower.charAt(0);
            Set<Character> targetSet;
            if (r1.contains(firstChar)) {
                targetSet = r1;
            } else if (r2.contains(firstChar)) {
                targetSet = r2;
            } else {
                targetSet = r3;
            }
            boolean isValid = true;
            for (char c : lower.toCharArray()) {
                if (!targetSet.contains(c)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                result.add(w);
            }
        }
        return result.toArray(new String[0]);
    }
}
