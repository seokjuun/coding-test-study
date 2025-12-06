import java.util.*;

class Solution {
    
    static class Node {
        int x, y, num;
        Node left, right;

        Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    List<Integer> pre = new ArrayList<>();
    List<Integer> post = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        
        
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];

        // 노드 배열, 정렬
        for (int i = 0; i < n; i++) {
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            nodes[i] = new Node(x, y, i+1);
        }

        Arrays.sort(nodes, (a,b) -> {
            if (a.y == b.y) {
                return a.x - b.x; // x오름차순
            } else {
                return b.y - a.y; // y내림차순
            }
        });

        // 트리 완성시키기
        Node root = nodes[0];
        
        for(int i =1; i<n; i++){
            Node cur = root;
            Node child = nodes[i];
            
            while(true){
                if(child.x < cur.x){ // 왼쪽
                    if(cur.left == null){ // 비면
                        cur.left = child;
                        break;
                    } else {
                        cur = cur.left;
                    }
                } else { // 오른쪽
                    if(cur.right == null){ // 비면
                        cur.right = child;
                        break;
                    } else {
                        cur = cur.right;
                    }
                }
            }
        }
        
        
        
        preorder(root);
        postorder(root);
        
        int[][] answer = new int[2][n];
        for(int i=0; i<n; i++){
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }
        
        return answer;
    }
    
    private void preorder(Node node) {
        if (node == null) return;
        pre.add(node.num); // 루트
        preorder(node.left); // 왼쪽
        preorder(node.right); // 오른쪽
    }

    private void postorder(Node node) {
        if (node == null) return;
        postorder(node.left); // 왼쪽
        postorder(node.right); // 오른쪽
        post.add(node.num); // 루트
    }
}