package com.jose.mascotas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jose.mascotas.commons.Constantes;
import com.jose.mascotas.commons.MailSender;

public class ContactoActivity extends AppCompatActivity {

    private EditText etContactoEmail;
    private EditText etContactoNombre;
    private EditText etContactoMensaje;

    private Button btnEnviarMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        Toolbar toolbar = (Toolbar) findViewById(R.id.appBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etContactoEmail = (EditText) findViewById(R.id.etContactoEmail);
        etContactoNombre = (EditText) findViewById(R.id.etContactoNombre);
        etContactoMensaje = (EditText) findViewById(R.id.etContactoMensaje);

    }

    public void sendEmail(View view) {
        String email = etContactoEmail.getText().toString().trim();
        String nombre = Constantes.SUBJECT + etContactoNombre.getText().toString().trim();
        String message = etContactoMensaje.getText().toString().trim();
        MailSender sm = new MailSender(this, email, nombre, message);
        sm.execute();
    }
}
