import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashSet<String> hs = new HashSet<>();
        hs.add(words[0]);
        for (int i=1; i<words.length; i++){
            if (words[i-1].length() < 2){  // 한 글자일 경우
                answer = getResult(n, i-1);
                break;
            }

            if (hs.contains(words[i])){  // 이전에 등장했던 단어일 경우
                answer = getResult(n, i);
                break;
            }
            hs.add(words[i]);

            if (!compareAlpha(words[i-1], words[i])){  // 앞 사람이 말한 단어의 마지막 문자로 시작하지 않는 경우
                answer = getResult(n, i);
                break;
            }
        }

        return answer;
    }

    // 앞사람이 말한 단어의 마지막 문자와 현재 사람이 말한 단어의 맨 앞 문자 비교
    static boolean compareAlpha(String word1, String word2){
        char endAlpha = word1.charAt(word1.length()-1);
        char startAlpha = word2.charAt(0);

        if (endAlpha == startAlpha) return true;

        return false;
    }

    // 탈락하는 사람의 번호, 몇 번째에 탈락하는 지 결과 반환
    static int[] getResult(int n,  int failIdx){
        int[] result = new int[2];

        int idx = (failIdx+1) % n;

        result[0] = (idx != 0)? idx:n ;
        result[1] = failIdx/n + 1;

        return result;
    }
}
