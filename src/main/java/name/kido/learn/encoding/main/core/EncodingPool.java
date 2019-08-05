package name.kido.learn.encoding.main.core;

import name.kido.learn.encoding.main.entity.encoding.ASCII;
import name.kido.learn.encoding.main.enums.Encodings;
import name.kido.learn.encoding.main.interfaces.CharacterEncoding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class EncodingPool {

    // シングルトン
    private static EncodingPool instance = new EncodingPool();
    public static EncodingPool getInstance() { return instance; }

    // エンコード一覧
    Map<Encodings, CharacterEncoding> pool = new HashMap<>();

    // 一覧ファイルに記載されたクラスを読み込む
    // お手製DI！
    private EncodingPool () {

        try (BufferedReader br = new BufferedReader(new FileReader(new File("src/main/resources/di/classes_encoding.txt")))) {

            String line;
            while ((line = br.readLine()) != null) {
                Class<?> clazz = Class.forName(line);
                CharacterEncoding instance = (CharacterEncoding) clazz.getDeclaredConstructor().newInstance();
                pool.put(instance.getName(), instance);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    CharacterEncoding getEncoding (Encodings enc) {
        return pool.get(enc);
    }

}
