import java.util.Random;
import java.util.Scanner;

public class IDNumber {
    public static String number(String year, String month, String day, String sex){
        String idNum;
        String sexNum = sex.equals("m") ? "3" : "4";
        Random rand = new Random();
        int randNum = rand.nextInt(1000000);

        idNum = year + month + day + "-" + sexNum;

        String s = idNum + randNum;

        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String year, month, day;
        String sex;


        System.out.println("[주민등록번호 계산]");
        System.out.printf("출생년도를 입력해 주세요.(yyyy):");
        year = sc.next();
        System.out.printf("출생월을 입력해 주세요.(mm):");
        month = sc.next();
        System.out.printf("출생일을 입력해 주세요.(dd):");
        day = sc.next();
        System.out.printf("성별을 입력해 주세요.(m/f):");
        sex = sc.next();
        System.out.println(number(year, month, day, sex));
    }
}
