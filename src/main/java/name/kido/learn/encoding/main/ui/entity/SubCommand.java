package name.kido.learn.encoding.main.ui.entity;

/**
 * サブコマンド
 */
public enum SubCommand {
    ENCODE("encode"),
    DECODE("decode"),
    CONVERT("convert"),
    EXIT("exit");

    String name;

    public String getName () {
        return this.name;
    }

    SubCommand (String name) {
        this.name = name;
    }

    /**
     * @param name サブコマンド名
     * @return 存在するサブコマンド名ならtrue
     */
    public static boolean contains (String name) {
        for (SubCommand command : SubCommand.values()) {
            if (command.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
