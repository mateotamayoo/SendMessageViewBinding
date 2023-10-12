package com.example.sendmessageviewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sendmessageviewbinding.databinding.ActivityViewBinding;
import com.example.sendmessageviewbinding.model.data.Message;

public class ViewActivity extends AppCompatActivity {

    private Message message;
    public static final String TAG="ViewActivity";
    private ActivityViewBinding binding;
    //region METODOS DEL CICLO DE VIDA
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"ViewActivity -> onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"ViewActivity -> onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"ViewActivity -> onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"ViewActivity -> onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Lo que creo en onCreate lo destruyo en este método
        binding = null;
        Log.d(TAG,"ViewActivity -> ondestroy");
    }
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle bundle = getIntent().getExtras();
        message = bundle.getParcelable(Message.KEY);
        initialiceView();

    }
    /*
    * Método que inicializa todas las vistas o widgets de la interfaz o del layout
    * */
    private void initialiceView() {
        binding.tvUserInfo.setText("La persona " + message.getSender().getName()+ " con dni "+ message.getSender().getDni()+ " te manda el mensaje");
        binding.tvMessage.setText(message.getContent().toString());
    }
}