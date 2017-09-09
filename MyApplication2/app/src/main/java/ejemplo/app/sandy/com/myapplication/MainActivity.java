package ejemplo.app.sandy.com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button miBtn;
    EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // miBtn.setText("Mi super boton");
        miBtn = (Button) findViewById (R.id.btnMensaje);
        nombre = (EditText) findViewById(R.id.txtNombre);
        miBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getApplicationContext(),OtraActividad.class);
                i.putExtra("param1","hola Mun");
                i.putExtra("param2",1);
                //startActivity(i);
                startActivityForResult(i,1000);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode== 1000 && resultCode==RESULT_OK){
            Toast.makeText(this, data.getStringExtra("paramreturn"),Toast.LENGTH_LONG).show();
        }
    }
}
