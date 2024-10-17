package gt.edu.umg.p2c1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import gt.edu.umg.p2c1.BaseDatos.DbHelper;

public class MainActivity extends AppCompatActivity {

    Button btnSaludo, btnCrearDb;
    TextView tvSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSaludo = findViewById(R.id.btnSaludo);
        tvSaludo = findViewById(R.id.tvSaludo);
        btnCrearDb = findViewById(R.id.btnCrearDb);

        btnSaludo.setOnClickListener(view -> {
            Toast.makeText(this, "aviso Nayeli", Toast.LENGTH_SHORT).show();
            tvSaludo.setText("Hola Nayeli");
        });

        btnCrearDb.setOnClickListener(v -> {
            // Navegar a NuevoActivity
            Intent intent = new Intent(MainActivity.this, NuevoActivity.class);
            startActivity(intent);
        });

        // Manejo de los Window Insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}