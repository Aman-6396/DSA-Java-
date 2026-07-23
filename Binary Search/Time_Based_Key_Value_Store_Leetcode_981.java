import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Time_Based_Key_Value_Store_Leetcode_981 {
    class TimeMap {
        HashMap<String, List<String[]>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            List<String[]> ll = map.getOrDefault(key, new ArrayList<>());
            String[] arr = new String[2];
            arr[0] = value;
            arr[1] = "" + timestamp;
            ll.add(arr);
            map.put(key, ll);
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) {
                return "";
            }
            List<String[]> ll = map.get(key);
            int left = 0;
            int right = ll.size() - 1;
            StringBuilder sb = new StringBuilder();
            while (left <= right) {
                int mid = left + (right - left) / 2;
                String[] arr = ll.get(mid);
                if (Integer.parseInt(arr[1]) <= timestamp) {
                    sb.replace(0, sb.length(), arr[0]);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return sb.toString();
        }
    }
}
