package com.github.donkirkby.webandnative;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    private TextView greetingText;
    private EditText nameText;
    private Greeter greeter = new Greeter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        greetingText = (TextView)findViewById(R.id.textView1);
        nameText = (EditText)findViewById(R.id.editText1);
        List<String> greetings = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    getAssets().open("greetings.txt")));
            try {
                String line;
                while (null != (line = reader.readLine())) {
                    greetings.add(line);
                }
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            greetings.add("Failed to open file. " + e.getMessage());
        }
        greeter.loadGreetings(greetings);
        greet("World");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
    
    public void greet(View view) {
        greet(nameText.getText().toString());
    }
    
    private void greet(String name) {
        greetingText.setText(greeter.greet(name));
    }
}
