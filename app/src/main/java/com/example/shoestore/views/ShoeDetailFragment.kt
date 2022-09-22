package com.example.shoestore.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentShoeDetailBinding
import com.example.shoestore.models.Shoes
import com.example.shoestore.viewModels.ViewModelSheos

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val viewModel: ViewModelSheos by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shoe = Shoes("", "", "", "" ,"")
        binding.btnSave.setOnClickListener {
            if (ifAllInPutExist()){
                addNewShoe()
                findNavController().navigateUp()
            }else {
                Toast.makeText(context , "Please Enter All Edit Text" , Toast.LENGTH_LONG).show()
            }
        }
        binding.btnCancel.setOnClickListener {
            findNavController().navigate(
                ShoeDetailFragmentDirections.actionShoeDetailFragmentToSheoeListFragment()
            )
        }
    }
    private fun addNewShoe() {
        viewModel.addNewshoe(binding.shoe as Shoes)
    }

    private fun ifAllInPutExist(): Boolean {
        var name = (binding.EDName.text).toString()
        var size = (binding.EDSize.text).toString()
        var color = (binding.EDColor.text).toString()
        var type = (binding.EDType.text).toString()
        var description = (binding.EDDescription.text).toString()
        return (!name.isNullOrEmpty() && !size.isNullOrEmpty() && !color.isNullOrEmpty() && !type.isNullOrEmpty() && !description.isNullOrEmpty() )
    }



}