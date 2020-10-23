package cat.itb.diceroller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button rollButton, resetButton;
    ImageView dice1, dice2;
    int[] daus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollButton = findViewById(R.id.roll_button);
        resetButton = findViewById(R.id.reset_button);
        dice1 = findViewById(R.id.dice1);
        dice2 = findViewById(R.id.dice2);
        daus = new int[]{R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3, R.drawable.dice_4,
                R.drawable.dice_5, R.drawable.dice_6};

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "botó apretat", Toast.LENGTH_SHORT).show();
                rollButton.setText(R.string.dRoll);
                setDice();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dice1.setImageResource(R.drawable.empty_dice);
                dice2.setImageResource(R.drawable.empty_dice);
            }
        });

        dice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDice1(random6());
            }
        });

        dice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setDice2(random6());
            }
        });
    }

    public void setDice1(int n) {
        dice1.setImageResource(daus[n]);
    }

    public void setDice2(int n) {
        dice2.setImageResource(daus[n]);
    }

    public void setDice() {
        int n1 = random6(), n2 = random6();

        setDice1(n1);
        setDice2(n2);

        if (n1 == 5 && n2 == 5) {
            sout("JACKPOT!");
        }
    }

    public int random6() {
        return (int) (Math.random() * 6);
    }

    public void sout(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }
}