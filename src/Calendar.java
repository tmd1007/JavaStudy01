import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Calendar {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){
        int year, month;

        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해 주세요.(yyyy):");
        year = sc.nextInt();
        System.out.print("달력의 월을 입력해 주세요.(mm):");
        month = sc.nextInt();
        makeCalendar(year, month);
    }

    private static void makeCalendar(int year, int month) {
        ArrayList<Integer> list = new ArrayList<>();
        LocalDate date = LocalDate.of(year, month, 1);  // 년, 월, 일 입력 - day는 요일 체크를 위해 1일 고정
        DayOfWeek dayofWeek = date.getDayOfWeek();                  // 요일을 구하기 위한 객체 생성
        int dayOfWeekNumber = dayofWeek.getValue();                 // 1일이 무슨 요일인지 담기 - 월요일 ~ 일요일 : 1 ~ 7

        if(dayOfWeekNumber != 7) {                                  // 첫날이 일요일인지 체크 (첫날이 일요일이면 첫주에 공란이 없으므로 채울 필요 없음)
            for (int i = 0; i < dayOfWeekNumber; i++) {             // list 달력에서 첫주의 공란을 만들기 위해 공란에 0 채우기 (정수 배열이라 채워야함 / 아니면 다른방법이 있는지?)
                list.add(0);
            }
        }

        for(int i = 1; i<=date.lengthOfMonth(); i++){               // list에 1일 부터 마지막날까지 숫자 채우기
            list.add(i);
        }

        System.out.printf("\n\n[%d년 %02d월]\n", year, month);
        System.out.println("일\t월\t화\t수\t목\t금\t토");
        for(int i =0; i < list.size(); i++){
            if(list.get(i) == 0)                                    // 만약 list의 값이 0이라면
                System.out.print("\t");                             // \t로 채워 공란으로 넘기기
            else
                System.out.printf("%02d\t", list.get(i));           // 0이 아니면 두자리 정수로 출력
            if(i%7 == 6)                                            // 일주일 채울때 마다 개행
                System.out.println();
        }
    }
}