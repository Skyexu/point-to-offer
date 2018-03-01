import java.util.Stack;

/**
 * @Author: Skye
 * @Date: 20:25 2018/3/1
 * @Description: 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * 解法： 以 stack1 来表示入队列， stack2 来表示出队列
 */
public class Question07 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }
        if (stack2.empty()){
            while (!stack1.empty()){
                int node = stack1.pop();
                stack2.push(node);
            }
        }
        return stack2.pop();
    }
    public static void main(String[] args){
        Question07 queue = new Question07();
        queue.push(1);
        queue.push(3);
        queue.push(2);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}
