package com.example.lifecycles;

import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private long elapseTime;
    public long getElapseTime() {
        return elapseTime;
    }

    public void setElapseTime(long elapseTime) {
        this.elapseTime = elapseTime;
    }
}
