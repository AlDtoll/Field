package com.example.pusika.field;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Cell[] cells = new Cell[60];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ConstraintLayout constraintLayout = new ConstraintLayout(this);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT);
        setContentView(constraintLayout, layoutParams);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);


        int cols = 7;
        int WIDTH = (int) (size.x / (cols + 0.5));
        int HEIGHT = WIDTH;
        int rows;
        int counter = 0;
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell(0);
        }
        for (int i = 0; i < cols; i++) {
            if (i % 2 != 0) {
                rows = 7;
            } else {
                rows = 6;
            }
            for (int j = 0; j < rows; j++) {
                ImageView button = new ImageView(this);
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fog1);
                Drawable dr = new BitmapHexagonDrawable(bitmap);
                button.setImageDrawable(dr);
                button.setId(counter);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ImageView imageButton = findViewById(v.getId());
                        int picture = changeIcon(imageButton.getId());
//                        int picture = R.drawable.picture;
                        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), picture);
                        Drawable dr = new BitmapHexagonDrawable(bitmap);
                        imageButton.setImageDrawable(dr);
                    }
                });
                counter++;
                ConstraintLayout.LayoutParams buttonLayoutParams = new ConstraintLayout.LayoutParams(WIDTH, HEIGHT);
                buttonLayoutParams.leftMargin = 12 + (WIDTH) * i;
                if (i % 2 != 0) {
                    buttonLayoutParams.topMargin = 24 + (HEIGHT) * j;
                } else {
                    buttonLayoutParams.topMargin = 24 + (HEIGHT) * j + (HEIGHT) / 2;
                }
                buttonLayoutParams.startToStart = ConstraintLayout.LayoutParams.PARENT_ID;
                buttonLayoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
                constraintLayout.addView(button, buttonLayoutParams);
            }
        }
    }

    private int changeIcon(int numberOfCell) {
        Cell cell = cells[numberOfCell];
        cell.changeIcon();
        int icon = cells[numberOfCell].getIcon();
        switch (icon) {
            case Cell.WATER:
                return R.drawable.water1;
            case Cell.DESERT:
                return R.drawable.desert1;
            case Cell.FOREST:
                return R.drawable.forest1;
            case Cell.ROCK:
                return R.drawable.rock1;
            case Cell.FIELD:
                return R.drawable.field3;
            case Cell.HILL:
                return R.drawable.hill3;
            case Cell.SWAMP:
                return R.drawable.swamp1;
            case Cell.CASTLE:
                return R.drawable.castle3;
            default:
                return R.drawable.fog1;
        }
    }
}
