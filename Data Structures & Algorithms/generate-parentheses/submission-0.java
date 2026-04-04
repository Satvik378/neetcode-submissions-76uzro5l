class Solution {
    public List<String> generateParenthesis(int n) {
        
        StringBuilder stack = new StringBuilder();
        List<String> res = new ArrayList<>();

        dfs(stack, res, n, 0, 0);
        return res;
    }

    private void dfs(StringBuilder stack, List<String> res,
                    int n, int openCount, int closedCount){

        if(openCount == n && openCount == closedCount){
            res.add(stack.toString());
            return;
        }

        if(openCount < n){
            stack.append("(");
            dfs(stack, res, n, openCount+1, closedCount);
            stack.deleteCharAt(stack.length()-1);
        }

        if(closedCount < openCount){
            stack.append(")");
            dfs(stack, res, n, openCount, closedCount+1);
            stack.deleteCharAt(stack.length()-1);
        }
    }
}
