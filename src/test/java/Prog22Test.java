import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.*;

public class Prog22Test {

   @Test
   public void testStandardInputs()
   {
       PrintStream originalOut = System.out;
       ByteArrayOutputStream bos = new ByteArrayOutputStream();
       System.setOut(new PrintStream(bos));

       StandardInputStream in = new StandardInputStream();
       System.setIn(in);

       // action
       in.inputln("1309");
       Prog22.main(null);

       // assertion
       String[] prints = bos.toString().split("\n");
       assertEquals("1309を2で割った余りは1です", prints[prints.length - 1]);

       // undo the binding in System
       System.setOut(originalOut);
       System.setIn(new BufferedInputStream(new FileInputStream(FileDescriptor.in)));
   }
}
