package com.dicoding.picodiploma.mynavigationdrawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 */
class PageFragment : Fragment() {

    private lateinit var textView: TextView

    companion object {
        const val EXTRAS = "extras"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_page, container, false)

        textView = view.findViewById(R.id.tv_fragment)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        /*
        Ambil data dari arguments yang dikirimkan oleh activity
         */
        when {
            arguments != null -> {
                val title = arguments?.getString(EXTRAS)

                // Update string textview
                textView.text = title

                val activity = activity
                when {
                    activity != null -> {
                        val actionBar = (activity as AppCompatActivity).supportActionBar
                        when {
                            actionBar != null -> // Update title actionbar-nya
                                actionBar.title = title
                        }
                    }
                }
            }
        }
    }


}