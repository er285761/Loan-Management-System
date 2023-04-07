package uranus;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;


public class Client{
   String gender = "";
   ResultSet rst, rstLast;
   Object[][] data;
   int serialNo;
   String SHOW = "show";



   // Defining constructor
   /* Client(){
        clientName.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                if(clientName.getText().length()>= 30)
                e.consume();
            }
        });

        email.addKeyListener(new KeyAdapter(){
            public void keyTyped(KeyEvent e){
                if(email.getText().length() >= 0)
                    e.consume();
            }
        });

    }*/
}
