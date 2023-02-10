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
        LocalDate date = LocalDate.of(year, month, 1);
        DayOfWeek dayofWeek = date.getDayOfWeek();
        int dayOfWeekNumber = dayofWeek.getValue();

        if(dayOfWeekNumber != 7) {
            for (int i = 0; i < dayOfWeekNumber; i++) {
                list.add(0);
            }
        }

        for(int i = 1; i<=date.lengthOfMonth(); i++){
            list.add(i);
        }

        System.out.printf("\n\n[%d년 %02d월]\n", year, month);
        System.out.println("일\t월\t화\t수\t목\t금\t토");
        for(int i =0; i < list.size(); i++){
            if(list.get(i) == 0)
                System.out.print("\t");
            else
                System.out.printf("%02d\t", list.get(i));
            if(i%7 == 6)
                System.out.println();
        }
    }
}