class Solution {
    public boolean isCircularSentence(String sentence) {
        // // for(int i=0;i<sentence.length();i++){
        // //     char a = charAt(i);
        // //     break;
        // // }
        // // for(int j=sentence.length()-1;j>=0;j--){
        // //     char b = charAt(j);
        // //     break;
        // // }
        // // return a==b ? true : false;
        // int len = sentence.length();
        // String[] str = new String[len];
        // for(int i=0;i<sentence.length();i++){
        //     str[i] = charAt(i);
        // }
        // // int first=str[0];
        // // int last = str[len-1];
        // return str[0]==str[len-1] ? true : false;
        // // for(int j=0;j<str.length;j++){
        // //     if
        // // }
        String[] words = sentence.split(" ");
        for(int i=0;i<words.length-1;i++){
            char a = words[i].charAt(words[i].length()-1);
            char b = words[i+1].charAt(0);
            if(a!=b) return false;
        }
        char c = words[words.length-1].charAt(words[words.length-1].length()-1);
        char d = words[0].charAt(0);
        if(c!=d) return false;
        
        // if(a!=b) return false;
        return true;

    }
}
