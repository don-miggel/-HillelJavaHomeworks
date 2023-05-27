package my.threadsafelist;

public class Main {
    public static void main(String[] args) {
        ThreadSafeList<Integer> myThrSageIntList = new ThreadSafeList<>();


        new Thread(()->{
            myThrSageIntList.add(1);
            myThrSageIntList.add(17);
            myThrSageIntList.add(35);
            myThrSageIntList.remove(1);
            myThrSageIntList.add(10);
            myThrSageIntList.add(12);
        }).start();

        new Thread(()->{
            myThrSageIntList.add(27);
            myThrSageIntList.remove(0);
            myThrSageIntList.remove(2);
            myThrSageIntList.add(47);

        }).start();

        new Thread(()->{
            System.out.println(myThrSageIntList.get(0));
            System.out.println(myThrSageIntList.get(2));
            System.out.println("-------------------");
            myThrSageIntList.displayList();
        }).start();

    }
}
