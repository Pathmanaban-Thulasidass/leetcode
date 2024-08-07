public class Solution {

    String[] suffix = {\\, \Thousand\, \Million\, \Billion\};
    HashMap<Integer, String> ones_map = new HashMap<>();
    HashMap<Integer, String> tens_map = new HashMap<>();

    public Solution() {
        // Initialize ones_map
        ones_map.put(1, \One\);
        ones_map.put(2, \Two\);
        ones_map.put(3, \Three\);
        ones_map.put(4, \Four\);
        ones_map.put(5, \Five\);
        ones_map.put(6, \Six\);
        ones_map.put(7, \Seven\);
        ones_map.put(8, \Eight\);
        ones_map.put(9, \Nine\);
        ones_map.put(10, \Ten\);
        ones_map.put(11, \Eleven\);
        ones_map.put(12, \Twelve\);
        ones_map.put(13, \Thirteen\);
        ones_map.put(14, \Fourteen\);
        ones_map.put(15, \Fifteen\);
        ones_map.put(16, \Sixteen\);
        ones_map.put(17, \Seventeen\);
        ones_map.put(18, \Eighteen\);
        ones_map.put(19, \Nineteen\);

        // Initialize tens_map
        tens_map.put(20, \Twenty\);
        tens_map.put(30, \Thirty\);
        tens_map.put(40, \Forty\);
        tens_map.put(50, \Fifty\);
        tens_map.put(60, \Sixty\);
        tens_map.put(70, \Seventy\);
        tens_map.put(80, \Eighty\);
        tens_map.put(90, \Ninety\);
    }

    public String numberToWords(int num) {
        if (num == 0)
            return \Zero\;

        StringBuffer sb = new StringBuffer(\\);

        for (int i = 0; i < 4; i++) {
            int chunk = num % 1000;
            if (chunk != 0) {
                String chunkStr = convertChunk(chunk);
                if (sb.length() > 0) {
                    sb.insert(0, \ \);
                }
                sb.insert(0, chunkStr + (suffix[i].isEmpty() ? \\ : \ \ + suffix[i])  );
            }
            num /= 1000;
        }
        return sb.toString().trim();
    }

    private String convertChunk(int num) {
        StringBuffer chunk = new StringBuffer();
        int hundred = num / 100;
        int remainder = num % 100;

        if (hundred != 0) {
            chunk.append(ones_map.get(hundred)).append(\ Hundred\);
            if (remainder != 0) {
                chunk.append(\ \);
            }
        }

        if(remainder != 0) {
            if (remainder < 20) {
                chunk.append(ones_map.get(remainder));
            } else {
                int tens = remainder / 10;
                int ones = remainder % 10;
                chunk.append(tens_map.get(tens  * 10));
                if (ones != 0) {
                    chunk.append(\ \).append(ones_map.get(ones));
                }
            }
        }

        return chunk.toString();
    }
}