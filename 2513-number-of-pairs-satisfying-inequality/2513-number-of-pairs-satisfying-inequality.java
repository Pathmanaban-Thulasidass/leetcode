class Solution {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int n = nums1.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            nums1[i] -= nums2[i];
        }
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums1) {
            minVal = Math.min(minVal,num);
            maxVal = Math.max(maxVal,num);
        }
        // The query value is nums1[i] - diff, so adjust the range accordingly
        int queryMin = minVal - diff;
        int queryMax = maxVal;
        int overallMin = Math.min(minVal, queryMin);
        int overallMax = Math.max(maxVal, queryMax);
        int size = overallMax - overallMin + 1;
        SegTree segTree = new SegTree(size);
        for (int i = n - 1; i >= 0; i--) {
            int current = nums1[i];
            int queryVal = current - diff;
            // Calculate the indices for the segment tree
            int queryIdx = queryVal - overallMin;
            int currentIdx = current - overallMin;
            if (queryIdx >= 0 && queryIdx < size) {
                ans += segTree.query(queryIdx, size - 1);
            }
            segTree.update(currentIdx);
        }

        return ans;
    }
}

class SegTree {
    int[] tree;
    int size;

    public SegTree(int size) {
        this.size = size;
        tree = new int[4 * size];
    }

    public void update(int index) {
        update(0, 0, size - 1, index);
    }

    private void update(int node, int start, int end, int index) {
        if (start == end) {
            tree[node]++;
            return;
        }
        int mid = (start + end) / 2;
        if (index <= mid) {
            update(2 * node + 1, start, mid, index);
        } else {
            update(2 * node + 2, mid + 1, end, index);
        }
        tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
    }

    public int query(int needStart, int needEnd) {
        return query(0, 0, size - 1, needStart, needEnd);
    }

    private int query(int index, int start, int end, int needStart, int needEnd) {
        if (needEnd < start || end < needStart) {
            return 0;
        }
        if (needStart <= start && end <= needEnd) {
            return tree[index];
        }
        int mid = (start + end) / 2;
        return query(2 * index + 1, start, mid, needStart, needEnd) +
               query(2 * index + 2, mid + 1, end, needStart, needEnd);
    }
}