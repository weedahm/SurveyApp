package com.example.myapplication.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;

public class MainButton extends ConstraintLayout {

    private final String TAG = MainButton.class.getSimpleName();

    Context context;
    View rootView, bgView;
    TextView textView;
    ImageView imageView;

    public MainButton(Context context) {
        this(context, null);
    }

    public MainButton(final Context context, @Nullable AttributeSet attrs) {

        super(context, attrs);
        this.context = context;

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MainButton, 0, 0);
        String text = typedArray.getString(R.styleable.MainButton_text);
        int bgColor = -1;
        if(typedArray.hasValue(R.styleable.MainButton_bg)) {
            bgColor = typedArray.getColor(R.styleable.MainButton_bg, 0);
        }
        int imgResource = typedArray.getResourceId(R.styleable.MainButton_img, 0);
        typedArray.recycle();

        rootView = inflate(context, R.layout.view_main_btn, this);

        bgView = rootView.findViewById(R.id.main_root);
        if (bgColor >= 0){
            bgView.setBackgroundResource(0);
            bgView.setBackgroundColor(bgColor);
        }
        textView = rootView.findViewById(R.id.main_btn_text);
        textView.setText(text);

        imageView = rootView.findViewById(R.id.main_btn_img);
        imageView.setImageResource(imgResource);

        rootView.setOnTouchListener(new OnTouchListener () {
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    textView.setTextColor(ContextCompat.getColor(context, R.color.GRAY_80));
                    imageView.setColorFilter(ContextCompat.getColor(context, R.color.GRAY_80));

                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    textView.setTextColor(getResources().getColor(R.color.GRAY_00));
                    imageView.setColorFilter(ContextCompat.getColor(context, R.color.GRAY_00));

                    view.performClick();
                }
                return true;
            }
        });
    }
}
