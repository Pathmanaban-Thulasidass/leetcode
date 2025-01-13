class MyLinkedList {

    ListNode head = null;
    ListNode tail = null;
    int noOfEle = 0;

    public MyLinkedList() {
        // do nothing
    }

    public int get(int index) {
        if (index < 0 || index >= noOfEle) {
            return -1;
        }

        int curIndex = 0;
        ListNode temp = head;
        while (temp != null) {
            if (curIndex == index) {
                return temp.val;
            }
            curIndex++;
            temp = temp.next;
        }
        return -1;
    }

    public void addAtHead(int val) {
        ListNode temp = new ListNode(val);
        temp.next = head;
        if (head == null) {
            tail = temp;
        }
        head = temp;

        noOfEle++;
    }

    public void addAtTail(int val) {
        ListNode temp = new ListNode(val);
        if (tail == null) {
            head = temp;
        } else {
            tail.next = temp;
        }
        tail = temp;

        noOfEle++;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        } else if (index == noOfEle) {
            addAtTail(val);
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode temp = head;
        ListNode prev = null;
        int curIndex = 0;
        while (temp != null) {
            if (curIndex == index) {
                break;
            }
            prev = temp;
            temp = temp.next;
            curIndex++;
        }
        if (prev != null) {
            prev.next = newNode;
        }
        newNode.next = temp;
        noOfEle++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= noOfEle) {
            return; 
        }
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null; // Handle single-node list
            }
            noOfEle--;
            return;
        }
        int curIndex = 0;
        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            if (curIndex == index) {
                break;
            }
            curIndex++;
            prev = temp;
            temp = temp.next;
        }
        if (prev != null && temp != null) {
            prev.next = temp.next;
            if (temp.next == null) {
                tail = prev; // Update tail if needed
            }
        }
        noOfEle--;
    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */