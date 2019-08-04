package name.kido.learn.encoding.main.entity.encoding;

import name.kido.learn.encoding.main.enums.CharSets;
import name.kido.learn.encoding.main.enums.Encodings;
import name.kido.learn.encoding.main.interfaces.CharacterEncoding;

import java.util.List;
import java.util.function.Function;

public class ASCII implements CharacterEncoding {

    name.kido.learn.encoding.main.entity.charset.ASCII charset = new name.kido.learn.encoding.main.entity.charset.ASCII();

    @Override
    public Encodings getName() { return Encodings.ASCII; }

    @Override
    public CharSets[] getTargetCharSet() { return new CharSets[]{CharSets.ASCII}; }

    @Override
    public Function<String, List<Byte>> getEncoder() {
        // TODO: 実装する
        return null;
    }

    @Override
    public Function<List<Byte>, String> getDecoder() {

        // 対応する符号位置の文字に1バイトずつ置き換えるだけ。
        return bytes -> {

            StringBuilder str = new StringBuilder();

            for (byte byteCode : bytes) {
                str.append(charset.getChar(byteCode));
            }

            return str.toString();
        };
    }
}
