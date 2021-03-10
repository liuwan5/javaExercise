//简单的四则运算计算器
import java.util.Scanner;
import java.util.ArrayList;
public class SimpleCalculator {
    char[] opeStack=new char[300];
    int[] numstack=new int[3000];
    int[] bracketsPosition=new int[100];
    int opeStackPointer=0;
    int numStackPointer=0;
    int bracketsPositionStackPointer=0;
    ArrayList<String> chars = new ArrayList<String>();
    public static void main(String[] args) {
        SimpleCalculator cal=new SimpleCalculator();
        cal.getter();
        cal.runner();
    }
    void getter(){
        System.out.println("仅支持四则运算，支持括号");
        System.out.println("请输入你的算式，以\"=\"结束：");
        Scanner scan=new Scanner(System.in);
        String expression=scan.nextLine();
        int i=0;
        int j=0;
        int l=0;
        char tem=expression.charAt(i);
        char[] temnum=new char[100];
        boolean ifNum=false;
        while (tem!='='){
            i++;
            if(tem==' '){
                if(ifNum){
                    ifNum=false;
                    String t=new String(temnum,0,l);
                    chars.add(t);
                    l=0;
                }
            }
            else{
                if(tem>='0'&&tem<='9'){

                    if(!ifNum){
                        ifNum=true;
                    }
                    temnum[l]=tem;
                    l++;
                }
                else{
                    if(ifNum){
                        ifNum=false;
                        String t=new String(temnum,0,l);
                        chars.add(t);
                        l=0;
                    }
                    char[] tch=new char[1];
                    tch[0]=tem;
                    String s=new String(tch);
                    chars.add(s);
                }
            }
            tem=expression.charAt(i);
        }
        chars.add("=");
    }
    void runner(){
        bracketsPosition[0]=0;
        for(String s:chars) {
            try {
                numstack[numStackPointer]=Integer.parseInt(s);
                numStackPointer++;
            }
            catch (NumberFormatException ex){
                char tch=s.charAt(0);
                if(tch=='('){
                    bracketsPositionStackPointer++;
                    bracketsPosition[bracketsPositionStackPointer]=opeStackPointer;
                    continue;
                }
                if (tch==')'){
                    while (opeStackPointer != bracketsPosition[bracketsPositionStackPointer]) {
                        switch (opeStack[opeStackPointer - 1]) {
                            case '*':
                                numstack[numStackPointer - 2] *= numstack[numStackPointer - 1];
                                break;
                            case '/':
                                numstack[numStackPointer - 2] /= numstack[numStackPointer - 1];
                                break;
                            case '+':
                                numstack[numStackPointer - 2] += numstack[numStackPointer - 1];
                                break;
                            case '-':
                                numstack[numStackPointer - 2] -= numstack[numStackPointer - 1];
                                break;
                        }
                        numStackPointer--;
                        opeStackPointer--;
                    }
                    bracketsPositionStackPointer--;
                    continue;
                }
                if (tch=='='){
                    while (opeStackPointer != bracketsPosition[bracketsPositionStackPointer]) {
                        switch (opeStack[opeStackPointer - 1]) {
                            case '*':
                                numstack[numStackPointer - 2] *= numstack[numStackPointer - 1];
                                break;
                            case '/':
                                numstack[numStackPointer - 2] /= numstack[numStackPointer - 1];
                                break;
                            case '+':
                                numstack[numStackPointer - 2] += numstack[numStackPointer - 1];
                                break;
                            case '-':
                                numstack[numStackPointer - 2] -= numstack[numStackPointer - 1];
                                break;
                        }
                        numStackPointer--;
                        opeStackPointer--;
                    }
                    System.out.println(numstack[0]);
                    break;
                }

                else if(opeStackPointer==bracketsPosition[bracketsPositionStackPointer]){
                    opeStack[opeStackPointer]=tch;
                    opeStackPointer++;
                }
                else{
                switch (tch) {
                    case '-':
                    case '+':
                            while (opeStackPointer != bracketsPosition[bracketsPositionStackPointer]) {
                                switch (opeStack[opeStackPointer - 1]) {
                                    case '*':
                                        numstack[numStackPointer - 2] *= numstack[numStackPointer - 1];
                                        break;
                                    case '/':
                                        numstack[numStackPointer - 2] /= numstack[numStackPointer - 1];
                                        break;
                                    case '+':
                                        numstack[numStackPointer - 2] += numstack[numStackPointer - 1];
                                        break;
                                    case '-':
                                        numstack[numStackPointer - 2] -= numstack[numStackPointer - 1];
                                        break;
                                }
                                numStackPointer--;
                                opeStackPointer--;
                        }
                        opeStack[opeStackPointer] = tch;
                        opeStackPointer++;
                        break;
                    case '*':
                        switch (opeStack[opeStackPointer - 1]) {
                            case '*':
                                numstack[numStackPointer - 2] *= numstack[numStackPointer - 1];
                                numStackPointer--;
                                break;
                            case '/':
                                numstack[numStackPointer - 2] /= numstack[numStackPointer - 1];
                                numStackPointer--;
                                opeStack[opeStackPointer - 1] = '*';
                                break;
                            case '+':
                            case '-':
                                opeStack[opeStackPointer]='*';
                                opeStackPointer++;
                                break;
                        }
                        break;
                    case '/':
                        switch (opeStack[opeStackPointer - 1]) {
                            case '/':
                                numstack[numStackPointer - 2] /= numstack[numStackPointer - 1];
                                numStackPointer--;
                                break;
                            case '*':
                                numstack[numStackPointer - 2] *= numstack[numStackPointer - 1];
                                numStackPointer--;
                                opeStack[opeStackPointer - 1] = '/';
                                break;
                            case '+':
                            case '-':
                                opeStack[opeStackPointer]='/';
                                opeStackPointer++;
                                break;
                        }
                        break;
                    }
                }
            }
        }
    }
}
