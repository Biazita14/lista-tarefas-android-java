package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> tarefas;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTask = findViewById(R.id.editTask);
        Button btnAdd = findViewById(R.id.btnAdd);
        ListView listViewTasks = findViewById(R.id.listViewTasks);

        tarefas = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tarefas);
        listViewTasks.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = editTask.getText().toString();
                if (!texto.isEmpty()) {
                    tarefas.add(texto);
                    adapter.notifyDataSetChanged();
                    editTask.setText("");
                }
            }
        });
    }
}