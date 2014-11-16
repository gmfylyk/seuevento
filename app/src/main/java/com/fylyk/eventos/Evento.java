package com.fylyk.eventos;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


public class Evento extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event);

        Bundle b = getIntent().getExtras();

        TextView place = (TextView)findViewById(R.id.fEventPlace);
        TextView name = (TextView)findViewById(R.id.fEventName);
        TextView org = (TextView)findViewById(R.id.fEventOrganizer);
        ImageView image = (ImageView)findViewById(R.id.fEventImage);
        TextView date = (TextView)findViewById(R.id.fEventDate);

        date.setText(b.getString("date"));
        image.setImageResource(b.getInt("img"));
        name.setText(b.getString("name"));
        org.setText(b.getString("org"));
        place.setText(b.getString("place"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.menu_event, menu);
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
