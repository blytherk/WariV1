package com.example.blythekirby.wariv1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MyActivity extends Activity {


    Button[] buttonArray = new Button[12];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        buttonArray[0] = (Button) findViewById(R.id.button0);
        buttonArray[1] = (Button) findViewById(R.id.button1);
        buttonArray[2] = (Button) findViewById(R.id.button2);
        buttonArray[3] = (Button) findViewById(R.id.button3);
        buttonArray[4] = (Button) findViewById(R.id.button4);
        buttonArray[5] = (Button) findViewById(R.id.button5);
        buttonArray[6] = (Button) findViewById(R.id.button6);
        buttonArray[7] = (Button) findViewById(R.id.button7);
        buttonArray[8] = (Button) findViewById(R.id.button8);
        buttonArray[9] = (Button) findViewById(R.id.button9);
        buttonArray[10] = (Button) findViewById(R.id.button10);
        buttonArray[11] = (Button) findViewById(R.id.button11);

    }

    public int nextIndex(int index)
    {
        index++;
        if (index >= buttonArray.length)
        {
            return 0;
        }
        else
        {
            return index;
        }
    }

    public void sendMessage(View view)
    {
        Button clickButton = (Button) view;

        int i;
        for(i = 0; buttonArray[i] != clickButton; i++);

        int handfull = Integer.parseInt(clickButton.getText().toString());


        if (handfull > 0)
        {

            clickButton.setText("0");
            playCup(this, handfull, i);
        }
    }

    public void playCup(Activity activityIn, int handfullIn, int indexIn)
    {

        while (handfullIn != 0)
        {
            indexIn = nextIndex(indexIn);
            int seedCount = Integer.parseInt(buttonArray[indexIn].getText().toString());
            seedCount++;
            buttonArray[indexIn].setText(seedCount + "");
            handfullIn--;

            if (handfullIn == 2 || handfullIn == 3)
            {
                if (indexIn <= 5)
                {
                    TextView capturedCup = (TextView) activityIn.findViewById(R.id.p1Win);
                    int captuedCount = Integer.parseInt(capturedCup.getText().toString());
                    captuedCount += seedCount;
                    capturedCup.setText(captuedCount + "");
                }
                else
                {
                    TextView capturedCup = (TextView) activityIn.findViewById(R.id.p2Win);
                    int captuedCount = Integer.parseInt(capturedCup.getText().toString());
                    captuedCount += seedCount;
                    capturedCup.setText(captuedCount + "");
                }
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
