class Solution {
    public int findNthDigit(int n) {
        if (n <= 9) return n;
        if (n <= 190) {
            int num = n - 10;
            int rem = num % 2;
            int quo = num / 2;
            String s = String.valueOf(10 + quo);
            return s.charAt(rem) - '0';
        }
        if (n <= 2890) {
            int num = n - 190;
            int rem = num % 3;
            int quo = num / 3;
            String s = String.valueOf(100 + quo);
            return s.charAt(rem) - '0';
        }
        if (n <= 38890) {
            int num = n - 2890;
            int rem = num % 4;
            int quo = num / 4;
            String s = String.valueOf(1000 + quo);
            return s.charAt(rem) - '0';
        }
        if (n <= 488890) {
            int num = n - 38890;
            int rem = num % 5;
            int quo = num / 5;
            String s = String.valueOf(10000 + quo);
            return s.charAt(rem) - '0';
        }
        if (n <= 5888890) {
            int num = n - 488890;
            int rem = num % 6;
            int quo = num / 6;
            String s = String.valueOf(100000 + quo);
            return s.charAt(rem) - '0';
        }
        if (n <= 68888890) {
            int num = n - 5888890;
            int rem = num % 7;
            int quo = num / 7;
            String s = String.valueOf(1000000 + quo);
            return s.charAt(rem) - '0';
        }
        if (n <= 788888890) {
            int num = n - 68888890;
            int rem = num % 8;
            int quo = num / 8;
            String s = String.valueOf(10000000 + quo);
            return s.charAt(rem) - '0';
        }
        long num = (long) n - 788888890L;
        long rem = num % 9L;
        long quo = num / 9L;
        String s = String.valueOf(100000000L + quo);
        return s.charAt((int) rem) - '0';
    }
}
