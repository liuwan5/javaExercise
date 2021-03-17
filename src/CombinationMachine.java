import java.util.Scanner;
public class CombinationMachine {
    CombinationMachine(int a,int b){
        n=a;
        k=b;
    }

    private int n;
    private int k;
    private int[] tem;
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int a=scan.nextInt();
        int b=scan.nextInt();
        CombinationMachine cm=new CombinationMachine(a,b);
        cm.setValue();
    }
    boolean[] flag;
    void setValue(){
        tem=new int[k];
        flag=new boolean[n+1];
        for(int i=1;i<=k;i++){
            flag[i]=false;
        }
        search(1,k);
    }
    void search(int base,int c){
        if(c==0){
            for(int i:tem){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        else{
            for (int i=base;i<=n;i++){
                if(flag[i]==false){
                    flag[i]=true;
                    tem[k-c]=i;
                    search(i+1,c-1);
                    tem[k-c]=0;
                    flag[i]=false;
                }
            }
        }
    }
}
