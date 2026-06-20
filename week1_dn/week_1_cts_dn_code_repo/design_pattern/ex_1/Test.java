package design_pattern.ex_1;

public class Test {
       public static void main(String[] args) {

        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();

        System.out.println(l1);
        System.out.println(l2);

        System.out.println(l1 == l2);
    }
}
