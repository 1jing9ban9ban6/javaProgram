package question1;

import com.sun.xml.internal.txw2.output.IndentingXMLFilter;

import java.time.Year;
import java.util.HashMap;

public class question1 {
    public static void main(String[] args) {
//        给你一个 n 行 m 列的矩阵，最开始的时候，每个单元格中的值都是 0。
//        另有一个索引数组 indices，indices[i] = [ri, ci] 中的 ri 和 ci
//        分别表示指定的行和列（从 0 开始编号）。
//        你需要将每对 [ri, ci] 指定的行和列上的所有单元格的值加 1。
//        请你在执行完所有 indices 指定的增量操作后，返回矩阵中 「奇数值单元格」 的数目。
        int n=2,m=3,x=0,y=0,num=0;
        int [][] index = new int[][]{{0,1},{1,1}};
        int [][] list = new int[n][m];
        for (int i = 0; i < index.length; i++){
            x = index[i][0];
            for (int j = 0; j < m; j++){
                list[x][j] = list[x][j] + 1;
            }
            y = index[i][1];
            for (int k = 0; k < n; k++){
                list[k][y] = list[k][y] + 1;
            }
        }
        for (int l = 0; l<list.length; l++){
            for (int o = 0; o<list[l].length; o++){
                if ((list[l][o]&1)==1){
                    num++;
                }
            }
        }
        System.out.println(num);
    }
}
