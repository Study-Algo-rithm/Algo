        
import java.math.*;
class Solution {
    public long solution(int w, int h) {
        BigInteger W=BigInteger.valueOf(w);
        BigInteger H=BigInteger.valueOf(h);
        
        int gcd=W.gcd(H).intValue(); //최대공약수
        long total=(long)w*(long)h; //전체 직사각형 수
        int except=(w/gcd)+(h/gcd)-1; //패턴에서 제외되는 직사각형 수
        
        return total-(except*gcd);
    }
}