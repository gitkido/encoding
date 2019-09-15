package name.kido.learn.encoding.main.ui.util;

public class ErrorHandler {

    protected static final String NEWLINE = System.lineSeparator();

    /**
     * エラーを発生させる。
     * @throws IllegalArgumentException
     */
    public void error() throws IllegalArgumentException {
        throw new IllegalArgumentException(
                "command invalid!" + NEWLINE
                + "usage:" + NEWLINE
                + "    encode [-hex|bin] {encoding} {string}" + NEWLINE
                + "    decode [-hex|bin] {encoding} {string}" + NEWLINE
                + "    convert {encoding(from)} {encoding(to)} {string}" + NEWLINE
                + "    [exit|quit|bye]"
        );
    }

}
