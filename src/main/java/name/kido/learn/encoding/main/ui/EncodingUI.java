package name.kido.learn.encoding.main.ui;

import name.kido.learn.encoding.main.core.CharacterDecoder;
import name.kido.learn.encoding.main.core.CharacterEncoder;
import name.kido.learn.encoding.main.enums.Encodings;
import name.kido.learn.encoding.main.ui.entity.CommandOption;
import name.kido.learn.encoding.main.ui.util.CommandLine;
import name.kido.learn.encoding.main.ui.util.CommandLineParser;
import name.kido.learn.encoding.main.ui.util.ErrorHandler;
import name.kido.learn.encoding.main.ui.util.OutputPrinter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * エンコーディングシェル (UI)
 */
public class EncodingUI {

    static final String PROMPT = "> ";

    static ErrorHandler err = new ErrorHandler();
    static CharacterEncoder encoder = new CharacterEncoder();
    static CharacterDecoder decoder = new CharacterDecoder();
    static OutputPrinter printer = new OutputPrinter();

    public static void main (String[] args) {

        System.out.println("***********************");
        System.out.println("Encoding Shell ver. 0.1");
        System.out.println("***********************");

        CommandLineParser parser = new CommandLineParser();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                System.out.print(PROMPT);
                String line = br.readLine();

                CommandLine commandLine;

                // 入力行を解析
                if (line != null) {
                    try {
                        commandLine = parser.parse(line);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                } else {
                    // EOFなら終了
                    break;
                }

                // 空行はとばす
                if (commandLine.isEmpty()) continue;

                // 終了判定
                if (commandLine.isExit()) {
                    System.out.println("Good Bye!");
                    break;
                }

                // コマンド実行
                try {
                    executeCommand(commandLine);
                } catch (IllegalArgumentException e) {
                    // 構文エラーの場合はメッセージを出力して続行
                    System.out.println(e.getMessage());
                    continue;
                }
            }

            //TODO: あとでけす
//            while (true) {
//                System.out.print(PROMPT);
//                String line = br.readLine();
//
//                List<String> tokens;
//
//                // 入力行をトークンに分割
//                if (line != null) {
//                    tokens = splitIntoTokens(line);
//                } else {
//                    // EOFで終了
//                    break;
//                }
//
//                // 空行はとばす
//                if (tokens.size() == 0) continue;
//
//                // 終了判定
//                if (tokens.size() == 1 && TERMINATOR.contains(tokens.get(0))) {
//                    System.out.println("Good Bye!");
//                    break;
//                }
//
//                // コマンドを解析して実行
//                try {
//                    executeCommand(tokens);
//                } catch (IllegalArgumentException e) {
//                    // 構文エラーの場合はメッセージを出力して続行
//                    System.out.println(e.getMessage());
//                }
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

    /**
     * コマンドを実行する。
     * @param command コマンドライン
     * @throws IllegalArgumentException 構文不正
     */
    static void executeCommand(CommandLine command) {

        if (command.getSubCommand().equals(encoder.getCommandName())) {
            // encodeコマンド

            // 引数の数チェック
            if (command.getArguments().size() != 2) err.error();

            // エンコーディング取得
            Encodings enc = Encodings.getByName(command.getArguments().get(0));
            if (enc == null) err.error();

            // エンコード
            List<Byte> encoded;
            try {
                encoded = encoder.encode(command.getArguments().get(1), enc);
            } catch (IllegalArgumentException e) {
                throw e;
            }

            // 出力
            if (command.getOptions().contains(CommandOption.TO_BIN.getName())) {
                // 2進
                printer.printBytesToBinary(encoded);
            } else if (command.getOptions().contains(CommandOption.TO_HEX.getName())) {
                // 16進
                printer.printBytesToHex(encoded);
            } else {
                // 無指定 (JavaのtoString()結果)
                System.out.println(encoded);
            }

        } else if (command.getSubCommand().equals(decoder.getCommandName())) {
            //TODO: 未実装
            System.out.println("sorry, this command is not implemented yet.");
        } else {
            //TODO: converterは未実装
            err.error();
        }

    }

//    /**
//     * コマンドラインを解析して実行する。
//     * @param commands コマンドライン
//     * @throws IllegalArgumentException 構文不正
//     */
//    static void executeCommand(List<String> commands) {
//
//        //TODO: 引数の解析。ここはスタブ実装。
//        if (commands.size() != 3) error(); //validation
//        String subcommand = commands.get(0);
//        String encodingStr = commands.get(1);
//        String targetStr = commands.get(2);
//
//        // エンコーディング取得
//        Encodings enc = Encodings.getByName(encodingStr);
//        if (enc == null) error();
//
//        // コマンド実行
//        // (より柔軟に作ることもできるが、コマンド数も増えないだろうからこのままでいいかな・・・。)
//        if (subcommand.equals(encoder.getCommandName())) {
//            System.out.println(encoder.encode(targetStr, enc));
//        } else if (subcommand.equals(decoder.getCommandName())) {
//            //TODO:未実装
//            System.out.println("sorry, this command is not implemented yet.");
//        } else {
//            error();
//        }
//    }

}
