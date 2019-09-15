package name.kido.learn.encoding.main.ui.util;

import java.util.List;

public class OutputPrinter {

    /**
     * 16進出力
     * @param bytes バイト列
     */
    public void printBytesToHex(List<Byte> bytes) {

        for (Byte val : bytes) {
            System.out.print(Integer.toHexString(val));
            System.out.print(" ");
        }
        System.out.println();
    }

    /**
     * 2進出力
     * @param bytes バイト列
     */
    public void printBytesToBinary(List<Byte> bytes) {

        for (Byte val : bytes) {
            System.out.print(Integer.toBinaryString(val));
            System.out.print(" ");
        }
        System.out.println();
    }
}
