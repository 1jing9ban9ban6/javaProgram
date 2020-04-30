package questionL;

import java.util.Scanner;

/**
 * @author jing
 * @create 2020-03-24-10:19
 */
public class questionDFS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        for(int i = 0;i<a;i++){
            in.nextInt();
            in.nextInt();
            int b = in.nextInt();
            for(int j = 0;j<b;j++){
                in.nextInt();
            }
            System.out.println("YES");
        }
    }
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(m, n, 0, 0, k, visited);
    }
    public int dfs (int m, int n, int i, int j, int k, boolean visited[][]){
        if (i<0||i>=m||j<0||j>=n||(i/10 + i%10 + j/10 + j%10) > k||visited[i][j]) return 0;
        visited[i][j] = true;
        return dfs(m, n, i-1, j, k, visited)+dfs(m, n, i, j-1, k, visited)+
                dfs(m, n, i+1, j, k, visited)+dfs(m, n, i, j+1, k, visited)+1;
    }
}
