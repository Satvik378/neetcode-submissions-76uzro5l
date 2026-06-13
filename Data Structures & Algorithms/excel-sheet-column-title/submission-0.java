class Solution {
    public String convertToTitle(int columnNumber) {

        StringBuilder builder = new StringBuilder();
        
        while(columnNumber > 0){
            int temp = (columnNumber-1)%26;
            builder.append((char)('A' + temp));
            columnNumber = (columnNumber-1)/26; 
        }

        return builder.reverse().toString();
    }
}