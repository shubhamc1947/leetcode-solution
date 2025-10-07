class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        Map<Integer, Integer> lake = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                result[i] = 1;
            } else {
                result[i] = -1;
                if (lake.containsKey(rains[i])) {
                    Integer dryDay = dryDays.ceiling(lake.get(rains[i]));
                    if (dryDay == null) return new int[0];
                    result[dryDay] = rains[i];
                    dryDays.remove(dryDay);
                }
                lake.put(rains[i], i);
            }
        }
        return result;
    }
}