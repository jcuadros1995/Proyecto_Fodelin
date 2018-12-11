package co.edu.sanmateo.com.fodelin.Activities;

    import android.app.Activity;
    import android.app.ProgressDialog;
    import android.content.Context;
    import android.content.DialogInterface;
    import android.content.Intent;
    import android.support.design.widget.TextInputEditText;
    import android.support.v7.app.AlertDialog;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.support.v7.widget.AppCompatButton;
    import android.support.v7.widget.AppCompatTextView;
    import android.support.v7.widget.LinearLayoutManager;
    import android.support.v7.widget.RecyclerView;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.Adapter;
    import android.widget.AdapterView;
    import android.widget.ListAdapter;
    import android.widget.ListView;
    import android.widget.Toast;

    import com.android.volley.Request;
    import com.android.volley.Response;
    import com.android.volley.VolleyError;
    import com.android.volley.toolbox.JsonObjectRequest;

    import org.json.JSONArray;
    import org.json.JSONException;
    import org.json.JSONObject;

    import java.util.ArrayList;

    import co.edu.sanmateo.com.fodelin.Model.ItemResultados;
    import co.edu.sanmateo.com.fodelin.Model.VolleySingleton;
    import co.edu.sanmateo.com.fodelin.R;

    import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    AppCompatButton pdf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        final AppCompatTextView Nombres = (AppCompatTextView) findViewById( R.id.textViewName );

        Intent intent = getIntent();
        String nombres = intent.getStringExtra( "nombres" );
        String cedula = intent.getStringExtra( "cedula" );
        String telefono = intent.getStringExtra( "telefono" );
        String direccion = intent.getStringExtra( "direccion" );
        String email = intent.getStringExtra( "email" );
        pdf = (AppCompatButton)findViewById( R.id.pdfButtom );

        Nombres.setText( nombres );

        ItemResultados itemResultados_datos[] = new ItemResultados[]{
                new ItemResultados( R.drawable.fodelin, "Tac de craneo", "123456789", "10/12/2015", "intercontac center" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Operacion", "123456789", "10/12/2016", "ventanar" ),
                new ItemResultados( R.drawable.fodelin, "Cirugia", "123456789", "10/12/2017", "Atento" )};


        Adapter adapter = new co.edu.sanmateo.com.fodelin.Model.Adapter( this, R.layout.item_resultados, itemResultados_datos );

        listView = (ListView) findViewById( R.id.ListaResultados );

        listView.setAdapter( (ListAdapter) adapter );

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, ActivityPDF.class);
                intent.putExtra("Referencias", listView.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_exit, menu);
        return true;

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder myBuild = new AlertDialog.Builder(this);
        myBuild.setMessage("¿Deseas Salir?");
        myBuild.setTitle("Salir");
        myBuild.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(MainActivity.this, ActivityLogin.class);
                startActivity(intent);
                finishAffinity();
            }
        });

        myBuild.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = myBuild.create();
        dialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.exit) {
            AlertDialog.Builder myBuild = new AlertDialog.Builder(this);
            myBuild.setMessage("¿Deseas Salir?");
            myBuild.setTitle("Salir");
            myBuild.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(MainActivity.this, ActivityLogin.class);
                    startActivity(intent);
                    finishAffinity();
                }
            });

            myBuild.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
            AlertDialog dialog = myBuild.create();
            dialog.show();
        }else if (id == R.id.action_profile) {
            startActivity(new Intent(this, ActivityProfile.class));
        }

        return super.onOptionsItemSelected( item );
    }


}
