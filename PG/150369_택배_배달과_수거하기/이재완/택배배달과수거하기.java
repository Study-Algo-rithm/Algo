import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int pickupIdx=Integer.MIN_VALUE; //수거를 시작한 집
        int pickupEIdx=Integer.MIN_VALUE; //여기까지 수거함
        int deliverIdx=Integer.MIN_VALUE; //배달을 시작한 집
        int deliverEIdx=Integer.MIN_VALUE; //여기까지 배달함
        boolean deliverUsed=false; //현재 가능한 만큼 배달했음
        boolean pickupUsed=false; //현재 가능한 만큼 수거했음
        boolean deliverZero=false; //배달 끝
        boolean pickupZero=false; //수거 끝
            
        //배열의 뒤에서 부터 탐색
        for(int i=n-1;i>=0;i--)
        {
            //현재 집에 배달할 것 있음 && 배달 가능
            if(deliveries[i]!=0&&!deliverUsed)
            {
                deliverIdx=i; //배달 시작한 집=현재 집
                deliverUsed=true; //배달 불가능 (밑에 for문을 통해 최대치만큼 배달할거임)
                int cap2=cap;
                //현재 집부터 배달 가능한 집들 거꾸로 탐색
                for(int j=deliverIdx;j>=0;j--)
                {
                    //j번째 집에 남은 배달>=화물차 용량
                    if(deliveries[j]>=cap2)
                    {
                        deliveries[j]-=cap2; //남은 거 전부 배달
                        deliverEIdx=j; //j번째 집까지 배달 중
                        break;
                    }
                    //j번째 집에 남은 배달<화물차 용량
                    else
                    {
                        cap2-=deliveries[j]; //j번째 집에 배달 (화물차에 다른 집 배달할 것 남음)
                        deliveries[j]=0; //j번째 집 배달 완료
                        deliverEIdx=0; //0번째 집까지 다 탐색함 (위의 break에 안 걸렸다면 유효) 
                    }
                }
            }
            
            //현재 집에 수거할 것이 있음 && 수거 가능
            if(pickups[i]!=0&&!pickupUsed)
            {
                pickupIdx=i; //수거 시작한 집=현재 집
                pickupUsed=true; //수거 불가능 (밑에 for문을 통해 최대치만큼 수거할거임)
                int cap2=cap;
                //현재 집부터 수거 가능한 집들 거꾸로 탐색
                for(int j=pickupIdx;j>=0;j--)
                {
                    //j번째 집에 남은 수거>=화물차 용량
                    if(pickups[j]>=cap2)
                    {
                        pickups[j]-=cap2; //최대한 수거(남은 화물차 용량만큼)
                        pickupEIdx=j; //j번째 집까지 수거 중
                        break;
                    }
                    else
                    {
                        cap2-=pickups[j]; //j번째 집 전부 수거
                        pickups[j]=0; //j번째 집 수거 완료
                        pickupEIdx=0; //0번째 집까지 다 탐색함 (위의 break에 안 걸렸다면 유효)
                    }
                }
            }
            
            //현재 가능한 만큼 배달했음 && 현재 가능한 만큼 수거했음
            if(deliverUsed&&pickupUsed)
            {
                int bigger=0; //이동 거리
                int biggerE=0; //다시 탐색 시작할 위치
                
                //수거 끝X && 배달 끝X    
                if(!pickupZero&&!deliverZero)
                {
                    bigger=Math.max(deliverIdx,pickupIdx); //배달과 수거 중 더 멀리간 집
                    biggerE=Math.max(deliverEIdx,pickupEIdx); //배달과 수저 중 더 가까이까지 완료한 집
                }
                //수거 끝X && 배달 끝O 
                else if(!pickupZero&&deliverZero)
                {
                    bigger=pickupIdx; //수거 시작한 집 (배달은 끝났으므로)
                    biggerE=pickupEIdx; //수거 완료 중인 집
                }
                //수거 끝O && 배달 끝X 
                else if(pickupZero&&!deliverZero)
                {
                    bigger=deliverIdx; //배달 시작한 집 (수거는 끝났으므로)
                    biggerE=deliverEIdx; //배달 완료 중인 집
                }
                //수거 끝O && 배달 끝O 
                else
                    break; //모두 끝났으므로, 반복문 탈출

                answer+=((bigger+1)*2); //이동거리 계산
                i=biggerE+1; //재탐색 위치 계산
                
                //배달: 첫 집까지 왔음 && 첫 집도 배달할 것 없음
                if(deliverEIdx==0&&deliveries[0]==0)
                    deliverZero=true; //배달 완료
                else
                    deliverUsed=false; //다시 배달 가능하게
                
                //수거: 첫 집까지 왔음 && 첫 집도 수거할 것 없음
                if(pickupEIdx==0&&pickups[0]==0)
                    pickupZero=true; //수거 완료
                else
                    pickupUsed=false; //다시 수거 가능하게
                
            }
        }
        return answer;
    }
}