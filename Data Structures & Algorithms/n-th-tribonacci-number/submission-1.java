class Solution {
    HashMap<Integer, Integer> cache = new HashMap<>();
    public int tribonacci(int n) {
        if(n<=2){
            return n==0 ? 0 : 1;
        }
        if(cache.containsKey(n)) return cache.get(n);

        cache.put(n, tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3));

        return cache.get(n);
    }
}