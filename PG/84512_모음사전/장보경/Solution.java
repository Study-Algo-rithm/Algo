import java.util.*;

class Solution {
    static boolean[] visited;
    static TreeSet<String> ts;

    public static int solution(String word) {
        int answer = 0;

        visited = new boolean[5];
        ts = new TreeSet<>();

        perm(0, new StringBuilder());

        for (String str: ts){
            if (str.equals(word)){
                break;
            }
            answer++;
        }
        
        return answer;
    }

    static void perm(int cnt, StringBuilder sb){
        if (cnt == 5){
            ts.add(sb.toString());
            return;
        }

        for (int i=0; i<5; i++){
            perm(cnt+1, sb);

            sb.append(getAlpha(i));
            perm(cnt+1, sb);
            sb.delete(sb.length()-1, sb.length());
        }
    }

    static String getAlpha(int idx){
        switch (idx){
            case 0:
                return "A";
            case 1:
                return "E";
            case 2:
                return "I";
            case 3:
                return "O";
            case 4:
                return "U";
        }
        return "";
    }
}
