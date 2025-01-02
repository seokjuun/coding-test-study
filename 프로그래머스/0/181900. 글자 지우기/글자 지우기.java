class Solution {
    public String solution(String my_string, int[] indices) {
        char[] arr_string = my_string.toCharArray();
        boolean[] check = new boolean[arr_string.length];
        StringBuilder sb = new StringBuilder();
        
        for(int i: indices){
            check[i] = true;
        }
        
        for(int i =0; i<arr_string.length; i++){
            if(!check[i]){
                sb.append(arr_string[i]);
            }
        }

        
        return sb.toString();
    }
}