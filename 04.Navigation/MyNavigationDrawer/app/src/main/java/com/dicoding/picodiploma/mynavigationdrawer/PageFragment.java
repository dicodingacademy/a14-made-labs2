package com.dicoding.picodiploma.mynavigationdrawer;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {

    public static final String EXTRAS = "extras";

    TextView textView;

    public PageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        textView = view.findViewById(R.id.tv_fragment);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /*
        Ambil data dari arguments yang dikirimkan oleh activity
         */
        if (getArguments() != null) {
            String title = getArguments().getString(EXTRAS);

            // Update string textview
            textView.setText(title);

            Activity activity = getActivity();
            if (activity != null) {
                ActionBar actionBar = ((AppCompatActivity) activity).getSupportActionBar();
                if (actionBar != null) {

                    // Update title actionbar-nya
                    actionBar.setTitle(title);
                }
            }
        }
    }
}
