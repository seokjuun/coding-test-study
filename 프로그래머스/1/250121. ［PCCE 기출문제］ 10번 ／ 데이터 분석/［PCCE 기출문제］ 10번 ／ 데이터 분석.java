import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        
        List<int[]> list = new ArrayList<>();
        
        switch(ext){
            case "code":
                Arrays.sort(data, (a,b)-> Integer.compare(a[0],b[0]));
                for(int[] da : data){
                    if(da[0] >= val_ext) break;
                    list.add(da);
                }
                break;
                
            case "date":
                Arrays.sort(data, (a,b)-> Integer.compare(a[1],b[1]));
                for(int[] da : data){
                    if(da[1] >= val_ext) break;
                    list.add(da);
                }
                break;
                
            case "maximum":
                Arrays.sort(data, (a,b)-> Integer.compare(a[2],b[2]));
                for(int[] da : data){
                    if(da[2] >= val_ext) break;
                    list.add(da);
                }
                break;
                
            case "remain":
                Arrays.sort(data, (a,b)-> Integer.compare(a[3],b[3]));
                for(int[] da : data){
                    if(da[3] >= val_ext) break;
                    list.add(da);
                }
                break;
        }
        
        switch(sort_by){
            case "code":
                list.sort((a,b)-> Integer.compare(a[0],b[0]));
                break;
                
            case "date":
                list.sort((a,b)-> Integer.compare(a[1],b[1]));
                break;
                
            case "maximum":
                list.sort((a,b)-> Integer.compare(a[2],b[2]));
                break;
                
            case "remain":
                list.sort((a,b)-> Integer.compare(a[3],b[3]));
                break;
        }
        
        int[][] answer = new int[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }

}