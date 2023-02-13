import java.util.Scanner;

public class Tax {
    static Scanner sc = new Scanner(System.in);
    final static long[] taxRate = {6, 15, 24, 35, 38, 40, 42, 45};
    final static long[] deduct = {0, 1080000, 5220000, 14900000, 19400000, 25400000, 35400000, 65400000};
    final static long[] limit ={0, 12000000, 46000000, 88000000, 150000000, 300000000, 500000000, 1000000000};

    public static void calculTax(long amount){
        int type = 0;
        long tax;

        for(int i=0; i< limit.length; i++){
            if(amount > limit[i] && amount <= limit[i+1]){
                type = i;
                break;
            }
        }
    }

    public static void main(String[] args){

        long amount;

        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");
        amount = sc.nextInt();
        calculTax(amount);

    }
}
