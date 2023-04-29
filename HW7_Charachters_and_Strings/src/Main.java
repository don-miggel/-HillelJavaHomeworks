public class Main {

    public static void main(String[] args) {

        // task 2
        System.out.println("---------task 2---------------");
        System.out.println(findSymbolOccurance("Java", 'a'));
        System.out.println(findSymbolOccurance("acceptance", 'c'));
        System.out.println(findSymbolOccurance("Java", 'd'));
        // task 3
        System.out.println("----------task 3----------------------");
        System.out.println(findWordPosition("Apollo", "pollo"));
        System.out.println(findWordPosition("Apple", "Plant"));
        // task 4
        System.out.println("---------task 4----------------------");
        System.out.println(stringReverse("Hello"));
        // task 5
        System.out.println("-----------task 5 --------------------");
        System.out.println(isPalindrome("ERE"));
        //detartrated is the longest English palindrome
        System.out.println(isPalindrome("detartrated"));
        System.out.println(isPalindrome("Allo"));

    }

    public static int findSymbolOccurance(String str, char ch){

        int occuranceNum = 0;
        for(int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ch)
                occuranceNum++;
        }
        return occuranceNum;
    }

    public static int  findWordPosition(String text, String word){
        return text.indexOf(word);
    }

    public static StringBuilder stringReverse(String str){

        StringBuilder reversed = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--)
            reversed.append(str.charAt(i));

        return reversed;
    }

    public static boolean isPalindrome(String str){

        int left = 0;
        int right = str.length()-1;
        while (left != right){
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;

    }


}
