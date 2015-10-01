package com.example.tacademy.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView resultView;
    Button btn;
    StringBuffer strBuffer1, strBuffer2;
    String operand1, operand2;
    double resultNum;
    char operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultView = (TextView)findViewById(R.id.textView2);
        strBuffer1 = new StringBuffer();
        strBuffer2 = new StringBuffer();


        for(int i=0; i<17; i++){
            String buttonID = "button" + i;
            int resID = getResources().getIdentifier(buttonID, "id", "com.example.tacademy.helloandroid");
            btn = (Button)findViewById(resID );
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int temp = 0;
                    for (int i = 0; i < 17; i++) {
                        String buttonID = "button" + i;
                        int resID = getResources().getIdentifier(buttonID, "id", "com.example.tacademy.helloandroid");
                        if (v.getId() == resID) {
                            temp = i;
                        }
                    }
                    if (temp < 10) {
                        strBuffer1.append(temp);
                        resultView.setText(strBuffer1.toString());
                    } else if (temp == 10) {

                        strBuffer1 = new StringBuffer();
                        strBuffer2 = new StringBuffer();
                        resultView.setText("0.0");
                    } else if (temp == 11) {

                        strBuffer1.append(".");
                        resultView.setText(strBuffer1.toString());
                    } else if (temp == 12) {

                        initNum();
                        switch (operator) {

                            case '+':
                                resultNum = Double.parseDouble(operand1) + Double.parseDouble(operand2);
                                resultView.setText(Double.toString(resultNum));
                                strBuffer1.append(resultNum);
                                break;
                            case '-':
                                resultNum = Double.parseDouble(operand2) - Double.parseDouble(operand1);
                                resultView.setText(Double.toString(resultNum));
                                strBuffer1.append(resultNum);
                                break;
                            case '*':
                                resultNum = Double.parseDouble(operand1) * Double.parseDouble(operand2);
                                resultView.setText(Double.toString(resultNum));
                                strBuffer1.append(resultNum);
                                break;
                            case '/':
                                resultNum = Double.parseDouble(operand2) / Double.parseDouble(operand1);
                                resultView.setText(Double.toString(resultNum));
                                strBuffer1.append(resultNum);
                                break;

                        }
                    } else if (temp == 13) {
                        if(!strBuffer2.toString().equals("")){
                            initNum();
                            resultNum = Double.parseDouble(operand1) + Double.parseDouble(operand2);
                            strBuffer1.append(resultNum);
                        }
                        strBuffer2 = strBuffer1;
                        strBuffer1 = new StringBuffer();
                        operator = '+';
                    } else if (temp == 14) {
                        if(!strBuffer2.toString().equals("")){
                            initNum();
                            resultNum = Double.parseDouble(operand2) - Double.parseDouble(operand1);
                            strBuffer1.append(resultNum);
                        }
                        strBuffer2 = strBuffer1;
                        strBuffer1 = new StringBuffer();
                        operator = '-';
                    } else if (temp == 15) {
                        if(!strBuffer2.toString().equals("")){
                            initNum();
                            resultNum = Double.parseDouble(operand2) * Double.parseDouble(operand1);
                            strBuffer1.append(resultNum);
                        }
                        strBuffer2 = strBuffer1;
                        strBuffer1 = new StringBuffer();
                        operator = '*';
                    } else if (temp == 16) {
                        if(!strBuffer2.toString().equals("")){
                            initNum();
                            resultNum = Double.parseDouble(operand2) / Double.parseDouble(operand1);
                            strBuffer1.append(resultNum);
                        }
                        strBuffer2 = strBuffer1;
                        strBuffer1 = new StringBuffer();
                        operator = '/';
                    }
                }
            });
        }



    }

    public void initNum(){
        operand1 = strBuffer1.toString();
        operand2 = strBuffer2.toString();
        strBuffer1 = new StringBuffer();
        strBuffer2 = new StringBuffer();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
