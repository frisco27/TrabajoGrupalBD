package net.frisco27.trabajogrupalbd;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import net.frisco27.trabajogrupalbd.R;

/**
 * Created by Emiliano on 24/10/2017.
 */

public class ListActivity extends ActionBarActivity
{
    private TextView lista;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        lista = (TextView)findViewById(R.id.tvlista);
        for(String it:((BaseApplication)getApplication()).nombresClientes())
        {
            lista.setText(lista.getText()+it);
        }
    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
     getMenuInflater().inflate(R.menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id == R.id.)
        {
        return true;
        }
     return super.onOptionsItemSelected(item);
    }
}

