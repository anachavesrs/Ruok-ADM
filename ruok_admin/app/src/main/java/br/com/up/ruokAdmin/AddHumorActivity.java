package br.com.up.ruokAdmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import br.com.up.ruokAdmin.model.Humor;
import br.com.up.ruokAdmin.repository.GiftRepository;

public class AddHumorActivity extends AppCompatActivity {

    private TextInputLayout inputLayoutId;
    private TextInputLayout inputLayoutData;
    private TextInputLayout inputLayoutHumor;

    private TextInputEditText inputEditTextId;
    private TextInputEditText inputEditTextData;
    private TextInputEditText inputEditTextHumor;

    private Button buttonAddHumor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_humor);

        inputLayoutId = findViewById(R.id.input_layout_id);
        inputLayoutData = findViewById(R.id.input_layout_data);
        inputLayoutHumor = findViewById(R.id.input_layout_humor);

        inputEditTextId = findViewById(R.id.input_text_id);
        inputEditTextData = findViewById(R.id.input_text_data);
        inputEditTextHumor = findViewById(R.id.input_text_humor);

        buttonAddHumor = findViewById(R.id.button_add_humor);

        buttonAddHumor.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveHumor();
            }
        });
    }

    private void saveHumor(){

        String id = inputEditTextId.getText().toString();
        String data = inputEditTextData.getText().toString();
        String humor_id = inputEditTextHumor.getText().toString();

        Humor humor = new Humor(
                id,
                data,
                humor_id
        );

        GiftRepository.getInstance().save(humor);

        onBackPressed();
    }
}