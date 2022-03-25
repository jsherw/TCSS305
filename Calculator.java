 /*
 * @author James Sherwood
 * @Version: 3.17.2022
 * TCSS 305
 * Professor Dincer
 *
 * Programming Assignment #4
 * GUI calculator providing functionality for integers and floating point numbers.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Calculator implements ActionListener {
    //Fields
    private int operation;
    private double temp;
    public StringBuilder logInput = new StringBuilder();

    //GUI Properties
        JFrame frame;
        JLabel label = new JLabel();
        JTextField textField = new JTextField();
        //Radio buttons
        JRadioButton intRadioButton = new JRadioButton("int");
        JRadioButton fltRadioButton = new JRadioButton("flt");
        //Component buttons
        JButton zeroBtn = new JButton("0");
        JButton oneBtn = new JButton("1");
        JButton twoBtn = new JButton("2");
        JButton threeBtn = new JButton("3");
        JButton fourBtn = new JButton("4");
        JButton fiveBtn = new JButton("5");
        JButton sixBtn = new JButton("6");
        JButton sevenBtn = new JButton("7");
        JButton eightBtn = new JButton("8");
        JButton nineBtn = new JButton("9");
        JButton decimalBtn = new JButton(".");
        JButton clrBtn = new JButton("C");
        JButton delBtn = new JButton("DEL");
        JButton equalBtn = new JButton("=");
        JButton multBtn = new JButton("x");
        JButton divBtn = new JButton("/");
        JButton addBtn = new JButton("+");
        JButton subBtn = new JButton("-");
        JButton expBtn = new JButton("x\u00B2");
        JButton recipBtn = new JButton("1/x");
        JButton rootBtn = new JButton("\u221A");


        //Calculator Constructor
        Calculator() {
            calcGUI();
            addComps();
            addActionEvent();
        }

        //Initialize gui
        public void calcGUI() {
            frame = new JFrame();
            frame.setTitle("Calculator");
            frame.setSize(300, 500);
            frame.getContentPane().setLayout(null);
            frame.getContentPane().setBackground(Color.black);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        //GUI component layout and style specifications
        public void addComps() {
            label.setBounds(250, 0, 50, 50);
            label.setForeground(Color.white);
            frame.add(label);

            textField.setBounds(10, 40, 270, 40);
            textField.setFont(new Font("Arial", Font.BOLD, 20));
            textField.setEditable(false);
            textField.setHorizontalAlignment(SwingConstants.RIGHT);
            frame.add(textField);

            intRadioButton.setBounds(10, 95, 60, 40);
            intRadioButton.setSelected(true);
            intRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
            intRadioButton.setBackground(Color.black);
            intRadioButton.setForeground(Color.white);
            frame.add(intRadioButton);

            fltRadioButton.setBounds(10, 120, 60, 40);
            fltRadioButton.setSelected(false);
            fltRadioButton.setFont(new Font("Arial", Font.BOLD, 14));
            fltRadioButton.setBackground(Color.black);
            fltRadioButton.setForeground(Color.white);
            frame.add(fltRadioButton);

            ButtonGroup btnGrp = new ButtonGroup();
            btnGrp.add(intRadioButton);
            btnGrp.add(fltRadioButton);

            sevenBtn.setBounds(10, 230, 60, 40);
            sevenBtn.setFont(new Font("Arial", Font.BOLD, 20));
            frame.add(sevenBtn);

            eightBtn.setBounds(80, 230, 60, 40);
            eightBtn.setFont(new Font("Arial", Font.BOLD, 20));
            frame.add(eightBtn);

            nineBtn.setBounds(150, 230, 60, 40);
            nineBtn.setFont(new Font("Arial", Font.BOLD, 20));
            frame.add(nineBtn);

            fourBtn.setBounds(10, 290, 60, 40);
            fourBtn.setFont(new Font("Arial", Font.BOLD, 20));
            frame.add(fourBtn);

            fiveBtn.setBounds(80, 290, 60, 40);
            fiveBtn.setFont(new Font("Arial", Font.BOLD, 20));
            frame.add(fiveBtn);

            sixBtn.setBounds(150, 290, 60, 40);
            sixBtn.setFont(new Font("Arial", Font.BOLD, 20));
            frame.add(sixBtn);

            oneBtn.setBounds(10, 350, 60, 40);
            oneBtn.setFont(new Font("Arial", Font.BOLD, 20));
            frame.add(oneBtn);

            twoBtn.setBounds(80, 350, 60, 40);
            twoBtn.setFont(new Font("Arial", Font.BOLD, 20));
            frame.add(twoBtn);

            threeBtn.setBounds(150, 350, 60, 40);
            threeBtn.setFont(new Font("Arial", Font.BOLD, 20));
            frame.add(threeBtn);

            decimalBtn.setBounds(150, 410, 60, 40);
            decimalBtn.setFont(new Font("Arial", Font.BOLD, 20));
            frame.add(decimalBtn);

            zeroBtn.setBounds(10, 410, 130, 40);
            zeroBtn.setFont(new Font("Arial", Font.BOLD, 20));
            frame.add(zeroBtn);

            equalBtn.setBounds(220, 350, 60, 100);
            equalBtn.setFont(new Font("Arial", Font.BOLD, 20));
            equalBtn.setBackground(new Color(239, 188, 2));
            frame.add(equalBtn);

            divBtn.setBounds(220, 110, 60, 40);
            divBtn.setFont(new Font("Arial", Font.BOLD, 20));
            divBtn.setBackground(new Color(239, 188, 2));
            frame.add(divBtn);

            rootBtn.setBounds(10, 170, 60, 40);
            rootBtn.setFont(new Font("Arial", Font.BOLD, 18));
            frame.add(rootBtn);

            multBtn.setBounds(220, 230, 60, 40);
            multBtn.setFont(new Font("Arial", Font.BOLD, 20));
            multBtn.setBackground(new Color(239, 188, 2));
            frame.add(multBtn);

            subBtn.setBounds(220, 170, 60, 40);
            subBtn.setFont(new Font("Arial", Font.BOLD, 20));
            subBtn.setBackground(new Color(234, 185, 4));
            frame.add(subBtn);


            addBtn.setBounds(220, 290, 60, 40);
            addBtn.setFont(new Font("Arial", Font.BOLD, 20));
            addBtn.setBackground(new Color(239, 188, 2));
            frame.add(addBtn);

            expBtn.setBounds(80, 170, 60, 40);
            expBtn.setFont(new Font("Arial", Font.BOLD, 20));
            frame.add(expBtn);

            recipBtn.setBounds(150, 170, 60, 40);
            recipBtn.setFont(new Font("Arial", Font.BOLD, 15));
            frame.add(recipBtn);

            delBtn.setBounds(150, 110, 60, 40);
            delBtn.setFont(new Font("Arial", Font.BOLD, 12));
            delBtn.setBackground(Color.red);
            delBtn.setForeground(Color.white);
            frame.add(delBtn);

            clrBtn.setBounds(80, 110, 60, 40);
            clrBtn.setFont(new Font("Arial", Font.BOLD, 12));
            clrBtn.setBackground(Color.red);
            clrBtn.setForeground(Color.white);
            frame.add(clrBtn);
        }

        public void addActionEvent(){
            //Radio Buttons
            for (JRadioButton jRadioButton : Arrays.asList(intRadioButton, fltRadioButton)) {
                jRadioButton.addActionListener(this);
            }
            //Buttons
            for (JButton jButton : Arrays.asList(zeroBtn, oneBtn,twoBtn,threeBtn,fourBtn,fiveBtn,sixBtn,
                    sevenBtn,eightBtn, nineBtn, clrBtn, delBtn, addBtn, subBtn, multBtn, divBtn, expBtn,
                    rootBtn, recipBtn, decimalBtn, equalBtn)) {
                jButton.addActionListener(this);
            }

        }

        /*
         * @Method: Accept input from GUI and perform requested calculation.
         * @Param: ActionEvent
         * @Return: none
         */
        @Override
        public void actionPerformed(ActionEvent e){
            Object input = e.getSource();
            if(input == intRadioButton){
                enable();
                fltRadioButton.setEnabled(false);
                decimalBtn.setEnabled(false);
            } else if( input == fltRadioButton){
                enable();
                fltRadioButton.setEnabled(true);
                intRadioButton.setEnabled(false);
            } else if(input == clrBtn){
                label.setText("");
                textField.setText("");
            } else if(input == delBtn ){
                int length = textField.getText().length();
                int last = length - 1;

                if (length > 0){
                    StringBuilder del = new StringBuilder(textField.getText());
                    del.deleteCharAt(last);
                    textField.setText(del.toString());
                }
            } else if(input == zeroBtn){

                if(textField.getText().equals("0")){
                    textField.setText(textField.getText());
                } else{
                  textField.setText(textField.getText() + "0");
                }
            } else if(input == oneBtn){
                textField.setText(textField.getText() + "1");

            } else if(input == twoBtn) {
                textField.setText(textField.getText() + "2");
            } else if(input == threeBtn) {
                textField.setText(textField.getText() + "3");
            } else if(input == fourBtn) {
                textField.setText(textField.getText() + "4");
            } else if(input == fiveBtn) {
                textField.setText(textField.getText() + "5");
            } else if(input == sixBtn) {
                textField.setText(textField.getText() + "6");
            } else if(input == sevenBtn) {
                textField.setText(textField.getText() + "7");
            } else if(input == eightBtn) {
                textField.setText(textField.getText() + "8");
            } else if(input == nineBtn){
                textField.setText(textField.getText() + "9");
            } else if(input == decimalBtn){
                if(!textField.getText().contains(".")){
                    textField.setText(textField.getText() + ".");
                }
            } else if(input == addBtn){
                temp = Double.parseDouble(textField.getText());
                textField.setText("");
                if(intRadioButton.isEnabled()){
                    label.setText((int) temp + " +");

                } else{
                    label.setText(temp + "+");
                }
                logInput.append(label.getText()).append(" ");
                operation = 1;
            } else if(input == subBtn){
                temp = Double.parseDouble(textField.getText());
                textField.setText("");
                if(intRadioButton.isEnabled()){
                    label.setText((int) temp + " - ");
                } else{
                    label.setText(temp + " - ");
                }
                logInput.append(label.getText()).append(" ");
                operation = 2;
            } else if (input == multBtn){
                temp = Double.parseDouble(textField.getText());
                textField.setText("");
                if(intRadioButton.isEnabled()){
                    label.setText((int) temp + " * ");
                } else{
                    label.setText(temp + " * ");
                }
                logInput.append(label.getText()).append(" ");
                operation = 3;
            } else if(input == divBtn){
                temp = Double.parseDouble(textField.getText());
                textField.setText((""));
                if(intRadioButton.isEnabled()){
                    label.setText((int) temp + " / ");
                } else{
                    label.setText(temp + " / ");
                }
                logInput.append(label.getText()).append(" ");
                operation = 4;
            } else if(input == rootBtn){
                temp = Double.parseDouble(textField.getText());
                if (intRadioButton.isEnabled() && inputVerification(temp)){
                    int sqrt = intSquareRoot(temp);
                    if(sqrt != -0){
                        textField.setText(Integer.toString(sqrt));
                        label.setText("sqrt( " + (int)temp + " ) ");
                        logInput.append(textField.getText());
                    } else{
                        textField.setText("Invalid Input");
                        logInput.append(textField.getText()).append(" ");
                        label.setText("");
                    }
                } else{
                    textField.setText(Double.toString(doubSquareRoot(temp)));
                    logInput.append(textField.getText()).append(" ");
                    label.setText("sqrt( " + temp + " ) ");

                }
            } else if (input == expBtn){
                temp = Double.parseDouble(textField.getText());
                if(intRadioButton.isEnabled()){
                    if(inputVerification(temp)){
                        int exponent = intExponent(temp);
                        if(exponent != -0){
                            textField.setText(Integer.toString(exponent));
                            logInput.append(textField.getText()).append(" ");
                        } else{
                            textField.setText("Invalid Input");
                            logInput.append(textField.getText()).append(" ");
                            label.setText("");
                        }
                    } else{
                        textField.setText("Invalid Input");
                        logInput.append(textField.getText()).append(" ");
                        label.setText("");
                    }
                } else{
                    textField.setText(Double.toString(doubExponent(temp)));
                    logInput.append(textField.getText()).append(" ");
                    label.setText("");
                }
            } else if(input == recipBtn){
                temp = Double.parseDouble(textField.getText());
                if(intRadioButton.isEnabled() && temp < 1 || intRadioButton.isEnabled() && temp > 1 || temp == 0){
                    textField.setText("Invalid input");
                    logInput.append(textField.getText()).append(" ");
                    label.setText("");
                } else if(intRadioButton.isEnabled() && temp == 1){
                    textField.setText(Integer.toString(1));
                    logInput.append(textField.getText()).append(" ");
                    label.setText("");
                } else{
                    textField.setText(Double.toString(reciprocal(temp)));
                    logInput.append(textField.getText()).append(" ");
                    label.setText(" 1 / " + temp + " = ");
                }
            } else if(input == equalBtn){
                switch (operation) {
                    case 1 -> {
                        double additive = Double.parseDouble(textField.getText());
                        if(intRadioButton.isEnabled() && inputVerification(temp)) {
                            int tempSum = intPlus(temp, additive);
                            if (tempSum != -0) {
                                textField.setText((Integer.toString(tempSum)));
                                logInput.append((int)additive).append(" = ").append(textField.getText()).append(" ");
                                label.setText((int)temp + " + " + (int) additive + " = " );
                            } else{
                                textField.setText("Invalid Input");
                                logInput.append(textField.getText()).append(" ");
                            }
                        } else{
                            textField.setText(Double.toString(doubPlus(temp, additive)));
                            logInput.append(additive).append(" = ").append(textField.getText()).append(" ");
                            label.setText(temp + " + " + additive + " = ");
                        }
                        printConsoleLog(logInput);
                    }
                    case 2 -> {
                        double additive = Double.parseDouble(textField.getText());
                        if(intRadioButton.isEnabled() && inputVerification(temp)) {
                            int tempSum = intSubtract(temp, additive);
                            if (tempSum != -0) {
                                textField.setText((Integer.toString(tempSum)));
                                logInput.append((int) additive).append(" = ").append(textField.getText()).append(" ");
                                label.setText((int)temp + " - " + (int) additive + " = " );
                            } else{
                                textField.setText("Invalid Input");
                            }
                            label.setText("");
                        } else{
                            textField.setText(Double.toString(doubSubtract(temp, additive)));
                            logInput.append(additive).append(" = ").append(textField.getText()).append(" ");
                            label.setText(temp + " - " + additive + " = " );
                        }
                        printConsoleLog(logInput);
                    }
                    case 3 -> {
                        double multiplier = Double.parseDouble(textField.getText());
                        if(intRadioButton.isEnabled() && inputVerification(temp)){
                            int tempProduct = intMultiply(temp, multiplier);
                            if (tempProduct != -0){
                                textField.setText(Integer.toString(tempProduct));
                                logInput.append((int) multiplier).append(" = ").append(textField.getText()).append(" ");
                                label.setText((int)temp + " * " + (int) multiplier + " = " );
                            } else{
                                textField.setText("Invalid Input");
                                logInput.append(textField.getText()).append(" ");
                            }
                        } else{
                            textField.setText(Double.toString(doubMultiply(temp, multiplier)));
                            logInput.append(multiplier).append(" = ").append(textField.getText()).append(" ");
                            label.setText(temp + " * " + multiplier + " = " );
                        }
                        printConsoleLog(logInput);
                    }
                    case 4 -> {
                        double divisor = Double.parseDouble(textField.getText());
                        if (divisor == 0 ){
                            textField.setText("Invalid Input.");
                            logInput.append(textField.getText()).append(" ");
                            label.setText("");
                        } else if(intRadioButton.isEnabled() && inputVerification(temp)){
                            int tempQuotient = intDivide(temp, divisor);
                            if(tempQuotient != -0){
                                textField.setText(Integer.toString(tempQuotient));
                                logInput.append((int) divisor).append(" = ").append(textField.getText()).append(" ");
                                label.setText((int)temp + " / " + (int) divisor + " = " );
                            } else{
                                textField.setText("Invalid Input");
                                logInput.append(textField.getText()).append(" ");
                                label.setText("");
                            }
                        } else{
                            textField.setText(Double.toString(doubDivision(temp, divisor)));
                            logInput.append(divisor).append(" = ").append(textField.getText()).append(" ");
                            label.setText(temp + " / " + divisor + " = " );
                        }
                        printConsoleLog(logInput);
                    }
                }
            }
        }

        /*
         * Method: Default enabling of buttons on start up
         * @Param: None
         * @Return: None
         */
        public void enable(){
            textField.setEnabled(true);
            label.setEnabled(true);

            intRadioButton.setEnabled(true);
            fltRadioButton.setEnabled(false);

            for (JButton jButton : Arrays.asList(
                    zeroBtn, oneBtn, twoBtn, threeBtn, fourBtn,
                    fiveBtn, sixBtn, sevenBtn, eightBtn, nineBtn,
                    addBtn, subBtn, multBtn, divBtn, expBtn, rootBtn,
                    recipBtn, decimalBtn, equalBtn, clrBtn, delBtn)) {
                         jButton.setEnabled(true);
            }

        }

    /**
     * Method: Verify input is a valid integer.
     * @param x double that will be treated as an int.
     * @return  true if double can be converted to int, false otherwise.
     */
    public boolean inputVerification(double x){
        return !(x < -2147483647) && !(x > 2147483647);
    }

    /**
     * Method: Integer addition calculation
     * @param temp first operand
     * @param additive second operand
     */
    public int intPlus(double temp, double additive){
        int total;
            if (inputVerification(temp + additive) ){
                total = ((int) temp + (int)additive);
                return total;
            } else{
                return -0;
            }
    }
    /**
     * Method: Double addition calculation
     * @param temp first operand
     * @param additive second operand
     */
    public double doubPlus(double temp, double additive){
        return temp + additive;
    }

    /**
     * Method: Integer subtraction calculation
     * @param temp first operand
     * @param additive second operand
     */
    public int intSubtract(double temp, double additive){
        int total;
        if (inputVerification(temp - additive) ){
            total = ((int) temp - (int)additive);
            return total;
        } else{
            return -0;
        }
    }
    /**
     * Method: Double subtraction calculation
     * @param temp first operand
     * @param additive second operand
     */
    public double doubSubtract(double temp, double additive){
        return temp - additive;
    }

    /**
     * Method: Integer multiplication calculation
     * @param temp first operand
     * @param multiplier second operand
     */
    public int intMultiply(double temp, double multiplier){
        int total;
            if (inputVerification(temp * multiplier) ){
                total = ((int) temp * (int)multiplier);
                return total;
            } else{
                return -0;
            }
    }
    /**
     * Method: Integer multiplication calculation
     * @param temp first operand
     * @param multiplier second operand
     */
    public double doubMultiply(double temp, double multiplier){
        return temp * multiplier;
    }

    /**
     * Method: Integer division calculation
     * @param temp first operand
     * @param divisor second operand
     */
    public int intDivide(double temp, double divisor){
        if (inputVerification(temp/divisor)) {
            return ((int) temp / (int) divisor);
        }else{
                return -0;
            }
    }
    /**
     * Method: Double division calculation
     * @param temp first operand
     * @param divisor second operand
     */
    public double doubDivision(double temp, double divisor){
        return temp/divisor;
    }

    /**
     * Method: Calculate integer square root
     * @param temp operand
     * @return result
     */
    public int intSquareRoot(double temp){
        if((Math.sqrt(temp) == Math.floor(Math.sqrt(temp))) && inputVerification(Math.sqrt(temp))) {
                return (int) Math.sqrt(temp);
            } else {
                return -0;
            }
    }

    /**
     * Method: Calculate double square root
     * @param temp operand
     * @return  result
     */
    public double doubSquareRoot(double temp){
        return Math.sqrt(temp);
    }

    /**
     * Method: Calculate integer raised to second power
     * @param temp operand
     * @return result
     */
    public int intExponent(double temp){
        double square = Math.pow(temp, 2);
        if(inputVerification(square)){
            return (int) square;
        } else{
            return -0;
        }
    }
    /**
     * Method: Calculate double raised to second power
     * @param temp operand
     * @return result
     */
    public double doubExponent(double temp){
        return Math.pow(temp, 2);
    }

    /**
     * Method: reciprocal
     * @param temp divisor
     * @return result
     */
    public double reciprocal(double temp){
        return (1/temp);
    }
    public void printConsoleLog(StringBuilder logInput){
        System.out.println(logInput);
    }
}
