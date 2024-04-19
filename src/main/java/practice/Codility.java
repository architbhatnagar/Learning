package practice;

public class Codility {

    public int[] solution(int[] a, int k) {
        // Implement your solution here
        int n=a.length;
        if(n==0 || k==0 || k==n){
            return a;
        }
        k=k%n;
        swap(a,0,n-k-1);
        swap(a,n-k,n-1);
        swap(a,0,n-1);
        return a;

    }

    public void swap(int[] a,int l,int h){
        while(l<h){
            int temp= a[l];
            a[l++]=a[h];
            a[h--]=temp;
        }
    }

    public int frogCrossing(int X, int[] A) {
        // Implement your solution here
        int t=-1;
        boolean[] visit=new boolean[X+1];
        for(int x: A){
            t++;
            if(!visit[x]){
                visit[x]=true;
                X--;
                if(X==0){
                    return t;
                }
            }
        }
        return X==0 ? t :-1;
    }

    public int[] DNA(String S, int[] P, int[] Q) {
        // Implement your solution here
        int N = S.length();
        int M = P.length;
        int[][] p = new int[4][N + 1];
        for (int i = 0; i < N; i++) {
            char c=S.charAt(i);
            int val=getImpactFactor(c);
            for (int j = 0; j < 4; j++) {
                p[j][i + 1] = p[j][i] + (j == (val-1) ? 1 : 0);
            }

        }
        int[] res = new int[M];
        for (int i = 0; i < M; i++) {
            int start = P[i];
            int end = Q[i] + 1;
            for (int j = 0; j < 4; j++) {
                if (p[j][end] - p[j][start] > 0) {
                    res[i] = j + 1;
                    break;
                }
            }
        }
        return res;
    }

    private int getImpactFactor(char nucleotide) {
        switch (nucleotide) {
            case 'A': return 1;
            case 'C': return 2;
            case 'G': return 3;
            case 'T': return 4;
            default: return -1;
        }
    }
}
