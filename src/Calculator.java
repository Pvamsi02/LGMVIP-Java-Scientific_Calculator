import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Calculator implements ActionListener {
    public static void main(String[] args) {
        new Calculator();
    }

    final int width = 600, height = 630;
    Font font = new Font("Monospaced", Font.PLAIN, 30);
    Font font1 = new Font("Monospaced", Font.PLAIN, 40);
    JFrame frame;
    JTextField input;
    JLabel title;
    JTextField output;
    JPanel keys;
    JButton[] numButton = new JButton[10];
    JButton[] funButton = new JButton[18];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, clrButton, eqButton, delButton, negButton;
    JButton sqrButton, sqrtButton, factButton, sinButton, cosButton, tanButton, inverseButton, modButton, theme;
    double n1 = 0, n2 = 0, res = 0;
    char operator;
    boolean co = true;
    Color bg = new Color(255, 253, 208);
    Color bg1 = new Color(87, 87, 87);
    ImageIcon icon = new ImageIcon("src/img_1.png", "");
    ImageIcon icon1 = new ImageIcon("src/img2.png", "");

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setSize(width, height);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(bg);
        frame.setResizable(false);
        frame.setIconImage(icon1.getImage());

        title = new JLabel("Scientific Calculator");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(0, 550, width, 40);
        title.setBackground(new Color(253, 232, 0));
        title.setOpaque(true);
        title.setFont(font1);
        title.setVerticalTextPosition(JLabel.CENTER);
        input = new JTextField("");
        input.setHorizontalAlignment(JTextField.RIGHT);
        input.setForeground(Color.BLACK);
        input.setBounds(10, 25, 560, 50);
        input.setOpaque(true);
        input.setFont(font1);
        input.setEditable(false);
        input.setBackground(bg);
        output = new JTextField("");
        output.setHorizontalAlignment(JTextField.RIGHT);
        output.setForeground(Color.BLACK);
        output.setBounds(10, 80, 560, 50);
        output.setOpaque(true);
        output.setFont(font1);
        output.setEditable(false);
        output.setBackground(bg);
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("×");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        eqButton = new JButton("=");
        clrButton = new JButton("C");
        delButton = new JButton("DEL");
        negButton = new JButton("+/-");
        sqrButton = new JButton("X^2");
        sqrtButton = new JButton("√");
        factButton = new JButton("X!");
        sinButton = new JButton("SIN");
        cosButton = new JButton("COS");
        tanButton = new JButton("TAN");
        inverseButton = new JButton("1/X");
        modButton = new JButton("X%Y");
        theme = new JButton(icon);

        funButton[0] = addButton;
        funButton[1] = subButton;
        funButton[2] = mulButton;
        funButton[3] = divButton;
        funButton[4] = decButton;
        funButton[5] = eqButton;
        funButton[6] = delButton;
        funButton[7] = clrButton;
        funButton[8] = negButton;
        funButton[9] = sqrButton;
        funButton[10] = sqrtButton;
        funButton[11] = factButton;
        funButton[12] = sinButton;
        funButton[13] = cosButton;
        funButton[14] = tanButton;
        funButton[15] = inverseButton;
        funButton[16] = modButton;
        funButton[17] = theme;


        for (int i = 0; i < 18; i++) {
            funButton[i].addActionListener(this);
            funButton[i].setFont(font);
            funButton[i].setFocusable(false);
            funButton[i].setBackground(new Color(0, 207, 255));
        }

        keys = new JPanel();
        keys.setBounds(50, 140, 500, 400);
        keys.setLayout(new GridLayout(7, 4, 10, 10));
        keys.setBackground(bg);

        for (int i = 0; i < 10; i++) {
            numButton[i] = new JButton(String.valueOf(i));
            numButton[i].addActionListener(this);
            numButton[i].setFont(font);
            numButton[i].setFocusable(false);
            numButton[i].setBackground(new Color(62, 255, 90));
        }

        keys.add(sqrtButton);
        keys.add(sqrButton);
        keys.add(factButton);
        keys.add(inverseButton);


        keys.add(modButton);

        keys.add(sinButton);
        keys.add(cosButton);
        keys.add(tanButton);

        keys.add(numButton[1]);
        keys.add(numButton[2]);
        keys.add(numButton[3]);
        keys.add(addButton);

        keys.add(numButton[4]);
        keys.add(numButton[5]);
        keys.add(numButton[6]);
        keys.add(subButton);

        keys.add(numButton[7]);
        keys.add(numButton[8]);
        keys.add(numButton[9]);
        keys.add(mulButton);

        keys.add(negButton);
        keys.add(numButton[0]);
        keys.add(decButton);
        keys.add(divButton);

        keys.add(delButton);
        keys.add(clrButton);
        keys.add(eqButton);
        keys.add(theme);

        frame.add(input);
        frame.add(output);
        frame.add(keys);
        frame.add(title);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DecimalFormat df = new DecimalFormat("#.##");
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numButton[i])
                input.setText(input.getText().concat(String.valueOf(i)));
        }

        if (e.getSource() == decButton)
            input.setText(input.getText().concat("."));

        else if (e.getSource() == addButton) {
            n1 = Double.parseDouble(input.getText());
            output.setText(input.getText());
            input.setText("");
            addButton.setBackground(new Color(250, 250, 100));
            operator = '+';
        } else if (e.getSource() == subButton) {
            n1 = Double.parseDouble(input.getText());
            output.setText(input.getText());
            input.setText("");
            subButton.setBackground(new Color(250, 250, 100));
            operator = '-';
        } else if (e.getSource() == mulButton) {
            n1 = Double.parseDouble(input.getText());
            output.setText(input.getText());
            input.setText("");
            mulButton.setBackground(new Color(250, 250, 100));
            operator = '*';
        } else if (e.getSource() == divButton) {
            n1 = Double.parseDouble(input.getText());
            output.setText(input.getText());
            input.setText("");
            divButton.setBackground(new Color(250, 250, 100));
            operator = '/';
        } else if (e.getSource() == modButton) {
            n1 = Double.parseDouble(input.getText());
            output.setText(input.getText());
            input.setText("");
            modButton.setBackground(new Color(250, 250, 100));
            operator = '%';
        } else if (e.getSource() == clrButton) {
            input.setText("");
            output.setText("");
        } else if (e.getSource() == delButton)
            input.setText(input.getText().substring(0, input.getText().length() - 1));
        else if (e.getSource() == eqButton) {
            n2 = Double.parseDouble(input.getText());
            switch (operator) {
                case '+':
                    res = n1 + n2;
                    addButton.setBackground(new Color(12, 186, 235));
                    break;
                case '-':
                    res = n1 - n2;
                    subButton.setBackground(new Color(12, 186, 235));
                    break;
                case '*':
                    res = n1 * n2;
                    mulButton.setBackground(new Color(12, 186, 235));
                    break;
                case '/':
                    res = n1 / n2;
                    divButton.setBackground(new Color(12, 186, 235));
                    break;
                case '%':
                    res = n1 % n2;
                    modButton.setBackground(new Color(12, 186, 235));
                    break;
            }
            output.setText(df.format(res));
            input.setText(df.format(res));
        } else if (e.getSource() == negButton) {
            double n = Double.parseDouble(input.getText());
            n *= -1;
            input.setText(df.format(n));
        } else if (e.getSource() == sqrtButton) {
            n1 = Double.parseDouble(input.getText());
            n1 = Math.sqrt(n1);
            output.setText(df.format(n1));
            input.setText(df.format(n1));
        } else if (e.getSource() == sqrButton) {
            n1 = Double.parseDouble(input.getText());
            n1 *= n1;
            output.setText(df.format(n1));
            input.setText(df.format(n1));
        } else if (e.getSource() == factButton) {
            n1 = Double.parseDouble(input.getText());
            double fact = 1;
            for (int i = 1; i <= n1; i++) {
                fact *= i;
            }
            output.setText(df.format(fact));
            input.setText(df.format(fact));
        } else if (e.getSource() == sinButton) {
            n1 = Double.parseDouble(input.getText());
            double s = Math.toRadians(n1);
            output.setText(df.format(Math.sin(s)));
            input.setText(df.format(Math.sin(s)));
        } else if (e.getSource() == cosButton) {
            n1 = Double.parseDouble(input.getText());
            double s = Math.toRadians(n1);
            output.setText(df.format(Math.cos(s)));
            input.setText(df.format(Math.cos(s)));
        } else if (e.getSource() == tanButton) {
            n1 = Double.parseDouble(input.getText());
            double s = Math.toRadians(n1);
            output.setText(df.format(Math.tan(s)));
            input.setText(df.format(Math.tan(s)));
        } else if (e.getSource() == inverseButton) {
            n1 = Double.parseDouble(input.getText());
            n1 = 1 / n1;
            output.setText(df.format(n1));
            input.setText(df.format(n1));
        } else if (e.getSource() == theme) {
            if (co) {
                frame.getContentPane().setBackground(bg1);
                input.setBackground(bg1);
                output.setBackground(bg1);
                keys.setBackground(bg1);
                input.setForeground(Color.white);
                output.setForeground(Color.white);
                co = false;
            }
            else {
                frame.getContentPane().setBackground(bg);
                input.setBackground(bg);
                output.setBackground(bg);
                keys.setBackground(bg);
                input.setForeground(Color.BLACK);
                output.setForeground(Color.BLACK);
                co = true;
            }
        }
    }
}
