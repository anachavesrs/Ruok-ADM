package br.com.up.ruokAdmin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import br.com.up.ruokAdmin.adapter.HumorAdapter;
import br.com.up.ruokAdmin.model.Humor;
import br.com.up.ruokAdmin.repository.GiftRepository;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fabAddHumor;
    private RecyclerView recyclerViewHumor;
    private TextView textViewHumorNotFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fabAddHumor = findViewById(R.id.fab_add_humor);
        recyclerViewHumor = findViewById(R.id.recycler_humor);
        textViewHumorNotFound = findViewById(R.id.text_humor_not_found);

        recyclerViewHumor.setLayoutManager(
                new LinearLayoutManager(this,
                        RecyclerView.VERTICAL,
                        false)
                //new GridLayoutManager(this,8)
        );


        fabAddHumor.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(
                        getApplicationContext(),
                        AddHumorActivity.class
                );
                startActivity(intent);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<Humor> humores = GiftRepository.getInstance().getAll();

        if(humores.size() > 0){
            textViewHumorNotFound.setVisibility(View.INVISIBLE);
        }else{
            textViewHumorNotFound.setVisibility(View.VISIBLE);
        }

        recyclerViewHumor.setAdapter(new HumorAdapter(humores));
    }
}