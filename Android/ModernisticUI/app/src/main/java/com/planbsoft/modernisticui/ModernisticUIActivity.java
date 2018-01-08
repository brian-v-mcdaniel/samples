package com.planbsoft.modernisticui;

import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;

// slide the slider bar to change the colors

public class ModernisticUIActivity extends AppCompatActivity {

    private static final String TAG = "ModernisticUIActivity";
    private static final int MAX_COLOR = 255;
    private SeekBar colorBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modernistic_ui);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // fill up array with the backgrounds we want to access
        final ColorDrawable[] boxes = new ColorDrawable[4];
        boxes[0] = (ColorDrawable)(findViewById(R.id.box1)).getBackground();
        boxes[1] = (ColorDrawable)(findViewById(R.id.box2)).getBackground();
        boxes[2] = (ColorDrawable)(findViewById(R.id.box3)).getBackground();
        boxes[3] = (ColorDrawable)(findViewById(R.id.box4)).getBackground();

        // fill up array with the original colors
        final int[][] colors = new int[4][3];

        colors[0][0] = Color.red(boxes[0].getColor());
        colors[0][1] = Color.green(boxes[0].getColor());
        colors[0][2] = Color.blue(boxes[0].getColor());

        colors[1][0] = Color.red(boxes[1].getColor());
        colors[1][1] = Color.green(boxes[1].getColor());
        colors[1][2] = Color.blue(boxes[1].getColor());

        colors[2][0] = Color.red(boxes[2].getColor());
        colors[2][1] = Color.green(boxes[2].getColor());
        colors[2][2] = Color.blue(boxes[2].getColor());

        colors[3][0] = Color.red(boxes[3].getColor());
        colors[3][1] = Color.green(boxes[3].getColor());
        colors[3][2] = Color.blue(boxes[3].getColor());

        colorBar = (SeekBar) findViewById(R.id.seekBar);
        colorBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                int red = 0;
                int green = 0;
                int blue = 0;
                // just change red and blue components for only the non-gray and non-white boxes
                // leave green components alone
                for (int i = 0; i < boxes.length; ++i) {
                    red = (colors[i][0] + progress) < MAX_COLOR ? colors[i][0] + progress : MAX_COLOR;
                    green = colors[i][1];
                    blue = (colors[i][2] + progress) < MAX_COLOR ? colors[i][2] + progress : MAX_COLOR;
                    boxes[i].setColor(Color.rgb(red, green, blue));
                }
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_modernistic_ui, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            DialogFragment moreInfo = new MoreInfoDialogFragment();
            moreInfo.show(getFragmentManager(), null);
        }

        return super.onOptionsItemSelected(item);
    }
}
