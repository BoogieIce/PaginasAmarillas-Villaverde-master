package com.villaverde.labcalificado.activitys;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.villaverde.labcalificado.R;

public class DatosActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton internet, correo, mensaje, llamada, compartir;
    String phone, image, url, direction, email, name, description, categoria;
    Bundle extra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        extra = getIntent().getExtras();

        if(extra != null) {
            phone = extra.getString("phone");
            description = extra.getString("descrip");
            image = extra.getString("image");
            name = extra.getString("name");
            email = extra.getString("email");
            direction = extra.getString("direction");
            categoria = extra.getString("categoria");
            url = extra.getString("url");
        }

        TextView textView = findViewById(R.id.name_company);
        TextView textView1 = findViewById(R.id.phone_company);
        TextView textView2 = findViewById(R.id.description_company);
        TextView textView3 = findViewById(R.id.email_company);
        TextView textView4 = findViewById(R.id.direction_company);

        ImageView imageView = findViewById(R.id.image_company);

        textView.setText(name);
        textView1.setText(phone);
        textView2.setText(description);
        textView3.setText(email);
        textView4.setText(direction);



        switch (image) {
            case "imagen1":
                imageView.setImageResource(R.drawable.imagen1);
                break;
            case "imagen2":
                imageView.setImageResource(R.drawable.imagen2);
                break;
            case "imagen3":
                imageView.setImageResource(R.drawable.imagen3);
                break;
            case "imagen4":
                imageView.setImageResource(R.drawable.imagen4);
                break;
            case "imagen5":
                imageView.setImageResource(R.drawable.imagen5);
                break;
            case "imagen6":
                imageView.setImageResource(R.drawable.imagen6);
                break;
            case "imagen7":
                imageView.setImageResource(R.drawable.imagen7);
                break;
            case "st":
                imageView.setImageResource(R.drawable.st);
                break;
            case "kfc":
                imageView.setImageResource(R.drawable.kfc);
                break;
            case "pizza":
                imageView.setImageResource(R.drawable.pizza);
                break;
        }

        internet = findViewById(R.id.internet);
        internet.setOnClickListener(this);
        correo = findViewById(R.id.correo);
        correo.setOnClickListener(this);
        mensaje = findViewById(R.id.mensaje);
        mensaje.setOnClickListener(this);
        compartir = findViewById(R.id.compartir);
        compartir.setOnClickListener(this);
        llamada = findViewById(R.id.llamada);
        llamada.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        eventProcess(v.getId());
    }

    public void eventProcess(int option){
        switch (option){
            case R.id.internet:
                redirectURL();
            break;
            case R.id.correo:
                redirectEmail();
                break;
            case R.id.mensaje:
                redirectSMS();
                break;
            case R.id.compartir:
                redirectShare();
                break;
            case R.id.llamada:
                redirectCall();
                break;
        }
    }
    public  void redirectURL(){
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }


    public void redirectSMS(){
        String message = "";
        String phoneNo = "phone";

        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneNo));
        smsIntent.putExtra("sms_body", message);
        startActivity(smsIntent);
//        Intent intent = new Intent(Intent.ACTION_SEND);
//        intent.setType("text/plain");
//        intent.putExtra(Intent.EXTRA_TEXT, "El mejor blog de android http://javaheros.blogspot.pe/");
//        startActivity(Intent.createChooser(intent, "Share with"));
    }
    public void redirectEmail(){
        String[] TO = {email};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Tu mensaje..");

        try {
            startActivity(Intent.createChooser(emailIntent, "Enviar email"));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(DatosActivity.this,
                    "No tienes clientes de email instalados.", Toast.LENGTH_SHORT).show();
        }

    }
    public void redirectShare(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "El mejor blog de android http://javaheros.blogspot.pe/");
        startActivity(Intent.createChooser(intent, "Share with"));
    }

    public void redirectCall(){
        String phoneNo = "phone";
        String dial = "tel:" + phoneNo;
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(dial)));
    }


}
