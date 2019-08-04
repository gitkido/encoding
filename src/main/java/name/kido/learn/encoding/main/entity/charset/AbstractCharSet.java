package name.kido.learn.encoding.main.entity.charset;

import name.kido.learn.encoding.main.enums.CharSets;
import name.kido.learn.encoding.main.interfaces.CharacterSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 符号化文字集合 抽象クラス
 */
abstract class AbstractCharSet implements CharacterSet {

    abstract public CharSets getName();

    Map<List<Byte>, String> chars;

    @Override
    public Map<List<Byte>, String> getChars() {
        return chars;
    }

    @Override
    public String getChar(List<Byte> bytes) {
        // nullを許容したいのでラッパークラス
        String ch = chars.get(bytes);
        if (ch != null) {
            return ch;
        } else {
            // "�"
            return "\uFFFD";
        }
    }

    /**
     * ラッパーメソッド
     * usage: getChar(0b00010001); getChar(0x11);
     * @param bytes 符号
     * @return 符号に対応する文字
     */
    public String getChar(int... bytes) {
        List<Byte> byteArray = new ArrayList<>();
        for (int byteCode : bytes) {
            byteArray.add((byte)byteCode);
        }
        return getChar(byteArray);
    }

}
