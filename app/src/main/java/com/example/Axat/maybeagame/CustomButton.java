package com.example.yash.maybeagame;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by Yash on 13-03-2018.
 */

public class CustomButton extends android.support.v7.widget.AppCompatButton {

    Boolean isOpened = false;
    Boolean hasFlag = false;
    Boolean hasMine = false;
    int row = 0;
    int col = 0;
    int neighborMineCount = 0;

    public CustomButton(Context context) {
        super(context);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public int hasMine(){
        if(hasMine)
            return 1;
        else
            return 0;
    }


}
