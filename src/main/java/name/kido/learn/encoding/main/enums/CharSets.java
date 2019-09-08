package name.kido.learn.encoding.main.enums;

/**
 * 符号化文字集合（列挙型）
 */
public enum CharSets {
    ASCII,
    JIS_X_0201,
    JIS_X_0208,
    JIS_X_0212,
    Unicode;

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