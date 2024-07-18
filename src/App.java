import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    Font myFont = new Font("Times New Roman", Font.PLAIN, 30);
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    App()
    {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setBackground(Color.black);
        frame.setLayout(null);
        //i have now created the basic frame for a calculator with a title 

        //now i work on the textfield
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(myFont);
        textField.setEditable(false);

        //adding the functions
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("del");
        clrButton = new JButton("clr");
        negButton = new JButton("(-)");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for(int i = 0; i <9; i++)
        {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for(int i = 0; i <10; i++)
        {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        //creating and editing a panel 
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 320);
        panel.setLayout(new GridLayout(4,4,10,10));

        


        //adding numbers to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);

        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);

        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);

        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);

        panel.add(divButton);
       
        //adding all panels and extra buttons to the frame
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);  
    }
    public static void main(String[] args) throws Exception 
    { 
        App calculator = new App();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {

        for(int i = 0; i < 10; i++)
        {
            if(e.getSource()== numberButtons[i])
            {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
            //this allows the numbers to be pressed as a function button and displayed on the text field as an action 
        }

        if(e.getSource()==decButton)
        {
            textField.setText(textField.getText().concat(String.valueOf(".")));
            //useful when creating decimal numbers 
        }

        if(e.getSource()==equButton)
        {
            num2 = Double.parseDouble(textField.getText());
            switch(operator)
            {
                case'+':
                result = num1+num2;
                break;

                case'-':
                result = num1-num2;
                break;

                case'x':
                result = num1*num2;
                break;

                case'/':
                result = num1/num2;
                break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
            //using a switch allows the possibilites of all operators and recognises the function when used and when used it breaks 
            //the result will then be stored and displayed in the textfield 
        }
        if(e.getSource()==clrButton)
        {
            textField.setText("");
            //this clears all the numbers at once 
        }
        if(e.getSource()==delButton)
        {
            String string = textField.getText();
            textField.setText("");
            for(int i = 0; i < string.length()-1; i++)
            {
                textField.setText(textField.getText()+string.charAt(i));
            }
            //this function deletes the numbers from the last number one by one 
        }

        if(e.getSource()==negButton)
        {
            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));
            //allowing a negative button to be used before a number 
        }

        if(e.getSource()==addButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
            //addition 
        }
        if(e.getSource()==subButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
            //subtraction 
        }
        if(e.getSource()==mulButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = 'x';
            textField.setText("");
            //multiplication 
        }
        if(e.getSource()==divButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
            //division
        }
    }
}
