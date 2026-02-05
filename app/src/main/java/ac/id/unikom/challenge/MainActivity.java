package ac.id.unikom.challenge;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements MainView {

    private EditText meter;
    private EditText kilometer;
    private EditText centimeter;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        meter = findViewById(R.id.meter);
        kilometer = findViewById(R.id.kilometer);
        centimeter = findViewById(R.id.centimeter);

        meter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable editable) {
                presenter.calculateLength();
            }
        });
    }

    @Override
    public String getMeter() {
        return meter.getText().toString();
    }

    @Override
    public void showKilometer(String kilometerValue) {
        kilometer.setText(kilometerValue);
    }

    @Override
    public void showCentimeter(String centimeterValue) {
        centimeter.setText(centimeterValue);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
