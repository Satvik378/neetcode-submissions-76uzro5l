class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";

        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        int[] res = new int[num1.length() + num2.length()];

        for(int i = 0; i<num1.length(); i++){
            for(int j = 0; j<num2.length(); j++){

                int mul = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                //multiply

                //mul should be placed at which index
                res[i+j] += mul;

                // what if carry comes.
                res[i+j+1] += res[i+j]/10;

                res[i+j] = res[i+j]%10;
            }
        }

        StringBuilder ans = new StringBuilder();

        int i = res.length - 1;

        // skip leading zeros only
        while(i > 0 && res[i] == 0){
            i--;
        }

        for(; i >= 0; i--){
            ans.append(res[i]);
        }

        return ans.toString();
    }
}
