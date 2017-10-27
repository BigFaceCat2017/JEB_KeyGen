import keygen.MachineID;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class KeyGen {
    private JTextField serial;
    private JPanel jPanel;
    private JLabel tip;

    public static void main(String[] args) {
        JFrame frame = new JFrame("JEB KeyGen for v2.3.6");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
        int screenWidth = screenSize.width / 2; // 获取屏幕的宽
        int screenHeight = screenSize.height / 2; // 获取屏幕的高
        final int height = 150;
        final int width = 350;
        frame.setLocation(screenWidth - width / 2, screenHeight - height / 2);
        KeyGen keyGen = new KeyGen();
        frame.setContentPane(keyGen.jPanel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(width, height));
        String key = keygen.KeyGen.getKey(MachineID.get()[0], System.currentTimeMillis() / 1000);
        keyGen.serial.setText(key);
        Clipboard clipboard = kit.getSystemClipboard();
        clipboard.setContents(new StringSelection(key), new ClipboardOwner() {
            @Override
            public void lostOwnership(Clipboard clipboard, Transferable contents) {

            }
        });
        keyGen.tip.setText("Serial has been copy to clipboard successful!");
    }
}
