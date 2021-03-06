class Num{
    Num(float f){
        n=f;
    }
    float n;
}
public class Exe2 {
    public static void main(String[] args) {
        Num m=new Num(2.3f);
        f(m);
        System.out.println(m.n);
    }
    static void f(Num fl){
        fl.n=0.9f;
    }
}
