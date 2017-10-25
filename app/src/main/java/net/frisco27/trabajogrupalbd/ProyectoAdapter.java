package net.frisco27.trabajogrupalbd;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.FontsContract;

/**
 * Created by Emiliano on 25/10/2017.
 */

public class ProyectoAdapter
{
    private static final String NAME = "proyecto";
    private SQLiteDatabase DB;

    public ProyectoAdapter(SQLiteDatabase sqlDB)
    {
        this.DB = sqlDB;
    }

    private class ColumnsimplementsBaseColumns
    {
        public final static  String ID = "proyecto_id";
        public  final static  String DESCRIPCION = "descripcion";
        public final static String COSTO = "costo";
        public final static String ClIENTE_ID = "cliente_id";

    }

    private final static  String[] COLUMNS = {Columns.ID,Columns.DESCRIPCION,Columns.COSTO,Columns.CLIENTE_ID};


    public final static  String CR_TABLE = "createtableifnoexists" + NAME + "(" +Columns.ID + "intergerprimarykeyautoincrement"
            + Columns.DESCRIPCION + "textnotnull" +Columns.COSTO + "real" + Columns.CLIENTE_ID +
            "integer,FOREIGN KEY(cleinte_ID) REFERENCES cliente(cliente_id))";


    public boolean insert(String descripcion,double costo,int cliente_id)
    {
        ContentValues values = new ContentValues();
        values.put(Columns.DESCRIPCION,descripcion);
        values.put(Columns.COSTO,costo);
        values.put(Columns.CLIENTE_ID,cliente_id);

        return DB.insert(NAME,null,values) > 0;
    }
    public Cursor getDescripcion()
    {
        String[] Columns = {Columns.DESCRIPCION};
        return DB.query(NAME,columns,null,null,null,null,null);
    }
    public String getName(){return NAME;}
    public  String[] getColumns(){return COLUMNS;}
    public boolean isEmpty()
    {
        return DB.query(NAME,COLUMNS,null,null,null,null,null).getCount() == 0;
    }
    public  Cursor getDatos()
    {
       return DB.query(NAME,COLUMNS,null,null,null,null,null);
    }

}
