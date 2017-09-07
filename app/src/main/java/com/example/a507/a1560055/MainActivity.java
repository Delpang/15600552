package com.example.a507.a1560055;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int ct;
    Button btn;
    TextView Count;

    Handler mHandler = new Handler(){
        public void handleMessage(Message msg) {
            Count = (TextView) findViewById(R.id.Count);
            ct++;
            Count.setText(ct+"");
            mHandler.sendEmptyMessageDelayed(10,100);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.btn);

        btn.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        mHandler.sendEmptyMessageDelayed(10,0);
                        return false;
                    }
                }
        );
    }

    public void mOnClick(View v){
        Count = (TextView) findViewById(R.id.Count);
        ct++;
        Count.setText(ct+"");
        mHandler.removeMessages(10);
    }
}
