package name.kido.learn.encoding.main.ui.util;

import name.kido.learn.encoding.main.ui.entity.CommandOption;
import name.kido.learn.encoding.main.ui.entity.SubCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * コマンドライン解析器
 */
public class CommandLineParser {

    /**
     * 終了コマンド
     * "exit", "quit", "bye" のいずれでも終了を可能とする。
     */
    // 簡易実装
    static final List<String> TERMINATOR = Arrays.asList("exit", "quit", "bye");

    static ErrorHandler err = new ErrorHandler();

    /** サブコマンド位置 */
    public static final int POS_SUBCOMMAND = 0;

    /**
     * コマンドを解析する。
     * @param line コマンド行
     * @return 解析済みコマンドライン
     */
    public CommandLine parse (String line) {

        // スペースごとに分割
        List<String> tokens = splitIntoTokens(line);

        // コマンドラインオブジェクト
        CommandLine command = new CommandLine(line);

        // 順々に読んでく。
        int cnt = 0;
        for (String token : tokens) {

            if (cnt == POS_SUBCOMMAND) {

                // サブコマンドを設定
                if (TERMINATOR.contains(token)) {
                    // exitコマンドのエイリアス解決
                    command.setSubCommand(SubCommand.EXIT.getName());
                } else {
                    command.setSubCommand(token);
                }

                // 不正なコマンドの場合エラー
                if (!SubCommand.contains(command.getSubCommand())) err.error();

            } else if (token.startsWith("-")) {

                // 「-」は除く
                String option = token.substring(1);
                // オプションを設定
                command.addOption(option);

                // 不正なコマンドの場合エラー
                if (!CommandOption.contains(option)) err.error();

            } else {
                // 引数を設定
                command.addArgument(token);
            }

            cnt++;
        }

        // 終了コマンドは引数／オプションが存在する場合エラー
        if (command.getSubCommand().equals(SubCommand.EXIT.getName())
            && (!command.getOptions().isEmpty() || !command.getArguments().isEmpty())) {
            err.error();
        }

        return command;
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

}
