import java.util.*;
public class NQueens {
    public List<List<String>> totalNQueens(int n) {
        int[] a = new int[n+1];
        a[n] = 0;
        List<List<String>> result = new ArrayList<>();
        helper(0,n,a,result);

        return result;

    }
    public void helper(int row,int N,int[] a,List<List<String>> re){
        if(row == N){
            a[N] = a[N]+1 ;
            re.add(array2ListString(a));
            return;
        }
        for(int i = 0;i<N;i++){
            a[row] = i;
            if(check(row,a)){
                helper(row+1,N,a,re);

            }
        }


    }
    public boolean check(int c,int[] a){
        int k=0;
        while (k<c) {
            if (Math.abs(c - k) == Math.abs(a[c] - a[k]) || (a[c] - a[k]) == 0) {
                return false;
            }
            k++;
        }
        return true;
    }

    public List<String>  array2ListString(int[] a){
        List<String> re = new ArrayList<>();
        int rowSize = a.length-1;
        for(int i = 0;i<rowSize;i++){
            re.add(int2StringWithDaoQ(a[i],rowSize));
        }
        return re;
    }
    public String  int2StringWithDaoQ(int value,int length){
        String item = new String(new char[length]).replace('\0','.');
        StringBuilder sb = new StringBuilder(item);
        sb.setCharAt(value,'Q');
        return sb.toString();

    }

}
