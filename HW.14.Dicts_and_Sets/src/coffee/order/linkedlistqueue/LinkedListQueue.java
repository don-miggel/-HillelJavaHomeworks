package coffee.order.linkedlistqueue;

import java.lang.reflect.Field;

public class LinkedListQueue<T> {

    private class Node<T> {

        private T val;
        private Node<T> next;

        public Node(T val, Node<T> next) {
            this.val = val;
            this.next = next;
        }
    }

    private Node<T> rear;
    private Node<T> front;

    public LinkedListQueue() {
        rear = front = null;
    }

    public void enqueue(T val) {

        if (rear != null) {
            rear.next = new Node<>(val, null);
            rear = rear.next;
        } else {
            rear = new Node<>(val, null);
            front = rear;
        }
    }

    public T dequeue() {
        if (front != null) {
            T returnedVal = front.val;
            front = front.next;
            return returnedVal;
        }
        rear = null;
        return null;

    }

    public T peek() {
        if (front.next == null)
            return front.val;

        T val = null;
        Node<T> next = front;
        Node<T> prev = next;
        while (next != null) {
            if (next.next != null)
                prev = next;
            next = next.next;
        }

        if (prev.next != null)
            val = prev.next.val;
        return val;
    }

    public T remove(T val) {
        T returnedValue = null;

        if (front != null && front.val.equals(val)) {
            returnedValue = front.val;
            front = front.next;
            return returnedValue;
        }

        boolean flag = false;
        Node<T> node = front;
        Node<T> prev = front;
        while (node != null) {
            if (node.val.equals(val)) {
                flag = true;
                break;
            }
            prev = node;
            node = node.next;
        }
        if (flag) {
            returnedValue = prev.next.val;
            prev.next = node.next;
        }
        return returnedValue;
    }

    /*
    public T remove(){
        T val = null;
        Node<T> next = front;
        Node<T> prev = next;
        while (next != null){
            if(next.next != null)
                prev = next;
            next = next.next;
        }

        if(prev.next != null)
            val = prev.next.val;
        prev.next = null;
        return val;
    }

     */

    public T remove() {
        T val = null;
        if (front != null) {
            val = front.val;
            front = front.next;
        }
        return val;
    }

    private String getClassName(String val) {
        if (val.indexOf('.') != -1) {
            return val.substring(val.lastIndexOf('.') + 1);
        }
        return val;
    }

    public <U> T find(U val) {
        T foundVal = null;
        Node<T> node = front;
        Field[] fields = node.val.getClass().getDeclaredFields();
        for (Field field : fields) {
            String valClass = getClassName(val.getClass().toString());
            String fieldClass = getClassName(field.getType().getName());
            if (valClass.toLowerCase().contains(fieldClass.toLowerCase())) {
                while (node != null) {
                    String[] values = node.val.toString().split("\\|");
                    for (String strField : values) {
                        try {
                            if (strField.trim().equals(String.valueOf(val).trim())) {
                                foundVal = node.val;
                                break;
                            }
                        } catch (ClassCastException e) {
                            System.out.println(e);
                        }
                    }
                    node = node.next;
                }
            }
        }
        return foundVal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> node = front;
        while (node != null) {
            sb.append(node.val + "\n");
            node = node.next;

        }
        return sb.toString();
    }

    public boolean empty() {
        return front == null;
    }

}
