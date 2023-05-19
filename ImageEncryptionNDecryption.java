
/*Program to perform Image Encryption and Decryption
By entering the Key you encrypt the Image and Becomes unaccessible to users unless the key is Entered 
Step 1:Enter the Key
Step 2:Select the Image 
Step 3:Wait till the process is completed and popup box appears
Then go the place from where the image was Chosen and try to open that image It will show an error(corrupt) */
import java.awt.*;
import javax.swing.*;
import javax.xml.namespace.QName;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

class ImageEncryptionNDecryption {
    public static void operate(int key) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file = fileChooser.getSelectedFile();
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[fis.available()];

            fis.read(data);
            int i = 0;
            for (byte b : data) {
                System.out.println(b);
                data[i] = (byte) (b ^ key);
                i++;
            } // for()
            FileOutputStream FOS = new FileOutputStream(file);
            FOS.write(data);
            FOS.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "done");
        } // try
        catch (Exception e) {
            e.printStackTrace();
        } // catch

    }// operate()

    public static void main(String[] args) {
        System.out.println("This is a project !!");
        JFrame f = new JFrame();
        f.setTitle("Image Operation");
        f.setSize(400, 400);
        f.setLocationRelativeTo(null); // To place the window in the center
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // so that the window is closed when clicked

        Font font = new Font("Roboto", Font.BOLD, 25);
        // To create GUI
        JButton button = new JButton();
        button.setText("Open Image");
        button.setFont(font);

        // creating text field
        JTextField textField = new JTextField(10);
        textField.setFont(font);

        button.addActionListener(e -> {
            System.out.println("button clicked");
            String text = textField.getText();
            int temp = Integer.parseInt(text);
            operate(temp);
        });
        // As addActionListener is an interface so directly function cannot be Made,so
        // the Child class is to be made but
        // here Lambda function comes into picture

        f.setLayout(new FlowLayout());
        f.add(button);
        f.add(textField);
        f.setVisible(true);
    }// main()
}// class