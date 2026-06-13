class Solution {
    public String gcdOfStrings(String str1, String str2) {
      //eucledian algo.
      //gcd(a,b) = gcd(b, a%b);

      if(!(str1+str2).equals(str2+str1))  return "";

      int strLen1 = str1.length();
      int strLen2 = str2.length();
      int temp = gcd(strLen1, strLen2);

        return str1.substring(0, temp);
    }

    private int gcd(int a, int b){

        while(b > 0){
            int temp = a%b;
            a = b;
            b = temp;
        }

        return a;
    }
}