class NumArray {
    SegmentTree segTree;
    int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        segTree = new SegmentTree(n);
        segTree.build(0, n - 1, 0, nums);
    }

    public void update(int index, int val) {
        segTree.update(0, n - 1, 0, index, val);
    }

    public int sumRange(int left, int right) {
        return segTree.sumRange(left, right, 0, n - 1, 0);
    }
}

class SegmentTree {
    int arr[];

    public SegmentTree(int n) {
        arr = new int[4 * n];
    }

    public void build(int start, int end, int index, int ele[]) {
        if (start == end) {
            arr[index] = ele[start];
            return;
        }
        int mid = (start + end) / 2;
        int leftChildIndex = (2 * index) + 1;
        int rightChildIndex = (2 * index) + 2;
        build(start, mid, leftChildIndex, ele); 
        build(mid + 1, end, rightChildIndex, ele);
        arr[index] = arr[leftChildIndex] + arr[rightChildIndex];
    }

    public void update(int start, int end, int index, int changeIndex, int val) {
        if (start == end) {
            if (changeIndex == start) {
                arr[index] = val;
            }
            return;
        }
        int mid = (start + end) / 2;
        int leftChildIndex = (2 * index) + 1;
        int rightChildIndex = (2 * index) + 2;

        if (changeIndex <= mid) {
            update(start, mid, leftChildIndex, changeIndex, val); 
        } else {
            update(mid + 1, end, rightChildIndex, changeIndex, val); 
        }
        arr[index] = arr[leftChildIndex] + arr[rightChildIndex]; 
    }

    public int sumRange(int needStart, int needEnd, int start, int end, int index) {
        if (needStart <= start && end <= needEnd) {
            return arr[index];
        }
        if (end < needStart || start > needEnd) {
            return 0;
        }
        int mid = (start + end) / 2;
        int leftChildIndex = (2 * index) + 1;
        int rightChildIndex = (2 * index) + 2;
        return sumRange(needStart, needEnd, start, mid, leftChildIndex) 
             + sumRange(needStart, needEnd, mid + 1, end, rightChildIndex);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
