package name.kido.learn.encoding.main.interfaces;

import name.kido.learn.encoding.main.enums.CharSets;
import name.kido.learn.encoding.main.enums.Encodings;

import java.util.function.Function;

/**
 * 文字符号化方式
 */
public interface CharacterEncoding {

    /**
     * 名前取得
     * @return 符号化方式の名前
     */
    Encodings getName();

    /**
     * 文字集合取得<BR>
     *     符号化方式が使用する文字集合の列挙子を取得する。
     * @return 文字集合（列挙型）
     */
    CharSets[] getCharSet();

    /**
     * エンコーダ取得
     * @return エンコーダ関数
     */
    Function<char[], byte[]> getEncoder();

    /**
     * デコーダ取得
     * @return デコーダ関数
     */
    Function<byte[], char[]> getDecoder();

}
