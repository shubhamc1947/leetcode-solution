class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // edges
        int e = values.length;
        // equations (edges), values 
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < e; i++) {
            String su = equations.get(i).get(0);
            String sv = equations.get(i).get(1);
            double wt = values[i];
            // su->sv
            graph.putIfAbsent(su, new HashMap<>());
            graph.get(su).put(sv, wt);
            // sv->su
            graph.putIfAbsent(sv, new HashMap<>());
            graph.get(sv).put(su, 1/wt);
        }
        
        // int n
        int n = queries.size();
        HashSet<String> vis;
        double[] result = new double[n];

        for (int i = 0; i < n; i++) {
            vis = new HashSet<>();
            String su = queries.get(i).get(0);
            String sv = queries.get(i).get(1);
            if(graph.containsKey(su)&&graph.containsKey(sv)) {
                result[i] = dfsm(su, sv, vis, graph);
            } else {
                result[i] = -1;
            }
        }

        return result;
    }
    public double dfsm(String src, String dest, HashSet<String> vis, HashMap<String, HashMap<String, Double>> graph) {
        if (graph.get(src).containsKey(dest)) return graph.get(src).get(dest);

        vis.add(src);
        for (String next : graph.get(src).keySet()) {
            if (!vis.contains(next)) {
                double res = dfsm(next, dest, vis, graph);
                if (res!=-1) {
                    return res*graph.get(src).get(next);            
                }
            }
        }

        return -1.0;
    }
}