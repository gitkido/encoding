package name.kido.learn.encoding.main.core;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import name.kido.learn.encoding.main.enums.Encodings;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ByteEncoderTest {

    ByteEncoder sut = new ByteEncoder();

    @Test
    public void ASCIIの1文字をエンコードできる() {

        List<Byte> expected = Arrays.asList((byte)0b01000001);

        List<Byte> actual = sut.encode("A", Encodings.ASCII);

        assertThat(actual, is(expected));

    }

    @Test
    public void ASCIIの文字列をエンコードできる() {

        List<Byte> expected = Arrays.asList(
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

        List<Byte> actual = sut.encode("Hello World!", Encodings.ASCII);

        assertThat(actual, is(expected));

    }

}
