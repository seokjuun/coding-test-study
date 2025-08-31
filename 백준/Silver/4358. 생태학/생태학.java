
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int count=0;
        StringBuilder sb = new StringBuilder();
        TreeMap<String, Integer> map = new TreeMap<>();

        while ((str = br.readLine()) != null){
            if(str.isEmpty()) continue;
            map.put(str, map.getOrDefault(str, 0)+1);
            count++;
        }

        while (!map.isEmpty()){
            String name = map.firstKey();
            double rate = (double) map.get(map.firstKey()) / count *100;
            sb.append(name).append(" ").append(String.format("%.4f", rate)).append("\n");
            map.remove(map.firstKey());
        }

        System.out.println(sb);
    }
}
