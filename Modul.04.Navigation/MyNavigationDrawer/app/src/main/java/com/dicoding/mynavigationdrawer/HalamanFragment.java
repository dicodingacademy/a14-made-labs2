package com.dicoding.mynavigationdrawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HalamanFragment extends Fragment {


    public static final String EXTRAS = "extras";
    public HalamanFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_halaman, container, false);

        TextView textView = (TextView) view.findViewById(R.id.tv_fragment);

        /*
        Ambil data dari arguments yang dikirimkan oleh activity
         */
        String halaman = getArguments().getString(EXTRAS);
        textView.setText(halaman);

        return view;
    }

}
