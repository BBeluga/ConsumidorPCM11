package com.netec.consumidorpcm11;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv= (TextView) findViewById(R.id.tvListar);

        consultar();
    }

    private void consultar() {
        Context contexto = getApplicationContext();
        Uri uri = Uri.parse ("content://" + "gruposalinas" + "/" + "CalificacionesCP");

        Cursor cursor = contexto.getContentResolver().query(uri,
                null,null,null,null);

        if (cursor!=null) {

            while (cursor.moveToNext()){
                tv.append( cursor.getInt(0) + " ");
                tv.append( cursor.getString(1) + " ");
                tv.append( cursor.getFloat(3) + "\n");
            }
        } else {
            Toast.makeText(contexto, "Consultar() invalido", Toast.LENGTH_LONG ).show();
        }
    }
}
