
public class VarargsTest {
    static void f(String... strs){
        for (String str:strs){
            System.out.print(str+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        f("Liu","Ya","Jia");
        String[] s=new String[]{
                "Liu",
                "Ya",
                "Jia",
        };
        f(s);
    }
}
