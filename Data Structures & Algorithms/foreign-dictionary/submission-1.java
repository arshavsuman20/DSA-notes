class Solution {
    public String foreignDictionary(String[] words) {
        Set<Character> set = new HashSet<>();
        for (String w : words) {
            for (char c : w.toCharArray()) {
                set.add(c);
            }
        }
        //map characters to indices
        int k = set.size();
        Map<Character, Integer> map = new HashMap<>();
        int idx = 0;
        for (char c : set) {
            map.put(c, idx++);
        }
        //adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }
        //build graph
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            // invalid prefix case
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return "";
            }
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    int u = map.get(s1.charAt(j));
                    int v = map.get(s2.charAt(j));
                    adj.get(u).add(v);
                    break;
                }
            }
        }
        //topo sort
        List<Integer> topo = topoSort(k, adj);
        if (topo.size() < k) return "";
        //build answer
        char[] rev = new char[k];
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            rev[e.getValue()] = e.getKey();
        }
        StringBuilder ans = new StringBuilder();
        for (int it : topo) {
            ans.append(rev[it]);
        }
        return ans.toString();
    }

    List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int[] indeg = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) indeg[it]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indeg[i] == 0) q.add(i);
        }
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int it : adj.get(node)) {
                if (--indeg[it] == 0) q.add(it);
            }
        }
        return topo;
    }
}