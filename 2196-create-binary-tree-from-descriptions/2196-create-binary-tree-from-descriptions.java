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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        int[] degree = new int[1_000_01];
        Set<Integer> parent = new HashSet<>();
        Set<Integer> child = new HashSet<>();
        int root = 0;

        for(int i=0; i < descriptions.length; i++) {
            parent.add(descriptions[i][0]);
            child.add(descriptions[i][1]);
        }
        
        for(Integer key: parent) {
            if(!child.contains(key)) {
                root = key;
            }
        }
        
        for(int i=0; i < descriptions.length; i++) {
            if(map.get(descriptions[i][0]) == null) {
                map.put(descriptions[i][0], new TreeNode(descriptions[i][0]));
            }
            
            if(map.get(descriptions[i][1]) == null) {
                map.put(descriptions[i][1], new TreeNode(descriptions[i][1]));
            }
            
            if(descriptions[i][2] == 1) {
                map.get(descriptions[i][0]).left = map.get(descriptions[i][1]);
            } else {
                map.get(descriptions[i][0]).right = map.get(descriptions[i][1]);
            }
        }
                
        return map.get(root);
    }
}