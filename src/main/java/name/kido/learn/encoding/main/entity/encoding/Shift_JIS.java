package name.kido.learn.encoding.main.entity.encoding;

import name.kido.learn.encoding.main.enums.CharSets;
import name.kido.learn.encoding.main.enums.Encodings;
import name.kido.learn.encoding.main.interfaces.CharacterEncoding;

import java.util.function.Function;

/**
 * 文字符号化方式: Shift_JIS
 */
public class Shift_JIS implements CharacterEncoding {

    @Override
    public Encodings getName() {
        return Encodings.Shift_JIS;
    }

    @Override
    public CharSets[] getCharSet() {
        return new CharSets[]{ CharSets.JIS_X_0201, CharSets.JIS_X_0208 };
    }

    @Override
    public Function<char[], byte[]> getEncoder() {
        //TODO: エンコード処理
        return null;
    }

    @Override
    public Function<byte[], char[]> getDecoder() {
        //TODO: エンコード処理
        return null;
    }
}
