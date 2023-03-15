import java.util.*;

/****
    * 컬럼 기준 중복이 있는 지 확인
    * HashSet, 기존에 값 있었다면 그 친구는 중복되는 튜플로 간주
    * 그럴경우 조합 생성
    * 이름Str+전공Str와 같이 String으로 묶었을 때 중복되는지 확인
    * 만약 없다면 최소성 만족하는지 모르는 후보키
    * 최소성 검사하여 최종 답 도출
****/

class Solution {
    static int columnLen, rowLen, nonMin;
    static int[] visited;  // 방문체크겸 후보키인애들 체크(1=최초 후보키, 2=방문)
    static ArrayList<ArrayList<Integer>> idxArr;  // 유일성 만족하는 집합의 idx

    public static int solution(String[][] relation) {
        int answer = 0;

        rowLen = relation.length;
        columnLen = relation[0].length;

        visited = new int[columnLen];
        for(int i=0; i<columnLen; i++){
            HashSet<String> hs = new HashSet<>();  // 컬럼 중복 체크 위한 set

            for (int j=0; j<rowLen; j++){
                if (!hs.contains(relation[j][i])){
                    hs.add(relation[j][i]);
                } else{
                    break;
                }
            }

            if (hs.size() == rowLen){
                visited[i] = 1;
                answer++;
            }
        }

        idxArr = new ArrayList<>();
        dfs(relation, 0, new ArrayList<>(), 0);
        chkMin();
        
        answer += (idxArr.size() - nonMin);

        return answer;
    }
    
    // 최소성 만족하는지 검사
    static void chkMin(){
        // 길이 순 정렬 (최소성을 만족하는 집합은 보통 앞에 있을 가능성이 높기 때문)
        idxArr.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.size() - o2.size();
            }
        });

        boolean[] visitedIdx = new boolean[idxArr.size()];  // 최소성을 만족하지 않는 집합 체크
        for (int i=0; i<idxArr.size(); i++){
            int[] cnt = new int[idxArr.size()];
            
            if (visitedIdx[i]) continue;
            for (int j=0; j<idxArr.get(i).size(); j++){
                 int num = idxArr.get(i).get(j);

                for (int k=i+1; k<idxArr.size(); k++){
                    if (visitedIdx[k]) continue;

                    for (int l=0; l<idxArr.get(k).size(); l++){
                        if (num == idxArr.get(k).get(l)){
                            cnt[k]++;
                        }
                    }
                }
            }

            for (int j=0; j<idxArr.size(); j++){
                if (cnt[j] >= idxArr.get(i).size()){  // 최소성을 만족하지 않는다면
                    visitedIdx[j] = true;
                    nonMin++;
                }
            }

        }
    }

    // dfs로 조합 생성
    static void dfs(String[][] relation, int cnt, ArrayList<Integer> idx, int nowIdx){
        if (cnt == columnLen){
            return;
        }

        for (int i=nowIdx; i<columnLen; i++){
            if (visited[i] == 1 || visited[i] == 2) continue;
            visited[i] = 2;
            idx.add(i);
            addColumnStr(relation, idx);

            dfs(relation, cnt+1, idx, i);

            visited[i] = 0;
            idx.remove(idx.size()-1);
        }
    }

    // Column에 해당하는 Row값들을 String으로 합치기
    static void addColumnStr(String[][] relation, ArrayList<Integer> idx){
        String[] strArr = new String[rowLen];

        for (int i=0; i<rowLen; i++){
            StringBuilder sb = new StringBuilder();
            for (Integer j : idx) {
                sb.append(relation[i][j]);
            }
            strArr[i] = sb.toString();
        }
        
        chkDuplication(strArr, idx);
    }

    // 유일성 확인
    static void chkDuplication(String[] strArr, ArrayList<Integer> idx){
        HashSet<String> hs = new HashSet<>();

        for (int i=0; i<rowLen; i++){
            if (!hs.contains(strArr[i])){
                hs.add(strArr[i]);
            } else{
                return;
            }
        }

        if (hs.size() == rowLen){
            ArrayList<Integer> al = new ArrayList<>(idx);
            idxArr.add(al);
        }
    }
}
