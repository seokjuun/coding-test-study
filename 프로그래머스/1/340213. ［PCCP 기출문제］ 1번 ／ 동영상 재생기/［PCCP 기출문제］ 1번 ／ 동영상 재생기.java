class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int time = toSeconds(pos);
        int start = toSeconds(op_start);
        int end = toSeconds(op_end);
        int len = toSeconds(video_len);

        if (time >= start && time <= end) time = end;

        for (String command : commands) {
            if (command.equals("prev")) {
                time = Math.max(0, time - 10);
            } else { 
                time = Math.min(len, time + 10);
            }
            if (time >= start && time <= end) {
                time = end;
            }
        }

        return toTimeString(time);
    }

    private int toSeconds(String timeStr) {
        String[] parts = timeStr.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private String toTimeString(int time) {
        int minutes = time / 60;
        int seconds = time % 60;
        
        StringBuilder sb = new StringBuilder();
        
        if (minutes < 10) sb.append('0');
        sb.append(minutes);
        sb.append(':');

    
        if (seconds < 10) sb.append('0');
        sb.append(seconds);

        return sb.toString(); 
    }
}