class Solution {
    char[][] board = {
        {'a', 'b', 'c', 'd', 'e'},
        {'f', 'g', 'h', 'i', 'j'},
        {'k', 'l', 'm', 'n', 'o'},
        {'p', 'q', 'r', 's', 't'},
        {'u', 'v', 'w', 'x', 'y'},
        {'z', ' ', ' ', ' ', ' '}
    };
    int[] x = {-1, 0, 1, 0};
    int[] y = {0, 1, 0, -1};
    static Map<Character, Map<Character, String>> map = new HashMap<>();
    public String alphabetBoardPath(String target) {
        int n = target.length();
        if (map.get('a') == null) {
            findAllPoosiblePath();
        }
        StringBuilder sb = new StringBuilder();
        char last = 'a';
        for(int i=0;i<n;i++){
            char cur = target.charAt(i);
            sb.append(map.get(last).get(cur));
            sb.append("!");
            last = cur;
        }
        return sb.toString();
    }

    public boolean isValidIndex(int i, int j, int m, int n) {
        return 0 <= i && i < m && 0 <= j && j < n && board[i][j] != ' ';
    }

    public void findAllPoosiblePath() {
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<6;i++){
            for(int j=0;j<board[i].length;j++) {
                if(board[i][j] != ' '){
                    queue.add(new Pair(i, j, board[i][j], ""));
                }
            }
        }
        for(int i = 0; i < 26; i++){
            char ch = (char) (i + 'a');
            map.put(ch, new HashMap<>());
            map.get(ch).put(ch, "");
        }

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            int curI = cur.i;
            int curJ = cur.j;
            char startCh = cur.start;
            String curPath = cur.path;

            for (int i = 0; i < 4; i++) {
                int ni = curI + x[i];
                int nj = curJ + y[i];

                if (isValidIndex(ni, nj, 6, 5)) {
                    char next = board[ni][nj];
                    if (map.get(startCh).get(next) == null) {
                        String newPath = curPath;
                        if (i == 0) newPath += "U";
                        else if (i == 1) newPath += "R";
                        else if (i == 2) newPath += "D";
                        else newPath += "L";

                        map.get(startCh).put(next, newPath);
                        queue.add(new Pair(ni, nj, startCh, newPath));
                    }
                }
            }
        }
    }
}

class Pair {
    int i;
    int j;
    char start;
    String path;
    public Pair(int i, int j, char start, String path) {
        this.i = i;
        this.j = j;
        this.start = start;
        this.path = path;
    }
}
