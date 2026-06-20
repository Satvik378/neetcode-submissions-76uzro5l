class Solution {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;

        int carry = 0;
        StringBuilder res = new StringBuilder();

        while(i >=0 || j>=0|| carry > 0){

            int digit1 = (i>=0) ?(int)(a.charAt(i) - '0') : 0;
            int digit2 = (j >=0) ? (int)(b.charAt(j) - '0') : 0;

            int sum = digit1 + digit2 + carry;
            res.append(sum%2);

            carry = sum/2;

            i--;
            j--;
        }

        return res.reverse().toString();

    }
}