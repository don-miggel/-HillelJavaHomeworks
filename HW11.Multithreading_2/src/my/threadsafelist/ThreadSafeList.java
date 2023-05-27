package my.threadsafelist;

import java.lang.reflect.Array;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeList<T> {

    private static final int DEFAULT_SIZE = 10;

    private  T[] innerArray;
    private final ReentrantReadWriteLock rwLock;
    private final Lock readLock;
    private final Lock writeLock;
    private int currentPosition;

    public ThreadSafeList(int size){
        innerArray = generateGenericArray(size);
        rwLock = new ReentrantReadWriteLock();
        readLock = rwLock.readLock();
        writeLock = rwLock.writeLock();
        currentPosition = 0;
    }

    public ThreadSafeList(){
        this(DEFAULT_SIZE);
    }

    private T[] generateGenericArray(int size){
        T[] genArr = getGenericArray();
        return (T[]) Array.newInstance(genArr.getClass().getComponentType(), size);
    }

    @SafeVarargs
    private T[] getGenericArray(T...elems){
        return elems;
    }

    public void add(T elem){
        try {
            writeLock.lock();
            if ((getFilledElemsCount(innerArray) >=  0.75 * innerArray.length)){
                innerArray = increaseArraySize();
            }
            if (innerArray.length == 1){
                currentPosition = 0;
            }
            innerArray[currentPosition++] = elem;
        }finally {
            writeLock.unlock();
        }
    }

    public void remove(int pos){
        try {
            writeLock.lock();
            if (pos < 0 || pos > innerArray.length || innerArray.length < 1) return;
            removeElem(pos);
            currentPosition--;
            if (getFilledElemsCount(innerArray) <= innerArray.length / 2){
                innerArray = shrinkArray();
            }
        }finally {
            writeLock.unlock();
        }
    }

    public T get(int pos){
        try {
            readLock.lock();
            if (pos < 0 || pos > innerArray.length) return null;
            return innerArray[pos];
        }finally {
            readLock.lock();
        }
    }

    private T[] shrinkArray(){
        T[] newArr;
        try {
            writeLock.lock();
            double incrCoef = innerArray.length < 2 ? 3 : 1.5;
            newArr = generateGenericArray((int) (getFilledElemsCount(innerArray) * incrCoef));
            for(int i = 0; i< newArr.length; i++){
                if (innerArray[i] != null)
                    newArr[i] = innerArray[i];
            }
            currentPosition = getFilledElemsCount(newArr);
        }finally {
            writeLock.unlock();
        }
        return newArr;
    }

    private int getFilledElemsCount(T[] arr){
        int countNotNull = 0;

            for (T elem : arr) {
                if (elem != null)
                    countNotNull++;
            }
        return countNotNull;
    }

    private void removeElem(int pos){
            System.arraycopy(innerArray, pos + 1, innerArray, pos, innerArray.length - (pos + 1));
    }

    private T[] increaseArraySize(){
        T[] newArr;
        try {
            writeLock.lock();
            int size = innerArray.length < 1 ? 2 : (int) (innerArray.length * 1.5);
            newArr = generateGenericArray(size);
            int counter = 0;
            for (T elem: innerArray){
                if(elem != null)
                    newArr[counter++] = elem;
            }
            currentPosition = getFilledElemsCount(innerArray);
        }finally {
            writeLock.unlock();
        }
        return newArr;
    }

    public int getSize(){ return innerArray.length; }

    public void displayList(){

            readLock.lock();
            for (T elem : innerArray) {
                if (elem != null)
                    System.out.println(elem);
            }
   }

    public int getCurrentPosition() {
        return currentPosition;
    }
}
