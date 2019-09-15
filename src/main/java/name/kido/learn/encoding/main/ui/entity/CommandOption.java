package name.kido.learn.encoding.main.ui.entity;

public enum CommandOption {

    TO_HEX("hex"),
    TO_BIN("bin");

    String name;

    public String getName () {
        return this.name;
    }

    CommandOption (String name) {
        this.name = name;
    }

    /**
     * @param name オプション名
     * @return 存在するオプション名ならtrue
     */
    public static boolean contains (String name) {
        for (CommandOption option : CommandOption.values()) {
            if (option.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

}
