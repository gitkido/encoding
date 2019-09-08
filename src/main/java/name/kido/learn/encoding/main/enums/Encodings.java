package name.kido.learn.encoding.main.enums;

/**
 * 文字符号化方式（列挙型）
 */
public enum Encodings {
    ASCII,
    UTF_8,
    Shift_JIS,
    EUC_JP,
    ISO_2022_JP;

    /**
     * 名前から逆引き
     * @param name エンコーディング名
     * @return エンコーディング。存在しない名前の場合はnull。
     */
    public static Encodings getByName(String name) {
        // 名前が一致するエンティティを返却
        for (Encodings encoding : Encodings.values()) {
            if (encoding.name().equals(name)) {
                return encoding;
            }
        }
        // ヒットしなかったらnullを返す
        return null;
    }
}
