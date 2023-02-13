// 제로베이스 백엔드 10기 전현승
// 과제 6: 가상 선거 프로그램
import java.util.Random;

public class Assignment06 {
    public static boolean checkDp(int[] arr){
        int max = 0;
        int maxIndex = 0;
        for(int i=0; i<arr.length; i++){
            if(max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }

        for(int i=0; i<arr.length; i++){
            if(maxIndex != i){
                if(max == arr[i])
                    return true;
            }
        }

        return false;
    }

    public static int checkMax(int[] arr){
        int max = arr[0];
        int maxIndex = 0;
        for(int i=0; i<arr.length; i++){
            if(max < arr[i]) {
                max = arr[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public static void main(String[] args){
        int voteAll = 10000;
        int vote = 10000;
        double percent = (double)vote/voteAll * 100;
        String[] name = {"이재명", "윤석열", "심상정", "안철수"};
        int[] voteArray = {0, 0, 0, 0};
        Random rd = new Random();

        int voteNum = 0;

        while(true) {
            for (int i = 0; i < vote; i++) {
                voteNum = rd.nextInt(4);
                switch (voteNum) {
                    case 3:
                        ++voteArray[3];
                        break;
                    case 2:
                        ++voteArray[2];
                        break;
                    case 1:
                        ++voteArray[1];
                        break;
                    case 0:
                        ++voteArray[0];
                        break;
                }
            }

            if (checkDp(voteArray)) {
                voteArray[0] = 0;
                voteArray[1] = 0;
                voteArray[2] = 0;
                voteArray[3] = 0;
            }
            else break;
        }

        System.out.printf("[투표진행율]: %.2f%%, %d명 투표 => %s\n", percent, vote, name[voteNum]);

        for(int i=0; i<voteArray.length; i++){
            System.out.printf("[기호:%d] %s: %02.2f%%, (투표수: %d)\n", i+1, name[i], (double)voteArray[i]/voteAll * 100, voteArray[i]);
        }

        if(vote == voteAll){
            System.out.printf("[투표결과] 당선인: %s", name[checkMax(voteArray)]);
        }
    }
}




