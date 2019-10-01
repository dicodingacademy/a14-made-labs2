package com.dicoding.picodiploma.mynavigationdrawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_page.*

/**
 * A simple [Fragment] subclass.
 */
class PageFragment : Fragment() {

    companion object {
        const val EXTRAS = "extras"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        /*
        Ambil data dari arguments yang dikirimkan oleh activity
         */
        if (arguments != null) {
            val title = arguments?.getString(EXTRAS)

            // Update string textview
            tv_fragment.text = title

            val activity = activity
            if (activity != null) {
                val actionBar = (activity as AppCompatActivity).supportActionBar
                // Update title actionbar-nya
                if (actionBar != null) actionBar.title = title
            }
        }
    }
}