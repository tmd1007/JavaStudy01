// 제로베이스 백엔드 10기 전현승
// 과제 2: 캐시백 계산
import java.util.Scanner;

public class Assignment02 {

    public static int back(int money){
        if(money>3000)
            return 300;
        else return money/1000 * 100;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int input;

        System.out.printf("결제 금액을 입력해주세요.(금액):");
        input = sc.nextInt();
        System.out.println("결제 금액은 " + input + "원이고, 캐시백은 " + back(input) + "입니다.");
    }
}

