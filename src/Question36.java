/**
 * @Author: Skye
 * @Date: 9:48 2018/5/21
 * @Description: 数组中的逆序对
 */
public class Question36 {
    // 方法一：用 partition 的思想，计算当前数字前有几个比其大，时间复杂度还是过高，后来一想这样做比直接遍历还差
    public int InversePairs(int [] array) {
        if (array == null || array.length == 0)
            return 0;
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            count += partition(array,i);
        }
        return count%1000000007;
    }
    //返回 end partition 后的位置
    public int partition(int[] arr,int end){
        int index =  - 1;
        for (int i = index +1; i < end; i++) {
            if (arr[i] > arr[end]){
                index++;
                swap(arr,i,index);
            }
        }
        swap(arr,end,index+1);
        return index+1;
    }
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    // 方法二：利用归并排序的思想，每次合并之前，计算逆序个数
    int count ;
    public  int  InversePairs2(int []array){
        if (array == null || array.length == 0)
            return 0;
        int []temp = new int[array.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        InversePairs2(array,0,array.length-1,temp);
        return count;
    }
    private  void   InversePairs2(int[] arr,int left,int right,int []temp){
        if(left<right){
            int mid = (left+right)/2;
            InversePairs2(arr,left,mid,temp);//左边归并排序，使得左子序列有序
            InversePairs2(arr,mid+1,right,temp);//右边归并排序，使得右子序列有序
            merge(arr,left,mid,right,temp);//将两个有序子数组合并操作
        }
    }
    private  void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时数组指针
        while (i<=mid && j<=right){
            if(arr[i]<=arr[j]){
                temp[t++] = arr[i++];
            }else {
                temp[t++] = arr[j++];
                count=(count+mid-i+1)%1000000007;
            }
        }
        while(i<=mid){//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while(j<=right){//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left <= right){
            arr[left++] = temp[t++];
        }

    }

    public static void main(String[] args) {
        Question36 question36 = new Question36();
        int[] arr = new int[]{1,2,3,4,5,6,7,0};
        System.out.println(question36.InversePairs2(arr));
    }
}
