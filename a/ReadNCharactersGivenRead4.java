/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int idx = 0;
        boolean endOfFiles = false;
        
        while (idx < n && !endOfFiles) {
            int currReadBytes = read4(buffer);
            if (currReadBytes < 4) {
                endOfFiles = true;
            }
            
            int length = Math.min(n - idx, currReadBytes);
            for (int i = 0; i < length; i++) {
                buf[idx + i] = buffer[i];
            }
            idx += length;
        }
        
        return idx;
    }
}
