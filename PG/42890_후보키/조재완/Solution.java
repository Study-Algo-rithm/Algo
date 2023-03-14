import java.util.*;

class Solution {
    
    static String[][] S_relation;
    static LinkedList<String> list;
    
    public int solution(String[][] relation) {
        S_relation = relation;
        
        list = new LinkedList<>();
        
        for(int i = 1; i <= relation[0].length; i++){
            int[] selected = new int[relation[0].length];
            dfs(0,0,i,selected);
        }
        
        return list.size();

    }
    
    public static void dfs(int idx, int cnt, int max, int[] selected){
        if(cnt == max){
            String col = "";
            for(int i = 0;i < selected.length; i++){
                if(selected[i] == 1){
                    col += i;
                }
            }
            if(check(col,selected)){
                list.add(col);
            }
            return;
        }
        
        if(idx>=selected.length){
            return;
        }
        
        selected[idx] = 1;
        dfs(idx + 1, cnt + 1, max, selected);
        
        selected[idx] = 0;
        dfs(idx + 1, cnt, max, selected);
    }
    
    public static boolean check(String col, int[] selected){
        for(String s : list){// 후보키를 다 돌아봄
            boolean flag = true;
            for(int i = 0; i < s.length();i++){//한 후보키에 속한 컬럼들을 다 돌아봄
                if(!col.contains(s.charAt(i)+"")){//하나라도 포함하지 않으면 false// 즉 모두 포함 하고 있으면 true로 flag에 저장된다.
                    flag = false;
                }
            }
            
            if(flag){//한 후보키의 모든 칼럼이 포함되어 있으면 이친구는 최소성을 만족하지 않는다.
                return false;
            }
        }
        
        List<String> values = new LinkedList<>();
        int[] col_name = new int [col.length()];
        int idx = 0;
        for(int i = 0; i < selected.length; i++){
            if(selected[i] == 1){
                col_name[idx++] = i;
            }
        }// col을 배열로 만들고
        
        String value = "";
        for(int i = 0; i < S_relation.length; i++){
            value = "";
            for(int j = 0; j < col_name.length; j++){
                value += S_relation[i][col_name[j]];// i : 각각의 릴레이션 // j : col이 가진 속성들의 인덱스// value 그 속성값들을 문자열로 저장
            }
            if(values.contains(value)){//중복되는 값 확인
                return false;
            }else{
                values.add(value);// 없으면 추가
            }
        }
        return true;
    }
}