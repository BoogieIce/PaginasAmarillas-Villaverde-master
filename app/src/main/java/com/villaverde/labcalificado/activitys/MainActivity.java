package com.villaverde.labcalificado.activitys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;


import com.villaverde.labcalificado.R;
import com.villaverde.labcalificado.adapters.ComidaAdapter;
import com.villaverde.labcalificado.modelo.Comidas;
import com.villaverde.labcalificado.repositorios.ComidaRepositorio;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Comidas> ejemplo = ComidaRepositorio.getList();
    private RecyclerView recyclerView;
    EditText editText;
    ComidaAdapter comidaAdapter;
    ComidaAdapter ComidaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ComidaAdapter = new ComidaAdapter();
        ComidaAdapter.setPeople(ComidaRepositorio.getList());

        recyclerView.setAdapter(ComidaAdapter);
        editText = findViewById(R.id.buscador);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

    }
    private void filter(String a) {
        ArrayList<Comidas> filteredList = new ArrayList();

        for (Comidas item : ejemplo){
            if (item.getFullname().toLowerCase().contains(a.toLowerCase())){filteredList.add(item);}
        }
        ComidaAdapter.filterList(filteredList);
    }

}
