package com.example.yash.maybeagame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    CustomButton[][] buttons ;
    int countFlagMax = 9;
    int countMine = 0;
    HashMap<Button,ArrayList<CustomButton>> hashMap = new HashMap<Button,ArrayList<CustomButton>>();
    Time time = new Time();

    final CustomButton.OnClickListener onClickListener = new CustomButton.OnClickListener() {
        @Override
        public void onClick(View view) {
             CustomButton customButton = (CustomButton) view;
             if(customButton.isOpened){

             }else{
                 if(customButton.hasMine){
                     customButton.setText("M");
                     Toast.makeText(getApplicationContext(),"Better Luck Next Time",Toast.LENGTH_SHORT).show();
                     resetGame(buttons);
                 }else{
                        customButton.isOpened = true;
                        customButton.setClickable(false);
                        if(customButton.neighborMineCount > 0)
                            customButton.setText(""+customButton.neighborMineCount);
                        else{
                            customButton.setText(""/**/+customButton.neighborMineCount/**/);
                            ArrayList<CustomButton> zeroArrayListNegi = new ArrayList<CustomButton>();
                            if (hashMap.containsKey(customButton)){
                                zeroArrayListNegi.addAll(hashMap.get(customButton));
                                hashMap.remove(customButton);}
                            while(zeroArrayListNegi.size() != 0){
                                CustomButton tempButton = zeroArrayListNegi.remove(0);
                                tempButton.setClickable(false);
                                if(!tempButton.hasFlag && !tempButton.isOpened){
                                    tempButton.setText(""/**/+tempButton.neighborMineCount/**/);
                                    if(tempButton.neighborMineCount == 0){
                                        if(hashMap.containsKey(tempButton))
                                            zeroArrayListNegi.addAll(hashMap.remove(tempButton));
                                    }

                                }

                            }

                        }
                 }
             }
        }
    } ;


    final CustomButton.OnLongClickListener onLongClickListener = new CustomButton.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            CustomButton customButton = (CustomButton) view;

            if(! customButton.isOpened && countFlagMax >= 0){

                if(customButton.hasFlag  ) {
                    customButton.hasFlag = false;
                    customButton.setText("");
                    countFlagMax += 1;
                    if (customButton.hasMine)
                        countMine -= 1;
                }
                else {
                    if(countFlagMax > 0) {
                        customButton.hasFlag = true;
                        customButton.setText("F");
                        countFlagMax -= 1;
                        if(customButton.hasMine)
                            countMine += 1;
                    }
                }
                if(countMine == 9){
                    /*synchronized (time){
                        time.hasStop = true;
                        Toast.makeText(getApplicationContext(),""+time.time,Toast.LENGTH_SHORT).show();
                    }*/
                    Toast.makeText(getApplicationContext(),"You Won",Toast.LENGTH_SHORT).show();
                    resetGame(buttons);
                }
            }else{
                Toast.makeText(getApplicationContext(),""+countFlagMax,Toast.LENGTH_SHORT).show();
            }

            return true;
        }
    };



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttons = Util.getIds(MainActivity.this , this);
        for(Integer i=0;i<9;i++)
            for(Integer j=0;j<9;j++)
            {
                buttons[i][j].setOnClickListener(onClickListener);
                buttons[i][j].setOnLongClickListener(onLongClickListener);
                buttons[i][j].row = i;
                buttons[i][j].col = j;
            }
        resetGame(buttons);
        CustomButton newButton = new CustomButton(this);
        newButton.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        newButton.setText("Hello");
        ((LinearLayout)findViewById(R.id.rootLayout)).addView(newButton);



    }

    private void resetGame(CustomButton[][] buttons) {

        hashMap.clear();
        countFlagMax = 9 ;
        countMine = 0;

        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                buttons[i][j].hasFlag = false;
                buttons[i][j].isOpened = false;
                buttons[i][j].hasMine = false;
                buttons[i][j].setText("");
            }

        Random random = new Random();
        for(int i = 0 ; i < 9 ; ){
            int val = random.nextInt(81);
            int temp = (int) (val % 10);
            if(temp == 9)
                temp -= 1;
            CustomButton button = buttons[(int)(val / 10)][temp];
            if(! button.hasMine)
            {
                button.hasMine = true;
                i++;
            }
        }

        for(int row=0;row<9;row++){

            for(int col=0;col<9;col++){

                if (row == 0){
                    if(col == 0){
                        if(! buttons[row][col].hasMine) {
                            int countNei = 0;
                            countNei += buttons[0][1].hasMine();
                            countNei += buttons[1][0].hasMine();
                            countNei += buttons[1][1].hasMine();
                            buttons[row][col].neighborMineCount = countNei;
                            if(countNei == 0){
                                ArrayList<CustomButton> arrayList = new ArrayList<CustomButton>();
                                arrayList.add(buttons[0][1]);
                                arrayList.add(buttons[1][0]);
                                arrayList.add(buttons[1][1]);
                                hashMap.put(buttons[row][col],arrayList);
                            }
                        }
                            }
                    else if(col == 8) {
                        if (!buttons[row][col].hasMine) {
                            int countNei = 0;
                            countNei += buttons[0][7].hasMine();
                            countNei += buttons[1][8].hasMine();
                            countNei += buttons[1][7].hasMine();
                            buttons[row][col].neighborMineCount = countNei;
                            if(countNei == 0){
                                ArrayList<CustomButton> arrayList = new ArrayList<CustomButton>();
                                arrayList.add(buttons[0][7]);
                                arrayList.add(buttons[1][8]);
                                arrayList.add(buttons[1][7]);
                                hashMap.put(buttons[row][col],arrayList);
                            }
                        }
                    }
                    else{
                            if(! buttons[row][col].hasMine) {
                                int countNei = 0;
                                countNei += buttons[row][col + 1].hasMine();
                                countNei += buttons[row][col - 1].hasMine();
                                countNei += buttons[row + 1][col - 1].hasMine();
                                countNei += buttons[row + 1][col].hasMine();
                                countNei += buttons[row + 1][col + 1].hasMine();
                                buttons[row][col].neighborMineCount = countNei;
                                if(countNei == 0){
                                    ArrayList<CustomButton> arrayList = new ArrayList<CustomButton>();
                                    arrayList.add(buttons[row][col + 1]);
                                    arrayList.add(buttons[row][col - 1]);
                                    arrayList.add(buttons[row+ 1][col - 1]);
                                    arrayList.add(buttons[row + 1][col]);
                                    arrayList.add(buttons[row + 1][col + 1]);
                                    hashMap.put(buttons[row][col],arrayList);
                                }
                            }
                        }

                } else if(row == 8){

                    if(col == 0){
                        if(! buttons[row][col].hasMine) {
                            int countNei = 0;
                            countNei += buttons[row - 1][col].hasMine();
                            countNei += buttons[row - 1][col + 1].hasMine();
                            countNei += buttons[row][col + 1].hasMine();
                            buttons[row][col].neighborMineCount = countNei;
                            if(countNei == 0){
                                ArrayList<CustomButton> arrayList = new ArrayList<CustomButton>();
                                arrayList.add(buttons[row-1][col]);
                                arrayList.add(buttons[row - 1][col + 1]);
                                arrayList.add(buttons[row][col + 1]);
                                hashMap.put(buttons[row][col],arrayList);
                            }
                        }
                    }
                    else if(col == 8) {
                        if (!buttons[row][col].hasMine) {
                            int countNei = 0;
                            countNei += buttons[row - 1][col - 1].hasMine();
                            countNei += buttons[row - 1][col].hasMine();
                            countNei += buttons[row][col - 1].hasMine();
                            buttons[row][col].neighborMineCount = countNei;
                            if(countNei == 0){
                                ArrayList<CustomButton> arrayList = new ArrayList<CustomButton>();
                                arrayList.add(buttons[row-1][col - 1]);
                                arrayList.add(buttons[row - 1][col]);
                                arrayList.add(buttons[row][col - 1]);
                                hashMap.put(buttons[row][col],arrayList);
                            }
                        }
                    }
                    else{
                        if(! buttons[row][col].hasMine) {
                            int countNei = 0;
                            countNei += buttons[row-1][col -1].hasMine();
                            countNei += buttons[row-1][col].hasMine();
                            countNei += buttons[row-1][col + 1].hasMine();
                            countNei += buttons[row][col - 1].hasMine();
                            countNei += buttons[row][col + 1].hasMine();
                            buttons[row][col].neighborMineCount = countNei;
                            if(countNei == 0){
                                ArrayList<CustomButton> arrayList = new ArrayList<CustomButton>();
                                arrayList.add(buttons[row-1][col-1]);
                                arrayList.add(buttons[row - 1][col]);
                                arrayList.add(buttons[row-1][col + 1]);
                                arrayList.add(buttons[row][col - 1]);
                                arrayList.add(buttons[row][col + 1]);
                                hashMap.put(buttons[row][col],arrayList);
                            }
                        }
                    }

                }
                else{
                    if (col == 0){
                        if (!buttons[row][col].hasMine) {
                            int countNei = 0;
                            countNei += buttons[row-1][col].hasMine();
                            countNei += buttons[row-1][col+1].hasMine();
                            countNei += buttons[row][col + 1].hasMine();
                            countNei += buttons[row + 1][col].hasMine();
                            countNei += buttons[row +1][col + 1].hasMine();
                            buttons[row][col].neighborMineCount = countNei;
                            if(countNei == 0){
                                ArrayList<CustomButton> arrayList = new ArrayList<CustomButton>();
                                arrayList.add(buttons[row-1][col]);
                                arrayList.add(buttons[row - 1][col + 1]);
                                arrayList.add(buttons[row][col + 1]);
                                arrayList.add(buttons[row + 1][col]);
                                arrayList.add(buttons[row + 1][col + 1]);
                                hashMap.put(buttons[row][col],arrayList);
                            }
                        }
                    } else if(col == 8){
                        if (!buttons[row][col].hasMine) {
                            int countNei = 0;
                            countNei += buttons[row-1][col].hasMine();
                            countNei += buttons[row - 1][col - 1].hasMine();
                            countNei += buttons[row][col - 1].hasMine();
                            countNei += buttons[row + 1][col - 1].hasMine();
                            countNei += buttons[row + 1][col].hasMine();
                            buttons[row][col].neighborMineCount = countNei;
                            if(countNei == 0){
                                ArrayList<CustomButton> arrayList = new ArrayList<CustomButton>();
                                arrayList.add(buttons[row-1][col]);
                                arrayList.add(buttons[row - 1][col -1]);
                                arrayList.add(buttons[row][col - 1]);
                                arrayList.add(buttons[row + 1][col]);
                                arrayList.add(buttons[row + 1][col - 1]);
                                hashMap.put(buttons[row][col],arrayList);
                            }
                        }
                    }else{
                        if (!buttons[row][col].hasMine) {
                            int countNei = 0;
                            countNei += buttons[row-1][col - 1].hasMine();
                            countNei += buttons[row-1][col].hasMine();
                            countNei += buttons[row-1][col + 1].hasMine();
                            countNei += buttons[row][col - 1].hasMine();
                            countNei += buttons[row][col + 1].hasMine();
                            countNei += buttons[row+1][col - 1].hasMine();
                            countNei += buttons[row+1][col].hasMine();
                            countNei += buttons[row+1][col + 1].hasMine();
                            buttons[row][col].neighborMineCount = countNei;
                            if(countNei == 0){
                                ArrayList<CustomButton> arrayList = new ArrayList<CustomButton>();
                                arrayList.add(buttons[row-1][col-1]);
                                arrayList.add(buttons[row-1][col]);
                                arrayList.add(buttons[row - 1][col + 1]);
                                arrayList.add(buttons[row][col - 1]);
                                arrayList.add(buttons[row][col + 1]);
                                arrayList.add(buttons[row + 1][col - 1]);
                                arrayList.add(buttons[row + 1][col]);
                                arrayList.add(buttons[row + 1][col + 1]);
                                hashMap.put(buttons[row][col],arrayList);
                            }
                        }
                    }

                }

            }
        }



        /*for (int row = 0; row < 9 ;row++){
            for(int col = 0;col<9;col++){
                if(buttons[row][col].hasMine)
                    buttons[row][col].setText("M");
                else
                    buttons[row][col].setText(""+buttons[row][col].neighborMineCount);
            }
        }
        Log.i("Size",""+hashMap.size());
        for (Button key : hashMap.keySet()){
            for(CustomButton b : hashMap.get((CustomButton)key)){
                System.out.println(b.row+" "+b.col);
            }
        }
*/
        /*Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while(true) {
                    synchronized (time) {
                        time.time += 1;
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if(time.hasStop){
                            break;
                        }

                    }
                }
            }
        };
        new Thread(runnable).start();
*/


    }

}
