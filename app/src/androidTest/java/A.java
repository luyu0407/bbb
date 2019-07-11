import java.util.Objects;

public class A {

    public A() {
    }

    public static String s = "aa";
    public static void test(){
        System.out.print("A static"+s);
    }

    private String id ;
    public A(String id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return Objects.equals(id, a.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
