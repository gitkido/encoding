package name.kido.learn.encoding.main.ui;

import name.kido.learn.encoding.main.core.CharacterDecoder;
import name.kido.learn.encoding.main.core.CharacterEncoder;
import name.kido.learn.encoding.main.enums.Encodings;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * エンコーディングシェル (UI)
 */
public class EncodingUI {

    static final List<String> TERMINATOR = Arrays.asList("exit", "quit", "bye");
    static final String PROMPT = "> ";

    static CharacterEncoder encoder = new CharacterEncoder();
    static CharacterDecoder decoder = new CharacterDecoder();

    public static void main (String[] args) {

        System.out.println("***********************");
        System.out.println("Encoding Shell ver. 0.1");
        System.out.println("***********************");

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                System.out.print(PROMPT);
                String line = br.readLine();

                List<String> tokens;

                // 入力行をトークンに分割
                if (line != null) {
                    tokens = splitIntoTokens(line);
                } else {
                    // EOFで終了
                    break;
                }

                // 空行はとばす
                if (tokens.size() == 0) continue;

                // 終了判定
                if (tokens.size() == 1 && TERMINATOR.contains(tokens.get(0))) {
                    System.out.println("Good Bye!");
                    break;
                }

                // コマンドを解析して実行
                try {
                    executeCommand(tokens);
                } catch (IllegalArgumentException e) {
                    // 構文エラーの場合はメッセージを出力して続行
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

    //TODO: コマンドラインの解析は別クラスに分離したほうがよさそう。

    /**
     * コマンドラインを解析して実行する。
     * @param commands コマンドライン
     * @throws IllegalArgumentException 構文不正
     */
    static void executeCommand(List<String> commands) {

        //TODO: 引数の解析。ここはスタブ実装。
        if (commands.size() != 3) error(); //validation
        String subcommand = commands.get(0);
        String encodingStr = commands.get(1);
        String targetStr = commands.get(2);

        // エンコーディング取得
        Encodings enc = Encodings.getByName(encodingStr);
        if (enc == null) error();

        // コマンド実行
        // (より柔軟に作ることもできるが、コマンド数も増えないだろうからこのままでいいかな・・・。)
        if (subcommand.equals(encoder.getCommandName())) {
            System.out.println(encoder.encode(targetStr, enc));
        } else if (subcommand.equals(decoder.getCommandName())) {
            //TODO:未実装
            System.out.println("sorry, this command is not implemented yet.");
        } else {
            error();
        }
    }

    /**
     * 行を解析してトークンのリストにて返す。
     */
    static List<String> splitIntoTokens(String line) {

        // スペースで分割
        List<String> split = new ArrayList<>(Arrays.asList(line.split(" +")));

        // 先頭の空白は削除
        if (split.get(0).equals("")) {
            split.remove(0);
        }

        return split;
    }

    /**
     * エラーを発生させる。
     * @throws IllegalArgumentException
     */
    static void error() throws IllegalArgumentException {
        throw new IllegalArgumentException("command invalid!" + System.lineSeparator() + "usage: encsh encode {encoding} {string}");
    }

}
