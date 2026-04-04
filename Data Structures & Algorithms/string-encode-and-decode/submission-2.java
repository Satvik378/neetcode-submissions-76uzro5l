class Solution {

    public String encode(List<String> strs) {

        //encode with length of string + # value

        StringBuilder builder = new StringBuilder();

        for(String i : strs){
            builder.append(i.length());
            builder.append('#');
            builder.append(i);
        }

        return builder.toString();

    }

    public List<String> decode(String str) {
        List<String> arrList = new ArrayList<>();
        int index = 0;
        
        while(index < str.length()){
            int j = index;
            
            while(str.charAt(j)!= '#'){
                j++;
            }

            int len = Integer.parseInt(str.substring(index, j));
            String st = str.substring(j+1, j+len+1);
            arrList.add(st);
            index = j+len+1;
        }
        

        return arrList;
    }
}
