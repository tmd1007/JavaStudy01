// 제로베이스 백엔드 10기 전현승
// 과제 7: 로또 당첨 프로그램
import java.util.Arrays;
import java.util.Scanner;

public class Assignment07 {
    static Scanner sc = new Scanner(System.in);

    public static int[] creatLotto(){
        int[] arrLotto = new int[45];
        int[] sixNum;

        for(int i=0; i<arrLotto.length; i++){
            arrLotto[i] = i+1;
        }

        for(int x=0; x<arrLotto.length; x++){
            int i = (int)(Math.random()*arrLotto.length);
            int j = (int)(Math.random()*arrLotto.length);

            int tmp = arrLotto[i];
            arrLotto[i] = arrLotto[j];
            arrLotto[j] = tmp;
        }

        sixNum = Arrays.copyOf(arrLotto, 6);
        Arrays.sort(sixNum);

        return sixNum;
    }

    public static int checkEquals(int[] a, int[] b){
        int cnt = 0;
        for(int i=0; i<a.length; i++){
            for(int j=0; j<b.length; j++){
                if(a[i] == b[j])
                    cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args){

        int ticket;
        int[][] lottoNum;
        int[] winLotto;

        System.out.println("[로또 당첨 프로그램]\n");
        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");
        ticket = sc.nextInt();
        lottoNum = new int[ticket][6];

        for(int i=0; i<lottoNum.length; i++){
            lottoNum[i] = creatLotto().clone();
        }

        for(int i=0; i<lottoNum.length; i++){
            char num = 'A';
            System.out.printf("%c\t", num+i);
            for(int j=0; j<lottoNum[i].length; j++){
                if(j == 5)
                    System.out.printf("%02d ", lottoNum[i][j]);
                else
                    System.out.printf("%02d, ", lottoNum[i][j]);
            }
            System.out.println();
        }

        System.out.println("\n[로또 발표]");
        winLotto = creatLotto();
        System.out.printf("\t");
        for(int i=0; i<winLotto.length; i++){
            if(i == 5)
                System.out.printf("%02d ", winLotto[i]);
            else
                System.out.printf("%02d, ", winLotto[i]);
        }

        System.out.println("\n\n[내 로또 결과]");
        for(int i=0; i<lottoNum.length; i++){
            char num = 'A';
            System.out.printf("%c\t", num+i);
            for(int j=0; j<lottoNum[i].length; j++){
                if(j == 5)
                    System.out.printf("%02d => %d개 일치", lottoNum[i][j], checkEquals(lottoNum[i], winLotto));
                else
                    System.out.printf("%02d, ", lottoNum[i][j]);
            }
            System.out.println();
        }
    }
}
