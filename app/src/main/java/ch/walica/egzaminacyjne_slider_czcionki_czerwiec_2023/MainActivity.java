package ch.walica.egzaminacyjne_slider_czcionki_czerwiec_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvSentence, tvFontSize;
    private Button btnAction;

    private SeekBar seekBar;
    private String[] greetings = {"Dzień dobry", "Good morning", "Buenos dias"};
    private int currentIndex = 0;
    private int sizeOfFont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSentence = findViewById(R.id.tvSentence);
        tvFontSize = findViewById(R.id.tvFontSize);
        btnAction = findViewById(R.id.btnAction);
        seekBar = findViewById(R.id.seekBar);

        tvSentence.setText(greetings[currentIndex]);

        btnAction.setOnClickListener(view -> {
            if (currentIndex == greetings.length - 1) {
                currentIndex = 0;
                tvSentence.setText(greetings[currentIndex]);
            } else {
                currentIndex++;
                tvSentence.setText(greetings[currentIndex]);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sizeOfFont = progress;
                tvFontSize.setText("Rozmiar: " + sizeOfFont);
                tvSentence.setTextSize(sizeOfFont);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
}