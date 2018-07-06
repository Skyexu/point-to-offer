package corejava;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @Author: Skye
 * @Date: 20:42 2018/3/27
 * @Description: ch02 16 17
 */
public class Queue {
    private ArrayList<Node> list = new ArrayList<>();

    private static class Node{
        private String content = "";

        public Node(String content){
            this.content = content;
        }
        public String getContent() {
            return content;
        }
    }

    private class Iterator{
        private int i = 0;
        public String next(){
            return Queue.this.list.get(i++).getContent();
        }
        public boolean hasNext(){
            return  i+1 < list.size();
        }
    }
    public void add(String value){
        Node node = new Node(value);
        list.add(node);
    }

    public void remove(){
        if (list.size() >0){
            list.remove(0);
        }
    }

    public Iterator iterator() {
            Iterator iterator = new Iterator();
            return iterator;
    }
    public static void main(String[] args) {
        Queue queue = new Queue();

        for (int i=0; i<50; ++i) {
            queue.add(String.valueOf(i));
        }

        int i = 40;
        while (i>0) {
            queue.remove();
            --i;
        }

        Queue.Iterator iterator = queue.iterator();
        while (iterator.hasNext()) {
            String content = iterator.next();
            System.out.println(content);
        }

    }


}
