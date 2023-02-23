function solution(n){
    return calculation(n);
}
const calculation=(n)=>{
    //dp를 위한 배열을 만들어 놓는다. 0으로 초기화 한다.
    const dp = new Array(n+1).fill(0);
    //0은 1로 그냥 설정 해 놓고. 계산 해 보니까 0인 경우 1이어야 값이 맞네,,
    dp[0]=1;
    //1은 어짜피 경우의 수가 1밖에 없으니까 1로 둔다.
    dp[1]=1;
    for(let i=2;i<=n;i++){
        //재귀함수 때부터 생각 했던건데
        //만약 가로로 눕혀진 게 채워진다면 n-1개를 시작점으로 보고 선택해야 하니까 i-1의 갯수를 선택해야 하고
        //선택한 애 때문에 1개가 못쓰일 수도 있으니까 i-2의 갯수를 선택하는 방법도 포함 돼야 한다.
        dp[i]=(dp[i-2]+dp[i-1])%1000000007;
    }
    //n개인 경우의 계산값을 return
    return dp[n];
}
solution(4);