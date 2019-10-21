package ru.puchkova.homework21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button okBttn;
    Button clearBttn;
    TextView resultTxt;
    EditText nameETxt;
    EditText mailETxt;
    String name;
    String mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        okBttn = (Button) findViewById(R.id.okBttn);
        clearBttn = (Button) findViewById(R.id.clearBttn);
        resultTxt = (TextView) findViewById(R.id.resultTxt);
        nameETxt = (EditText) findViewById(R.id.nameETxt);
        mailETxt = (EditText) findViewById(R.id.mailETxt);

        View.OnClickListener oclOkBttn = new View.OnClickListener(){
            @Override
            public void onClick(View v){
                name = nameETxt.getText().toString();
                mail = mailETxt.getText().toString();
                if(name.equals("") && mail.equals("")) {
                    resultTxt.setText("Вы не ввели имя и почту, рассылка не оформлена.");
                } else if (name.equals("") && !mail.equals("")){
                    resultTxt.setText("Вы не ввели имя, рассылка не оформлена.");
                } else if (!name.equals("") && mail.equals("")){
                    resultTxt.setText("Вы не ввели почту, рассылка не оформлена.");
                } else {
                    resultTxt.setText("Подписка на рассылку успешно оформлена на пользователя " + name + " на электронный адрес " + mail + ".");
                }
            }
        };

        View.OnClickListener oclClearBttn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameETxt.setText("");
                mailETxt.setText("");
            }
        };

        okBttn.setOnClickListener(oclOkBttn);
        clearBttn.setOnClickListener(oclClearBttn);

    }
}
