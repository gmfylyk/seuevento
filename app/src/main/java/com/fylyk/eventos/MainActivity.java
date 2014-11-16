package com.fylyk.eventos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.fylyk.eventos.adapters.Adapt;
import com.fylyk.eventos.adapters.InvitesAdapter;
import com.fylyk.eventos.Eventos;

public class MainActivity extends Activity {

    private final Activity ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(new Adapt(Samples.getSampleEvents(this).subList(0,3),this));
        viewsAdapters.setGridViewHeightBasedOnChildren(gridView, 3);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Eventos clickedEvent = (Eventos) adapterView.getAdapter().getItem(i);
                Intent inte = new Intent(ctx, Evento.class);
                inte.putExtras(clickedEvent.createBundle());
                startActivity(inte);
            }
        });


        ListView listView = (ListView)findViewById(R.id.inviteList);
        listView.setAdapter(new InvitesAdapter(Samples.getSampleEvents(this).subList(3,6),this));
        viewsAdapters.setListViewHeightBasedOnChildren(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                Eventos clickedEvent = (Eventos) adapterView.getAdapter().getItem(i);
                Intent inte = new Intent(ctx, Evento.class);
                inte.putExtras(clickedEvent.createBundle());
                startActivity(inte);
            }
        });
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

    public void newEvento(View view){
        Toast.makeText(this,"Um dia vai funcionar",Toast.LENGTH_SHORT).show();
    }
}
