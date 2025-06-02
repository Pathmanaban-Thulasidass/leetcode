import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }
        int len = max - min + 1;
        SegTree segTree = new SegTree(len);
        for (int i = n - 1; i >= 0; i--) {
            int mappedIndex = nums[i] - min;
            int temp = segTree.find(0, mappedIndex - 1, 0, len, 0);
            ans.add(0,temp);
            segTree.update(mappedIndex, 0, len, 0);
        }
        return ans;
    }
}

class SegTree {
    int arr[];
    public SegTree(int n) {
        arr = new int[4 * n];
    }

    public void update(int ele, int start, int end, int index) {
        if (start == end) {
            arr[index]++;
            return;
        }
        int mid = (start + end) / 2;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        if (ele <= mid) {
            update(ele, start, mid, leftChildIndex);
        } else {
            update(ele, mid + 1, end, rightChildIndex);
        }
        arr[index] = arr[leftChildIndex] + arr[rightChildIndex];
    }

    public int find(int needStart, int needEnd, int start, int end, int index) {
        if (needStart <= start && end <= needEnd) {
            return arr[index];
        }
        else if (needEnd < start || end < needStart) {
            return 0; 
        }
        int mid = (start + end) / 2;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        return find(needStart, needEnd, start, mid, leftChildIndex) + find(needStart, needEnd, mid + 1, end, rightChildIndex);
    }
}
