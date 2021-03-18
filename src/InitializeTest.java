class Tester{
    int a;
    int b;
    Tester(){
        System.out.println("Initialize!");
    }
    Tester(int m,int n){
        this();
        a=m;
        b=n;
    }
}
public class InitializeTest {
    public static void main(String[] args) {
        Tester tester=new Tester(2,3);
    }
}
