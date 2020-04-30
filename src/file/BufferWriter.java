package file;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class BufferWriter {
  public static void main(String[] args) throws Exception{
      // 追加模式
      BufferedWriter bfr = new BufferedWriter(
              new OutputStreamWriter(new FileOutputStream("g:/file/hello.txt",true)));
      bfr.write("hah");
      bfr.close();
  }
}
