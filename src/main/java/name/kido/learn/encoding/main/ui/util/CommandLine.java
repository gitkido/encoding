package name.kido.learn.encoding.main.ui.util;

import name.kido.learn.encoding.main.ui.entity.CommandOption;
import name.kido.learn.encoding.main.ui.entity.SubCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * コマンドライン
 */
public class CommandLine {

    /** コマンド列 */
    protected String commandLine;
    /** サブコマンド */
    protected String subCommand = "";
    /** オプション */
    protected List<String> options = new ArrayList<>();
    /** 引数*/
    protected List<String> arguments = new ArrayList<>();

    CommandLine (String commandLine) {
        this.commandLine = commandLine;
    }

//    /** 引数 */
//    protected String[] arguments = new String[3];
//
//    // 拡張性に欠けるなぁ・・・。
//    // だが、コマンド引数の形式がそもそも自由度が高いので、プログラム中で制限してやるしかないのか
//    /** 引数位置 エンコード#1 */
//    public static final int POS_ENCODING_1 = 0;
//    /** 引数位置 エンコード#2 */
//    public static final int POS_ENCODING_2 = 1;
//    /** 引数位置 入力データ */
//    public static final int POS_INPUT_DATA = 2;

    // getter
    public String getCommandLine() {
        return commandLine;
    }
    public String getSubCommand() {
        return subCommand;
    }
    public void setSubcommand(String subCommand) {
        this.subCommand= subCommand;
    }
    public List<String> getOptions() {
        return options;
    }
    public List<String> getArguments() {
        return arguments;
    }


//    public String[] getArguments() {
//        return arguments;
//    }

    // setter
    // parserだけがさわれるように、package privateとする
    void setSubCommand(String subCommand) {
        this.subCommand = subCommand;
    }
    void setOptions(List<String> options) {
        this.options = options;
    }
    void addOption(String option) {
        this.options.add(option);
    }
    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }
    public void addArgument(String argument) {
        this.arguments.add(argument);
    }

//    void setArguments(String argument, int position) {
//        if (!Arrays.asList(0, 1, 2).contains(position)) {
//            throw new IllegalArgumentException ();
//        } else {
//            this.arguments[position] = argument;
//        }
//    }

    /** コマンドラインが空の場合trueを返却する。 */
    public boolean isEmpty() {
        return commandLine.isEmpty();
    }

    /** 終了コマンドの場合trueを返却する。 */
    public boolean isExit() {
        return SubCommand.EXIT.getName().equals(subCommand);
    }
}
