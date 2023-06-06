class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delivery = 0;
        int pickup = 0;
        
        //가장 먼 곳의 집부터 배달하고 수거하면 된다
        //겹치는 동선이 없으니까 최소임
        
        
        //가장먼곳에 수거할 박스 수와 배달할 박스수를 생각하고
        //cap 만큼 빼준다. 이것은 물류창고에서 집까지 한 번 왕복 했다는 뜻이다.
        //배달을 하고 수거를 하면 되기 때문에 한 번 왕복에 배달하고 수거까지 같이 된다.
        
        
        for(int i = n-1; i >= 0; i--){
            delivery += deliveries[i];// 배달할 택배 수와 수거할 박스 수 저장
            pickup += pickups[i];
            
            while(delivery > 0 || pickup > 0){// 0보다 작을 때 까지 반복
                delivery -= cap;// 왕복 한번 할 때 마다 cap 만큼 빼준다.
                pickup -= cap;// 수거도 마찬가지
                answer += (i+1) * 2;// 왕복이니까 거리 *2 해준다.
            }
            
            // 머리를 스치는 의문 왜 0보다 작을 때 일까? 왜냐하면
            // 우선 가장 먼곳 부터 배달하고 수거한다는 사실을 기억하라
            // 그말은 가장 먼곳에서 cap 만큼 배달이 필요하지 않는 상황이라면 그 곳 까지 가기 전에 있는 집에
            // 배달 할 수 있다. 그리고 우리는 최소 거리를 구하기 때문에 배달 할 수 있으면 하는게 좋다.
            
            // 수거도 마찬가지이다. 그러므로
            
            // delivery와 pickup이 마이너스가 되는것은 앞에 집에 배달을하고 수거를 한다는 뜻으로 받아들이면
            // for문의 흐름을 볼 때 어색하지 않게 이어지게 된다.
            // for 문은 끝에 집(n-1)에서부터 첫 번째 집(0)를 순차적으로 처리하기 때문에
        }
        
        return answer;
    }
}