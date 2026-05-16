class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for(int bill : bills){

            if(bill == 5){
                five++;
            }
            else if(bill == 10){
                if(five == 0) return false;
                five--;
                ten++;
            }
            else{
                //we have to do it optimally
                //therefore we try to return 
                //10 and 5 or 5, 5, 5
                //greedy here
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                }
                else if(five >= 3){
                    five = five-3;
                }
                else{
                    return false;
                }
            }
        }

        return true;
    }
}