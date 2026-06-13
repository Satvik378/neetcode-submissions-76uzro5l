class CountSquares {
    
    HashMap<List<Integer>, Integer> hmap;
    
    public CountSquares() {
        hmap = new HashMap<>();
    }
    
    public void add(int[] point) {
        List<Integer> list = Arrays.asList(point[0], point[1]);
        hmap.put(list, hmap.getOrDefault(list, 0)+1);
    }
    
    public int count(int[] point) {
        int res = 0;

        int px = point[0], py = point[1];

        for(List<Integer> list : hmap.keySet()){
            int x = list.get(0), y = list.get(1);
            //find diagonal element.
            if(px==x || py == y || Math.abs(px-x) != Math.abs(py-y)){
                continue;
            }

            res += hmap.get(list) * 
                hmap.getOrDefault(Arrays.asList(px, y), 0) * 
                hmap.getOrDefault(Arrays.asList(x, py), 0);
        }

        return res;
    }
}
