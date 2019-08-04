package name.kido.learn.encoding.main.entity.charset;

import name.kido.learn.encoding.main.enums.CharSets;
import name.kido.learn.encoding.main.interfaces.CharacterSet;

/**
 * 符号化文字集合: JIS X 0201
 */
public class JIS_X_0201 extends AbstractCharSet {

    @Override
    public CharSets getName() {
        return CharSets.JIS_X_0201;
    }

    public JIS_X_0201 () {
        //TODO: 文字集合の初期化処理
    }
}
