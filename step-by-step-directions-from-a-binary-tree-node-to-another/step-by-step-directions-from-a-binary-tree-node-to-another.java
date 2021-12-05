/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, List<int[]>> adjs = new HashMap<>();
    boolean[] visited = new boolean[100001];
    int[] dir = new int[]{0, 1, 2}; //U, L, R
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        dfs(root);
        
        return bfs(startValue, destValue);
    }
    
    private void dfs(TreeNode root) {
        if(root.left != null) {
            adjs.computeIfAbsent(root.val, x -> new ArrayList<>()).add(new int[]{root.left.val, dir[1]});
            adjs.computeIfAbsent(root.left.val, x -> new ArrayList<>()).add(new int[]{root.val, dir[0]});
            
            dfs(root.left);
        }
        
        if(root.right != null) {
            adjs.computeIfAbsent(root.val, x -> new ArrayList<>()).add(new int[]{root.right.val, dir[2]});
            adjs.computeIfAbsent(root.right.val, x -> new ArrayList<>()).add(new int[]{root.val, dir[0]});
                                                                                   
            dfs(root.right);
        }
    }
    
    private String bfs(int start, int dest) {
        Queue<Integer> q = new LinkedList<>();
        Queue<String> q1 = new LinkedList<>();
        
        q.offer(start);
        q1.offer("");
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            String d = q1.poll();
            visited[cur] = true;
            
            if(cur == dest) {
                return d;
            }
            
            List<int[]> adj = adjs.get(cur);
            
            if(adj != null) {
                for(int[] a : adj) {
                    if(!visited[a[0]]) {
                        q.offer(a[0]);
                        q1.offer(d + (a[1] == 0 ? "U" : a[1] == 1 ? "L" : "R"));
                    }
                       
                }
            }
        }
        
        return "";
    }
}