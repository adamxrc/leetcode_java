public class Solution extends Reader4 {
  private char[] buffer = new char[4];  
  int offset = 0;   
  int bufsize = 0; 
  
  public int read(char[] buf, int n) {
    int readBytes = 0;
    boolean lessThan4 = false;
    int bytes = 0;
    
    while(!lessThan4 && readBytes < n) {
      if(bufsize == 0) {
        bufsize = read4(buffer);
        lessThan4 = bufsize < 4;
      }  
      bytes = Math.min(n-readBytes, bufsize);
      for(int i = 0; i < bytes; i++)
        buf[readBytes+i] = buffer[offset+i];
      offset = (offset+bytes) % 4;
      bufsize -= bytes;
      readBytes += bytes;
    }
    
    return readBytes;
  }
}
