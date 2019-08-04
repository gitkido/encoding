package name.kido.learn.encoding.main.interfaces;

import name.kido.learn.encoding.main.enums.CharSets;

import java.util.List;
import java.util.Map;

/**
 * 符号化文字集合
 */
public interface CharacterSet {

    /**
     * 名前取得
     * @return 文字集合の名前
     */
    CharSets getName();

    /**
     * 文字集合取得
     * @return 文字集合のMap&lt;コードポイント, 文字&gt;
     */
    Map<List<Byte>, String> getChars();

    /**
     * 文字取得
     * @param bytes コードポイント
     * @return コードポイントに対応する文字（対応がない場合は�(U+FFFD)）
     */
    String getChar(List<Byte> bytes);

    /**
     * コード値取得
     * @param character 文字
     * @return 文字に対応するコード値（対応がない場合はnull）
     */
    List<Byte> getCode(String character);
}
