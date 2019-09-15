package name.kido.learn.encoding.main.core;

import name.kido.learn.encoding.main.enums.Encodings;
import name.kido.learn.encoding.main.ui.entity.SubCommand;

import java.util.List;

public class CharacterDecoder {

    /**
     * コマンド名
     * @return コマンド名
     */
    public String getCommandName() {
        return SubCommand.DECODE.getName();
    }

    /**
     * デコード<BR>
     * バイト列を指定のエンコーディングで文字列に変換する。
     * @param bytes バイト列（1要素1バイト）
     * @param enc エンコーディング
     * @return 文字列
     */
    public String decode(List<Byte> bytes, Encodings enc) {
        return EncodingPool.getInstance().getEncoding(enc).getDecoder().apply(bytes);
    }
}
