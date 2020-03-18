package com.example.yash.maybeagame;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Yash on 13-03-2018.
 */

public class Util {

    public static CustomButton[][] getIds(MainActivity activity, Context context){
        CustomButton[][] id = new CustomButton[9][9];

        id[0][0] = (CustomButton) activity.findViewById( R.id.row0_0);
        id[0][1] = (CustomButton) activity.findViewById( R.id.row0_1);
        id[0][2] = (CustomButton) activity.findViewById( R.id.row0_2);
        id[0][3] = (CustomButton) activity.findViewById( R.id.row0_3);
        id[0][4] = (CustomButton) activity.findViewById( R.id.row0_4);
        id[0][5] = (CustomButton) activity.findViewById( R.id.row0_5);
        id[0][6] = (CustomButton) activity.findViewById( R.id.row0_6);
        id[0][7] = (CustomButton) activity.findViewById( R.id.row0_7);
        id[0][8] = (CustomButton) activity.findViewById( R.id.row0_8);

        id[1][0] = (CustomButton) activity.findViewById( R.id.row1_0);
        id[1][1] = (CustomButton) activity.findViewById( R.id.row1_1);
        id[1][2] = (CustomButton) activity.findViewById( R.id.row1_2);
        id[1][3] = (CustomButton) activity.findViewById( R.id.row1_3);
        id[1][4] = (CustomButton) activity.findViewById( R.id.row1_4);
        id[1][5] = (CustomButton) activity.findViewById( R.id.row1_5);
        id[1][6] = (CustomButton) activity.findViewById( R.id.row1_6);
        id[1][7] = (CustomButton) activity.findViewById( R.id.row1_7);
        id[1][8] = (CustomButton) activity.findViewById( R.id.row1_8);

        id[2][0] = (CustomButton) activity.findViewById( R.id.row2_0);
        id[2][1] = (CustomButton) activity.findViewById( R.id.row2_1);
        id[2][2] = (CustomButton) activity.findViewById( R.id.row2_2);
        id[2][3] = (CustomButton) activity.findViewById( R.id.row2_3);
        id[2][4] = (CustomButton) activity.findViewById( R.id.row2_4);
        id[2][5] = (CustomButton) activity.findViewById( R.id.row2_5);
        id[2][6] = (CustomButton) activity.findViewById( R.id.row2_6);
        id[2][7] = (CustomButton) activity.findViewById( R.id.row2_7);
        id[2][8] = (CustomButton) activity.findViewById( R.id.row2_8);

        id[3][0] = (CustomButton) activity.findViewById( R.id.row3_0);
        id[3][1] = (CustomButton) activity.findViewById( R.id.row3_1);
        id[3][2] = (CustomButton) activity.findViewById( R.id.row3_2);
        id[3][3] = (CustomButton) activity.findViewById( R.id.row3_3);
        id[3][4] = (CustomButton) activity.findViewById( R.id.row3_4);
        id[3][5] = (CustomButton) activity.findViewById( R.id.row3_5);
        id[3][6] = (CustomButton) activity.findViewById( R.id.row3_6);
        id[3][7] = (CustomButton) activity.findViewById( R.id.row3_7);
        id[3][8] = (CustomButton) activity.findViewById( R.id.row3_8);

        id[4][0] = (CustomButton) activity.findViewById( R.id.row4_0);
        id[4][1] = (CustomButton) activity.findViewById( R.id.row4_1);
        id[4][2] = (CustomButton) activity.findViewById( R.id.row4_2);
        id[4][3] = (CustomButton) activity.findViewById( R.id.row4_3);
        id[4][4] = (CustomButton) activity.findViewById( R.id.row4_4);
        id[4][5] = (CustomButton) activity.findViewById( R.id.row4_5);
        id[4][6] = (CustomButton) activity.findViewById( R.id.row4_6);
        id[4][7] = (CustomButton) activity.findViewById( R.id.row4_7);
        id[4][8] = (CustomButton) activity.findViewById( R.id.row4_8);

        id[5][0] = (CustomButton) activity.findViewById( R.id.row5_0);
        id[5][1] = (CustomButton) activity.findViewById( R.id.row5_1);
        id[5][2] = (CustomButton) activity.findViewById( R.id.row5_2);
        id[5][3] = (CustomButton) activity.findViewById( R.id.row5_3);
        id[5][4] = (CustomButton) activity.findViewById( R.id.row5_4);
        id[5][5] = (CustomButton) activity.findViewById( R.id.row5_5);
        id[5][6] = (CustomButton) activity.findViewById( R.id.row5_6);
        id[5][7] = (CustomButton) activity.findViewById( R.id.row5_7);
        id[5][8] = (CustomButton) activity.findViewById( R.id.row5_8);

        id[6][0] = (CustomButton) activity.findViewById( R.id.row6_0);
        id[6][1] = (CustomButton) activity.findViewById( R.id.row6_1);
        id[6][2] = (CustomButton) activity.findViewById( R.id.row6_2);
        id[6][3] = (CustomButton) activity.findViewById( R.id.row6_3);
        id[6][4] = (CustomButton) activity.findViewById( R.id.row6_4);
        id[6][5] = (CustomButton) activity.findViewById( R.id.row6_5);
        id[6][6] = (CustomButton) activity.findViewById( R.id.row6_6);
        id[6][7] = (CustomButton) activity.findViewById( R.id.row6_7);
        id[6][8] = (CustomButton) activity.findViewById( R.id.row6_8);

        id[7][0] = (CustomButton) activity.findViewById( R.id.row7_0);
        id[7][1] = (CustomButton) activity.findViewById( R.id.row7_1);
        id[7][2] = (CustomButton) activity.findViewById( R.id.row7_2);
        id[7][3] = (CustomButton) activity.findViewById( R.id.row7_3);
        id[7][4] = (CustomButton) activity.findViewById( R.id.row7_4);
        id[7][5] = (CustomButton) activity.findViewById( R.id.row7_5);
        id[7][6] = (CustomButton) activity.findViewById( R.id.row7_6);
        id[7][7] = (CustomButton) activity.findViewById( R.id.row7_7);
        id[7][8] = (CustomButton) activity.findViewById( R.id.row7_8);

        id[8][0] = (CustomButton) activity.findViewById( R.id.row8_0);
        id[8][1] = (CustomButton) activity.findViewById( R.id.row8_1);
        id[8][2] = (CustomButton) activity.findViewById( R.id.row8_2);
        id[8][3] = (CustomButton) activity.findViewById( R.id.row8_3);
        id[8][4] = (CustomButton) activity.findViewById( R.id.row8_4);
        id[8][5] = (CustomButton) activity.findViewById( R.id.row8_5);
        id[8][6] = (CustomButton) activity.findViewById( R.id.row8_6);
        id[8][7] = (CustomButton) activity.findViewById( R.id.row8_7);
        id[8][8] = (CustomButton) activity.findViewById( R.id.row8_8);
        
        return id;



    } 
    
    
    
    
    
    

    
    
}
