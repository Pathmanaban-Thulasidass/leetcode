/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        Node temp = head;
        Node ansHead = null;
        Node ansTail = null;
        Map<Node,Integer> oldMap = new HashMap<>();
        Map<Integer,Node> newMap = new HashMap<>();
        int step = 1;
        while(temp != null){
            oldMap.put(temp,step);
            step++;
            temp = temp.next;
        }
        temp = head;
        step = 1;
        while(temp != null){
            Node node = new Node(temp.val);
            if(step == 1){
                ansHead = node;
            }
            else{ // ansTail != null
                ansTail.next = node;
            }
            newMap.put(step,node);
            ansTail = node;
            step++;
            temp = temp.next;
        }
        temp = head;
        step = 1;
        while(temp != null){
            if(temp.random != null){
                Node randomNode = temp.random;
                int oldIndex = oldMap.get(randomNode);
                Node newRandom = newMap.get(oldIndex);
                Node parent = newMap.get(step);
                parent.random = newRandom;
            }
            step++;
            temp = temp.next;
        }
        return ansHead;        
    }
}