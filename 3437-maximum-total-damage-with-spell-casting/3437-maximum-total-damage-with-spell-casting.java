class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> damageFrequency = new HashMap<>();
        for (int damage : power) {
            damageFrequency.put(damage, damageFrequency.getOrDefault(damage, 0L) + 1);
        }

        List<Integer> uniqueDamages = new ArrayList<>(damageFrequency.keySet());
        Collections.sort(uniqueDamages);

        int totalUniqueDamages = uniqueDamages.size();
        long[] maxDamageDP = new long[totalUniqueDamages];

        maxDamageDP[0] = uniqueDamages.get(0) * damageFrequency.get(uniqueDamages.get(0));

        for (int i = 1; i < totalUniqueDamages; i++) {
            int currentDamageValue = uniqueDamages.get(i);
            long currentDamageTotal = currentDamageValue * damageFrequency.get(currentDamageValue);

            maxDamageDP[i] = maxDamageDP[i - 1];

            int previousIndex = i - 1;
            while (previousIndex >= 0 && 
                   (uniqueDamages.get(previousIndex) == currentDamageValue - 1 || 
                    uniqueDamages.get(previousIndex) == currentDamageValue - 2 || 
                    uniqueDamages.get(previousIndex) == currentDamageValue + 1 || 
                    uniqueDamages.get(previousIndex) == currentDamageValue + 2)) {
                previousIndex--;
            }

            if (previousIndex >= 0) {
                maxDamageDP[i] = Math.max(maxDamageDP[i], maxDamageDP[previousIndex] + currentDamageTotal);
            } else {
                maxDamageDP[i] = Math.max(maxDamageDP[i], currentDamageTotal);
            }
        }

        return maxDamageDP[totalUniqueDamages - 1];
    }
}