import java.util.*;

class Solution {
    static ArrayList<FileSort> al;
    
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        al = new ArrayList<>();

        for (int i=0; i<files.length; i++){
            // Number 시작 idx, 끝 idx 구하기
            int[] numIdx = getNumberIdx(files[i]);
            int startNumIdx = numIdx[0];
            int endNumIdx = numIdx[1];

            String head, number;
            if (startNumIdx != -1){
                head = files[i].substring(0, startNumIdx).toLowerCase();
                number = files[i].substring(startNumIdx, endNumIdx);
            } 
            else{
                head = files[i].toLowerCase();
                number = "0";
            }
            
            FileSort fs = new FileSort(i, head, Integer.parseInt(number));
            al.add(fs);
        }
        Collections.sort(al);

        for (int i=0; i<al.size(); i++){
            int idx = al.get(i).idx;
            answer[i] = files[idx];
        }

        return answer;
    }

    static int[] getNumberIdx(String file){
        int startIdx = -1;
        int endIdx = -1;

        int size = 0;
        for(int i=0; i<file.length(); i++){
            char nowChar = file.charAt(i);
            if ('0' <= nowChar && nowChar <= '9'){
                if (startIdx == -1){
                    startIdx = i;
                }
                //endIdx = i+1;
                
                size++;
            } else if (startIdx != -1){
                break;
            }
        }
        
        if(size >5){
            endIdx = startIdx + 5;
        } else{
            endIdx = startIdx + size;
        }
        
        return new int[]{startIdx, endIdx};
    }
}

// 정렬하기 -> 이름순, 이름이 같다면 숫자 순
class FileSort implements Comparable<FileSort>{
    int idx;
    String head;
    int number;

    FileSort(int idx, String head, int number){
        this.idx = idx;
        this.head = head;
        this.number = number;
    }

    @Override
    public int compareTo(FileSort o) {
        if (!this.head.equals(o.head)){
            return this.head.compareTo(o.head);
        }
        return this.number - o.number;
    }
}
