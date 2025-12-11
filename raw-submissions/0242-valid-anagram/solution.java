class Solution {
    public boolean isAnagram(String s, String t) {
    //     TreeMap<Character,Integer> map = new TreeMap<>();
    //     for(int i=0;i<s.length();i++){
    //         if(map.get(s.charAt(i))==null){
    //             map.put(s.charAt(i),1);
    //         }
    //         else{
    //             map.put(s.charAt(i),map.get(s.charAt(i))+1);
    //         }
    //     }
    //         TreeMap<Character,Integer> map1 = new TreeMap<>();
    //         for(int j=0;j<t.length();j++){
    //             if(map1.get(t.charAt(j))==null){
    //                 map1.put(t.charAt(j),1);
    //         }
    //             else{
    //                 map1.put(t.charAt(j),map1.get(t.charAt(j))+1);
    //         }
           
    //     }
    
    //    if (map.equals(map1)) {
    //         return true;
    //     } else {
    //         return false;
        
    //     }
    if(s.length()!=t.length()){
        return false;
    }
    char[] sArray=s.toCharArray();
    char[] tArray=t.toCharArray();
    Arrays.sort(sArray);
    Arrays.sort(tArray);

    if (Arrays.equals(sArray, tArray)) {
        return true;
    } else {
        return false;
}
            
    }

}
