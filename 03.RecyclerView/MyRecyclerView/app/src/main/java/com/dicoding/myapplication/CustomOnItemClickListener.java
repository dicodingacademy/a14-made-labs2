package com.dicoding.myapplication;

import android.view.View;

/**
 * Created by sidiqpermana on 10/29/16.
 */

public class CustomOnItemClickListener implements View.OnClickListener {
    private int position;
    private OnItemClickCallback onItemClickCallback;
    CustomOnItemClickListener(int position, OnItemClickCallback onItemClickCallback) {
        this.position = position;
        this.onItemClickCallback = onItemClickCallback;
    }
    @Override
    public void onClick(View view) {
        onItemClickCallback.onItemClicked(view, position);
    }
    interface OnItemClickCallback {
        void onItemClicked(View view, int position);
    }
}
