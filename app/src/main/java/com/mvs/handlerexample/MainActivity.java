package com.mvs.handlerexample;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int MAX_PROGRESS = 10;
    private Button button1;
    private ProgressBar progress;
    private TextView textView1;

  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initViews();

    }

    private void initViews() {
        button1=findViewById(R.id.btn_1);
        button1.setOnClickListener(this);
        progress=findViewById(R.id.pb_1);
        textView1=findViewById(R.id.tv1);
    }

    private void init() {

    }



    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_1)
        {
            startProgress(v);
        }
    }

    private void startProgress(View view) {
        textView1.setText("Started");
        Runnable runnable=new Runnable() {
            @Override
            public void run() {

                for(int i=0;i<=MAX_PROGRESS;i++)
                {
                    final int val=i;
                    try {
                        setDummyDelay();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progress.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if(val<MAX_PROGRESS)
                            {
                                textView1.setText("In Progress");
                                progress.setProgress(val);
                            }
                            else
                            {
                                textView1.setText("Completed");
                                progress.setProgress(MAX_PROGRESS);
                            }


                        }
                    },1000);


                }
            }
        };
        new Thread(runnable).start();
    }

    private void setDummyDelay() throws InterruptedException {
        Thread.sleep(1000);
    }
}
