package com.dicoding.picodiploma.mytablayout

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dicoding.picodiploma.mytablayout.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    companion object {

        private val ARG_SECTION_NUMBER = "section_number"

        fun newInstance(index: Int): HomeFragment {
            val fragment = HomeFragment()
            val bundle = Bundle()
            bundle.putInt(ARG_SECTION_NUMBER, index)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var index = 1
        if (getArguments() != null) {
            index = arguments?.getInt(ARG_SECTION_NUMBER, 0) as Int
        }

        binding.sectionLabel.text = "${getString(R.string.content_tab_text)} $index"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
