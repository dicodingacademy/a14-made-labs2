package com.dicoding.picodiploma.mycustomview;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import static android.view.Gravity.CENTER;

public class MyButton extends android.support.v7.widget.AppCompatButton {

    // Konstruktor dari MyButton
    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    // Metode onDraw() digunakan untuk mengcustom button ketika enable dan disable
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Mengubah background dari Button
        setBackground(getResources().getDrawable(isEnabled() ? R.drawable.bg_button : R.drawable.bg_button_disable));

        // Mengubah warna text pada button
        setTextColor(ContextCompat.getColor(getContext(), android.R.color.background_light));

        // Mengubah ukuran text pada button
        setTextSize(12.f);

        // Menjadikan object pada button menjadi center
        setGravity(CENTER);

        // Mengubah text pada button pada kondisi enable dan disable
        setText(isEnabled() ? "Submit" : "Isi Dulu");
    }
}
