public class TypeWrapperExample {
    public static void main(String[] args) {
        int x = 10;
        Integer ix = x; // boxing
        int y = ix; // unboxing
        System.out.println(y);
    }
}
