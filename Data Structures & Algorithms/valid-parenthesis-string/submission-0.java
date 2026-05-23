class Solution {
    public boolean checkValidString(String s) {

        Deque<Integer> openParaStack = new LinkedList<>();
        Deque<Integer> starStack = new LinkedList<>();

        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                openParaStack.push(i);
            }
            else if(s.charAt(i) == '*'){
                starStack.push(i);
            }
            else{
                if(!openParaStack.isEmpty()){
                    openParaStack.poll();
                }
                else if(!starStack.isEmpty()){
                    //act as '('
                    starStack.poll();
                }
                else{
                    return false;
                }
            }
        }

        while(!openParaStack.isEmpty() && !starStack.isEmpty()){
            if(starStack.poll() < openParaStack.poll()){
                return false;
            }
        }

        return openParaStack.isEmpty();
    }
}
