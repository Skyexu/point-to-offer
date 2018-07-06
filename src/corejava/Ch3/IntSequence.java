package corejava.Ch3;

/**
 * @Author: Skye
 * @Date: 20:39 2018/7/1
 * @Description:
 */
public interface IntSequence {
    default boolean hasNext(){return true;}
    int next();

    /**
     * 返回匿名内部类的实例
     * @param nums
     * @return
     */
    public static IntSequence of(int... nums){

        return new IntSequence() {
            private int index = 0;
            @Override
            public int next() {
                int number = nums[index];
                ++index;
                return number;
            }

            @Override
            public boolean hasNext() {
                return index < nums.length ;
            }
        };
    }
    public static IntSequence constant(int num){
        return () -> num;
    }

//    /**
//     * 返回局部类的实例
//     * @param nums
//     * @return
//     */
//    public static IntSequence of(int... nums){
//        class MySequence implements IntSequence{
//            private int index = 0;
//            @Override
//            public boolean hasNext() {
//                return index < nums.length ;
//            }
//
//            @Override
//            public int next() {
//                int number = nums[index];
//                ++index;
//                return number;
//            }
//        }
//       return new MySequence();
//    }
}
