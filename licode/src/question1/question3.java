package question1;

public class question3 {
//    给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
//    完成所有替换操作后，请你返回这个数组。
//    输入：arr = [17,18,5,4,6,1]
//    输出：[18,6,6,6,1,-1]
    public static void main(String[] args) {
        int [] arr = new int[]{17,18,5,4,6,1};
        if (arr.length==1){
            arr[0]=-1;
        } else {
            for (int i = 0; i<arr.length-1;i++){
                int max = arr[i+1];
                for (int j = i+1; j<arr.length;j++){
                    if (arr[j]>max){
                        max = arr[j];
                    }
                }
                arr[i]=max;
            }
            arr[arr.length-1] = -1;
        }
        for (int o =0; o<arr.length;o++){
            System.out.println(arr[o]);
        }
    }
}

