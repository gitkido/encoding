package name.kido.learn.encoding.main.core;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import name.kido.learn.encoding.main.enums.Encodings;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CharacterDecoderTest {

    CharacterDecoder sut = new CharacterDecoder();

    @Test
    public void ASCIIの1文字をデコードできる() {

        String expected = "A";

        List<Byte> bytes = Arrays.asList((byte)0b01000001);
        String actual = sut.decode(bytes, Encodings.ASCII);

        assertThat(actual, is(expected));

    }

    @Test
    public void ASCIIの文字列をデコードできる() {

        String expected = "Hello World!";

        List<Byte> bytes = Arrays.asList(
                (byte)0x48, // H
                (byte)0x65, // e
                (byte)0x6c, // l
                (byte)0x6c, // l
                (byte)0x6f, // o
                (byte)0x20, // (SP)
                (byte)0x57, // W
                (byte)0x6f, // o
                (byte)0x72, // r
                (byte)0x6c, // l
                (byte)0x64, // d
                (byte)0x21 // !
        );
        String actual = sut.decode(bytes, Encodings.ASCII);

        assertThat(actual, is(expected));

    }
}
