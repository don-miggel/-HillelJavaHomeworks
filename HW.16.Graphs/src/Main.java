import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MyTree myTree = new MyTree();
        System.out.println("Please, enter a nonnegative numbers");
        int num = sc.nextInt();
        while (num >= 0){
            myTree.add(num);
            num = sc.nextInt();
        }

        System.out.println("Tree contains following numbers: ");
        myTree.displayTree();
    }

}
