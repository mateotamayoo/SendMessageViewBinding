package com.example.sendmessageviewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sendmessageviewbinding.databinding.ActivitySendMessageBinding;
import com.example.sendmessageviewbinding.model.data.Message;
import com.example.sendmessageviewbinding.model.data.Person;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SendMessageActivity extends AppCompatActivity {

    private ActivitySendMessageBinding binding;
    public static final String TAG="SendMessageActivity";

    //region METODOS DEL CICLO DE VIDA
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"SendMessageActivity -> onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"SendMessageActivity -> onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"SendMessageActivity -> onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"SendMessageActivity -> onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Lo que creo en onCreate lo destruyo en este método
        binding = null;
        Log.d(TAG,"SendMessageActivity -> ondestroy");
    }
//endregion
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendMessageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //OPCIÓN 3: Expresión lambda para implementar el evento on click
        binding.fab.setOnClickListener(view -> {
                    sendMessage();
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection.
        switch (item.getItemId()) {
            case R.id.menu_aboutas:
                Intent intent = new Intent(this,AboutActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Método que construye el mensaje y lo envía a otra Activity*/
    public void sendMessage(){
        Intent intent = new Intent(this, ViewActivity.class);
        Bundle bundle = new Bundle();

        Person persone = new Person("Jose","Tamayo Rivera", "1");
        Person persond = new Person("Aureli","Medina", "2");

        Message message = new Message(1,((EditText)binding.edMessage).getText().toString(), persone,persond);

        bundle.putParcelable(Message.KEY,message);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
