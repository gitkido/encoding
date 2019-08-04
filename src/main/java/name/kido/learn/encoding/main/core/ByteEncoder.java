package name.kido.learn.encoding.main.core;

import name.kido.learn.encoding.main.enums.Encodings;

import java.util.List;

public class ByteEncoder {

    /**
     * エンコード<BR>
     * 文字列を指定のエンコーディングでバイト列に変換する。
     * @param str 文字列
     * @param enc エンコーディング
     * @return バイト列
     */
    List<Byte> encode(String str, Encodings enc) {
        return EncodingPool.getInstance().getEncoding(enc).getEncoder().apply(str);
    }

}
