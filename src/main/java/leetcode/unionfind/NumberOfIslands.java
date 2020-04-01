package leetcode.unionfind;

/**
 * @author huangqian
 * @version 1.0.0
 * @time 2020/3/31 - 17:56
 * @description: 200. 岛屿数量
 * <pre>
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * </pre>
 */
public class NumberOfIslands {

    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }

            }
        }

        public int find(int i) {
            if (parent[i] != i)
                parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                --count;
            }
        }

        public int getCount() {
            return this.count;
        }
    }

    /**
     * 思路：并查集
     */
    public int numIsLands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rowCnt = grid.length;
        int columnCnt = grid[0].length;
        UnionFind uf = new UnionFind(grid);

        for (int r = 0; r < rowCnt; r++) {
            for (int c = 0; c < columnCnt; c++) {
                if (grid[r][c] == '1') {
                    //上面
                    if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                        uf.union(r * columnCnt + c, (r - 1) * columnCnt + c);
                    }
                    //下面
                    if (r + 1 < rowCnt && grid[r + 1][c] == '1') {
                        uf.union(r * columnCnt + c, (r + 1) * columnCnt + c);
                    }
                    //左边
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                        uf.union(r * columnCnt + c, r * columnCnt + c - 1);
                    }
                    //右边
                    if (c + 1 < columnCnt && grid[r][c + 1] == '1') {
                        uf.union(r * columnCnt + c, r * columnCnt + c + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }


    public int numIsLands2(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rowCnt = grid.length;
        int columnCnt = grid[0].length;
        UnionFind uf = new UnionFind(grid);

        for (int r = 0; r < rowCnt; r++) {
            for (int c = 0; c < columnCnt; c++) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    //下面
                    if (r + 1 < rowCnt && grid[r + 1][c] == '1') {
                        uf.union(r * columnCnt + c, (r + 1) * columnCnt + c);
                    }
                    //右边
                    if (c + 1 < columnCnt && grid[r][c + 1] == '1') {
                        uf.union(r * columnCnt + c, r * columnCnt + c + 1);
                    }
                }
            }
        }
        return uf.getCount();
    }
}
