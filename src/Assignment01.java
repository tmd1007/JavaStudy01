// 제로베이스 백엔드 10기 전현승
// 과제 1: 구구단 출력
public class Assignment01 {
    public static void main(String[] args){
        System.out.println("[구구단 출력]");
        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= 9; j++){
                System.out.printf("%02d x %02d = %02d\t", j, i , i * j);
            }
            System.out.println();
        }
    }
}