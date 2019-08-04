package name.kido.learn.encoding.main.entity.charset;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ASCIITest {

    @Test
    public void decodeBin() {

        String expected = "A";
        ASCII sut = new ASCII();

        assertThat(sut.getChar(0b01000001), is(expected));
    }

    @Test
    public void decodeHex() {

        String expected = "A";
        ASCII sut = new ASCII();

        assertThat(sut.getChar(0x41), is(expected));
    }
}
