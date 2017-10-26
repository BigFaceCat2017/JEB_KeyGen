import keygen.MachineID;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class KeyGen {
    private JTextField serial;
    private JPanel panel1;
    private JLabel tip;

    public static void main(String[] args) {
        JFrame frame = new JFrame("JEB KeyGen for v2.3.6");
        KeyGen keyGen = new KeyGen();
        frame.setContentPane(keyGen.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(new Dimension(350,150));
        String key = keygen.KeyGen.getKey(MachineID.get()[0], System.currentTimeMillis() / 1000);
        keyGen.serial.setText(key);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(new StringSelection(key), new ClipboardOwner() {
            @Override
            public void lostOwnership(Clipboard clipboard, Transferable contents) {

            }
        });
        keyGen.tip.setText("Serial has been copy to clipboard successful!");
    }
}
