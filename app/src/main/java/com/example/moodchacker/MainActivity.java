package com.example.moodchacker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvOtvet, tvMainAnswer;
    private Random random;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGenerate = findViewById(R.id.btn_generate);
        tvOtvet = findViewById(R.id.tv_otvet);
        tvMainAnswer = findViewById(R.id.tvMainAnswer);
        imageView = findViewById(R.id.imageView);
        random = new Random();

        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNumber();
            }
        });
    }

    private void generateRandomNumber() {
        int generatedNumber = random.nextInt(100) + 1;
        tvOtvet.setText(generatedNumber + " %");
        printAnswer(generatedNumber);
    }

    private void printAnswer(int generatedNumber) {
        if (generatedNumber <= 48) {
            tvMainAnswer.setText("Поднажми!!");
            imageView.setImageResource(R.drawable.image_bad);
        } else if (generatedNumber <= 65) {
            tvMainAnswer.setText("Красавчик, уважаю");
            imageView.setImageResource(R.drawable.image_good);
        } else {
            tvMainAnswer.setText("YEAH BUDDY!");
            imageView.setImageResource(R.drawable.image_excellent);
        }
        imageView.setVisibility(View.VISIBLE);
        showToastMessage();
    }

    private void showToastMessage() {
        Toast.makeText(this, "Нажми ещё раз", Toast.LENGTH_SHORT).show();
    }
}
