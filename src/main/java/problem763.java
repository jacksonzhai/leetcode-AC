

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class problem763 {

    public List<Integer> partitionLabels(String S) {
        List res = new ArrayList<Integer>();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++){
            map.put(S.charAt(i),i);
        }
        int start = 0,last = 0;
        for(int i = 0;i<S.length();i++){
            last = Math.max(last,map.get(S.charAt(i)));
            if(last==i){
                res.add(last - start+1);
                start = i;
                i = last+1;
            }


        }
        return res;
    }
}
