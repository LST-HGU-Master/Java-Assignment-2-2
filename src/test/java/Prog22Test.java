import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.*;

public class Prog22Test {
    InputStream originalIn;
    PrintStream originalOut;
    ByteArrayOutputStream bos;
    StandardInputStream in;
    
    @BeforeEach
    void before() {
       //back up binding
       originalIn  = System.in;
       originalOut = System.out;
       //modify binding
       bos = new ByteArrayOutputStream();
       System.setOut(new PrintStream(bos));
        
       in = new StandardInputStream();
       System.setIn(in);
    }
    
    @AfterEach
    void after() {
       System.setOut(originalOut);
       // System.setIn(new BufferedInputStream(new FileInputStream(FileDescriptor.in)));
       System.setIn(originalIn);
    }

    @Test
    public void testFirstSentence()
    {
       // action
       in.inputln("3"); // any string is OK
       Prog22.main(null);

       // assertion
       String[] prints = bos.toString().split(System.lineSeparator());
       try {
            assertEquals("整数を入力してください", prints[0]);
       }catch (AssertionError e){
            after();
            throw e;
       }
    }

    @Test
    public void testSecondSentence()
    {
       // action
       String kbIn = "5";
       int modu = 5;
       in.inputln(kbIn);
       Prog22.main(null);

       // assertion
       String[] prints = bos.toString().split(System.lineSeparator());
       assertEquals(kbIn + "を" + modu +"で割った余りは" + (Integer.parseInt(kbIn) % modu) +"です", prints[1]);

       // if (prints.length == 2) {
           // assertEquals(kbIn + "を2で割った余りは" + (Integer.parseInt(kbIn) % 2) +"です", prints[1]);
       // }
       // else { // as no LF expected, test second printed line ... further consideration required 
           // String afterPromptWord = prints[0].substring(11);
           // assertEquals(kbIn + "を2で割った余りは" + (Integer.parseInt(kbIn) % 2) +"です",afterPromptWord);
       // }

    }
}
