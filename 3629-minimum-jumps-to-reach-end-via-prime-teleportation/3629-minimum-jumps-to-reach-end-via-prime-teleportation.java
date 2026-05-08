class Solution {

    boolean[] isPrime;

    public int minJumps(int[] nums) {

        int n = nums.length;
        int maxi = nums[0];

        // Stores value -> list of indices
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int val = nums[i];

            map.putIfAbsent(val, new ArrayList<>());
            map.get(val).add(i);

            maxi = Math.max(maxi, val);
        }

        // Sieve array
        isPrime = new boolean[maxi + 1];
        sieve(maxi);

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];

        // Prevents processing same prime multiple times
        HashSet<Integer> usedPrime = new HashSet<>();

        q.offer(0);
        vis[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int idx = q.poll();

                // Destination reached
                if (idx == n - 1) {
                    return steps;
                }

                // Move left
                if (idx - 1 >= 0 && !vis[idx - 1]) {

                    vis[idx - 1] = true;
                    q.offer(idx - 1);
                }

                // Move right
                if (idx + 1 < n && !vis[idx + 1]) {

                    vis[idx + 1] = true;
                    q.offer(idx + 1);
                }

                int currentValue = nums[idx];

                // Skip if not prime or already processed
                if (isPrime[currentValue] || usedPrime.contains(currentValue)) {
                    continue;
                }

                // Visit all multiples
                for (int multiple = currentValue;
                     multiple <= maxi;
                     multiple += currentValue) {

                    if (!map.containsKey(multiple)) {
                        continue;
                    }

                    for (int nextIndex : map.get(multiple)) {

                        if (!vis[nextIndex]) {

                            vis[nextIndex] = true;
                            q.offer(nextIndex);
                        }
                    }
                }

                usedPrime.add(currentValue);
            }

            steps++;
        }

        return -1;
    }

    // Sieve of Eratosthenes
    private void sieve(int size) {

        if (size >= 0) {
            isPrime[0] = true;
        }

        if (size >= 1) {
            isPrime[1] = true;
        }

        for (int i = 2; i * i <= size; i++) {

            if (!isPrime[i]) {

                for (int j = i * i; j <= size; j += i) {

                    isPrime[j] = true;
                }
            }
        }
    }
}