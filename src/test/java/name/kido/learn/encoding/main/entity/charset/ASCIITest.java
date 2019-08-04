package name.kido.learn.encoding.main.entity.charset;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ASCIITest {

    @Test
    public void 文字を2進数指定で取得できる() {

        String expected = "A";
        ASCII sut = new ASCII();

        assertThat(sut.getChar(0b01000001), is(expected));
    }

    @Test
    public void 文字を16進数指定で取得できる() {

        String expected = "A";
        ASCII sut = new ASCII();

        assertThat(sut.getChar(0x41), is(expected));
    }
}
