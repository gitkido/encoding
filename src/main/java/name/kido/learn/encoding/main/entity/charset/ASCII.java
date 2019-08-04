package name.kido.learn.encoding.main.entity.charset;

import name.kido.learn.encoding.main.enums.CharSets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 符号化文字集合: ASCII
 */
public class ASCII extends AbstractCharSet {

    @Override
    public CharSets getName() {
        return CharSets.ASCII;
    }

    ASCII () {
        // 外部定義ファイルから文字一覧を読み込む
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/charset/ASCII.txt")))) {

            // 符号表初期化
            chars = new HashMap<>();

            String character;
            byte codePoint = 0b00100001; // 符号の初期値

            // 文字に符号を付与
            while ((character = reader.readLine()) != null) {

                List<Byte> key = new ArrayList<>();
                key.add(codePoint);
                chars.put(key, character);

                codePoint = (byte)(codePoint + 0b00000001);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}