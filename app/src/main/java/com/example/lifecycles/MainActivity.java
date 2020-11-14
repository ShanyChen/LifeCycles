package com.example.lifecycles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.os.SystemClock;

public class MainActivity extends AppCompatActivity {
    MyChronometer myChronometer;
    MyViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         myViewModel= new ViewModelProvider(this).get(MyViewModel.class);
        myChronometer=findViewById(R.id.meter);
        myChronometer.setElapseTime(myViewModel.getElapseTime());//elapseTime初始值为viewmodel中的值，这样就保证activity重新创建时不会置零
        getLifecycle().addObserver(myChronometer);

    }

    @Override
    protected void onResume() {
        super.onResume();
        myViewModel.setElapseTime(myChronometer.getElapseTime());//resume时获取elapseTime当前值
    }

    @Override
    protected void onPause() {
        super.onPause();
        myViewModel.setElapseTime(myChronometer.getElapseTime());//pause时获取elapseTime当前值
    }


}