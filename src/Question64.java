import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Skye
 * @Date: 15:43 2018/6/11
 * @Description: 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Question64 {
    private Queue<Integer> minHeap = new PriorityQueue<>();
    private Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private int count = 0;
    // 使用最大堆和最小堆实现
    public void Insert(Integer num) {

        // 偶数插入最小堆，奇数插入最大堆
        if (count % 2 == 0) {
            if (!maxHeap.isEmpty() && maxHeap.peek() > num) {
                // 比最大堆顶还小，则插入最大堆,最大堆顶放入最小堆
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
            }else {
                minHeap.offer(num);
            }
        }else {
            if (!minHeap.isEmpty() && minHeap.peek() < num) {
                // 比最小堆顶大，则插入最小堆,最小堆顶放入最大堆
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
            }else {
                maxHeap.offer(num);
            }
        }
        count++;
    }
    public Double GetMedian() {
        if (count % 2 != 0){
            return minHeap.peek()*1.0;
        }else {
            return (minHeap.peek()+maxHeap.peek())*1.0/2;
        }
    }
}
