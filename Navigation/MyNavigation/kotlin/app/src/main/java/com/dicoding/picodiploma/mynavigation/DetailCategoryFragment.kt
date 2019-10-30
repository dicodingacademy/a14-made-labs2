package com.dicoding.picodiploma.mynavigation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_detail_category.*

/**
 * A simple [Fragment] subclass.
 */
class DetailCategoryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val dataName = arguments?.getString(CategoryFragment.EXTRA_NAME)
//        val dataDescription = arguments?.getLong(CategoryFragment.EXTRA_STOCK)

        val dataName = DetailCategoryFragmentArgs.fromBundle(arguments as Bundle).name
        val dataDescription = DetailCategoryFragmentArgs.fromBundle(arguments as Bundle).stock

        tv_category_name.setText(dataName)
        tv_category_description.setText("Stock : $dataDescription")

        btn_profile.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_detailCategoryFragment_to_homeFragment)
        )

    }
}
