package name.kido.learn.encoding.main.core;

import name.kido.learn.encoding.main.entity.encoding.ASCII;
import name.kido.learn.encoding.main.enums.Encodings;
import name.kido.learn.encoding.main.interfaces.CharacterEncoding;

import java.util.HashMap;
import java.util.Map;

public class EncodingPool {

    // シングルトン
    private static EncodingPool instance = new EncodingPool();
    public static EncodingPool getInstance() { return instance; }

    // エンコード一覧
    Map<Encodings, CharacterEncoding> pool = new HashMap<>();

    // TODO: ハードコーディングいくない
    private EncodingPool () {
        CharacterEncoding ASCII = new ASCII();
        pool.put(ASCII.getName(), ASCII);
    }

    CharacterEncoding getEncoding (Encodings enc) {
        return pool.get(enc);
    }
}
