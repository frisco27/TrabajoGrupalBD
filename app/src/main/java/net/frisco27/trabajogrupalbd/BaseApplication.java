package net.frisco27.trabajogrupalbd;

import android.app.Application;
import android.database.Cursor;

import net.frisco27.trabajogrupalbd.DBAdapter;

import java.util.ArrayList;

/**
 * Created by Emiliano on 24/10/2017.
 */

public class BaseApplication extends Application
{
    DBAdapter dbAdapter;

    public void onCreate()
    {
        dbAdapter = new DBAdapter(getApplicationContext());
        dbAdapter.open();
        super.onCreate();
    }
    public void onTerminate()
    {
        dbAdapter.close();
        super.onTerminate();
    }
    public void rellenarDatosTabla()
    {
        if(dbAdapter.)
        {
            for(int i= 0;i < 30;i++)
            {
                String nombre = "nombre" + String.valueOf(i);
                String apellido = "apellido" + String.valueOf(i);
                String numero = "555-" + String.valueOf(i);
                dbAdapter.clienteInsert(nombre,apellido,numero);
            }
        }
    }
    public boolean insertarCliente(String nombre,String apellido,String telefono)
    {
        return dbAdapter.clienteInsert(nombre,apellido,telefono);
    }

    public ArrayList<String> nombresClientes()
    {
        ArrayList<String> lista = new ArrayList<String>();
        Cursor c= dbAdapter.getDatosCliente();
        if(c.moveToFirst())
        {
            do
            {
                lista.add(c.getString(1));
            }while(c.moveToNext());
        }
        return  lista;
    }
}
