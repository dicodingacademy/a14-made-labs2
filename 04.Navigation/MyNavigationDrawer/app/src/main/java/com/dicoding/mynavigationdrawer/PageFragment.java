package com.dicoding.mynavigationdrawer;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {

    static final String TAG = PageFragment.class.getSimpleName();

    public static final String EXTRAS = "extras";

    public PageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        TextView textView = view.findViewById(R.id.tv_fragment);

        /*
        Ambil data dari arguments yang dikirimkan oleh activity dengan mengecek terlebih dahulu apakah data tidak bernilai null
         */

        if (getArguments() != null) {
            String page = getArguments().getString(EXTRAS);
            textView.setText(page);

            Log.e(TAG, "onCreateView: halaman fragment " + page);
        }

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getArguments() != null && getActivity() != null) {
            String title = getArguments().getString(EXTRAS);

            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        }
    }
}
