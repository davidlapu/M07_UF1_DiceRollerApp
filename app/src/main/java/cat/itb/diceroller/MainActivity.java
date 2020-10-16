package cat.itb.diceroller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button rollButton;
    ImageView dice1, dice2;
    int[] daus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollButton = findViewById(R.id.roll_button);
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
    }

    public void setDice() {
        dice1.setImageResource(daus[random6()]);
        dice2.setImageResource(daus[random6()]);
    }

    public int random6() {
        return (int) (Math.random() * ((6 - 1) + 1));
    }
}