class Solution {
    public String sortVowels(String s) {
        Map<Character,Integer> freq = new HashMap<>();
        Map<Character,Integer> first = new HashMap<>();
        String vowel = "aeiou";
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(vowel.indexOf(c) != -1){
                freq.put(c,freq.getOrDefault(c,0)+1);
                if(!first.containsKey(c)){
                    first.put(c,i);
                }
            }
        }
        List<Character> list = new ArrayList<>(freq.keySet());
        list.sort((a,b)->{
            if(!freq.get(a).equals(freq.get(b)))
                return freq.get(b) - freq.get(a);
            return first.get(a) - first.get(b);
        });
        StringBuilder sb = new StringBuilder();
        for(char c : list){
            int count = freq.get(c);
            while(count-- > 0){
                sb.append(c);
            }
        }
            char[] arr = s.toCharArray();
            int k = 0;
            for(int i = 0; i < arr.length; i++){
                if(vowel.indexOf(arr[i]) != -1)
                    arr[i] = sb.charAt(k++);
            }
        return new String(arr);
    }
}
