// 제로베이스 백엔드 10기 전현승
// 과제 3: 입장권 계산
import java.util.Scanner;

public class Assignment03 {

    public static int amount(int age, int time, String merit, String card){
        boolean discount = false;

        if(merit.equals("y") || card.equals("y"))
            discount = true;

        if(age < 3)
            return 0;
        else if(discount)
            return 8000;
        else if(age < 13 || time >= 17)
            return 4000;
        else return 10000;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int age, time;
        String merit, card;

        System.out.println("[입장권 계산]");
        System.out.printf("나이를 입력해 주세요.(숫자):");
        age = sc.nextInt();
        System.out.printf("입장시간을 입력해 주세요.(숫자입력):");
        time = sc.nextInt();
        System.out.printf("국가유공자 여부를 입력해 주세요.(y/n):");
        merit = sc.next();
        System.out.printf("복지카드 여부를 입력해 주세요.(y/n):");
        card = sc.next();
        System.out.println("입장료: " + amount(age, time, merit, card));
    }
}
