import java.util.Stack;
/**
 * @Author: Skye
 * @Date: 14:18 2018/5/2
 * @Description: 包含min函数的栈
 *
    定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。

    解法：维护一个存放最小元素的栈
 */
public class Question21 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if (minStack.empty()){
            minStack.push(node);
        }else {
            if (node < minStack.peek())
                minStack.push(node);
            else
                minStack.push(minStack.peek());
        }

    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        Question21 q = new Question21();
        q.push(3);
        System.out.println(q.min());
    }
}
