//all libraries required
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//this is my first java project utilising the swing library
//this project creates a simple calculator 
//*changes* - edited variables 

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numbers = new JButton[10];
    JButton[] functions = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;
    Font font = new Font("Times New Roman", Font.PLAIN, 30);
    double num1 = 0, num2 = 0, result = 0; //starting numbers 
    char operators; // signs

    Calculator()
    {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setBackground(Color.black);
        frame.setLayout(null);
        //I have now created the basic frame for a calculator with a title 

        //working on the textfield
        textField = new JTextField();
        textField.setBounds(50, 25, 300, 50);
        textField.setFont(font);
        textField.setEditable(false);

        //adding visual functionality to each button and function 
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("del");
        clrButton = new JButton("clr");
        negButton = new JButton("(-)");

        functions[0] = addButton;
        functions[1] = subButton;
        functions[2] = mulButton;
        functions[3] = divButton;
        functions[4] = decButton;
        functions[5] = equButton;
        functions[6] = delButton;
        functions[7] = clrButton;
        functions[8] = negButton;

        for(int i = 0; i <9; i++)
        {
            functions[i].addActionListener(this);
            functions[i].setFont(font);
            functions[i].setFocusable(false);
        }

        for(int i = 0; i <10; i++)
        {
            numbers[i] = new JButton(String.valueOf(i));
            numbers[i].addActionListener(this);
            numbers[i].setFont(font);
            numbers[i].setFocusable(false);
        }

        //positioning of the 3 buttons at the bottom of the calculator
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        //creating and editing a panel 
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 320);
        panel.setLayout(new GridLayout(4,4,10,10));

        //adding numbers to the panel in standard calculator 
        panel.add(numbers[1]);
        panel.add(numbers[2]);
        panel.add(numbers[3]);
        panel.add(addButton);
        panel.add(numbers[4]);
        panel.add(numbers[5]);
        panel.add(numbers[6]);
        panel.add(subButton);
        panel.add(numbers[7]);
        panel.add(numbers[8]);
        panel.add(numbers[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numbers[0]);
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
        Calculator x = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        for(int i = 0; i < 10; i++)
        {
            if(e.getSource()== numbers[i])
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
            switch(operators)
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
            String x = textField.getText();
            textField.setText("");
            for(int i = 0; i < x.length()-1; i++)
            {
                textField.setText(textField.getText()+x.charAt(i));
            }
            //this function deletes the numbers from the last number one by one 
        }

        if(e.getSource()==negButton)
        {
            double y = Double.parseDouble(textField.getText());
            y*=-1;
            textField.setText(String.valueOf(y));
            //allowing a negative button to be used before a number 
        }


        //operators
        if(e.getSource()==addButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operators = '+';
            textField.setText("");
            //addition 
        }
        if(e.getSource()==subButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operators = '-';
            textField.setText("");
            //subtraction 
        }
        if(e.getSource()==mulButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operators = 'x';
            textField.setText("");
            //multiplication 
        }
        if(e.getSource()==divButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operators = '/';
            textField.setText("");
            //division
        }
    }
}
