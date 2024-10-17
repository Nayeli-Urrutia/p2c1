package gt.edu.umg.p2c1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import gt.edu.umg.p2c1.BaseDatos.DbContactos;
public class NuevoActivity extends AppCompatActivity {

    Button btnNuevo, btnCrearRegistro;  // Declaramos btnCrearRegistro
    EditText txtNombre, txtTelefono, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        // Inicializamos los elementos
        btnNuevo = findViewById(R.id.btnGuardar);
        btnCrearRegistro = findViewById(R.id.btnCrearRegistro);  // Inicializamos btnCrearRegistro
        txtNombre = findViewById(R.id.txtNombre);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtEmail = findViewById(R.id.txtEmail);

        // Evento para guardar un nuevo contacto
        btnNuevo.setOnClickListener(v -> {
            DbContactos dbContactos = new DbContactos(this);
            long id = dbContactos.insertaContacto(txtNombre.getText().toString(), txtTelefono.getText().toString(), txtEmail.getText().toString());
            if (id > 0) {
                txtNombre.setText("");
                txtTelefono.setText("");
                txtEmail.setText("");
                Toast.makeText(this, "Contacto guardado", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error al guardar el contacto", Toast.LENGTH_SHORT).show();
            }
        });

        // Evento para crear un nuevo registro (o cualquier acción que desees ejecutar)
        btnCrearRegistro.setOnClickListener(v -> {
            Toast.makeText(this, "Creando nuevo registro", Toast.LENGTH_SHORT).show();

        });
    }
}