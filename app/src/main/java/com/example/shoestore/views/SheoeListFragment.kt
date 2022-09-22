package com.example.shoestore.views

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.shoestore.R
import com.example.shoestore.databinding.FragmentSheoeListBinding
import com.example.shoestore.databinding.MyCustmBinding
import com.example.shoestore.models.Shoes
import com.example.shoestore.viewModels.ViewModelSheos


class SheoeListFragment : Fragment() {

    private lateinit var binding: FragmentSheoeListBinding
    private val viewModel: ViewModelSheos by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate( inflater, R.layout.fragment_sheoe_list, container, false)
        binding.btnAdd.setOnClickListener {
            var action = SheoeListFragmentDirections.actionSheoeListFragmentToShoeDetailFragment()
            findNavController().navigate(action)
        }

        setHasOptionsMenu(true)

        checkChangeInViewModelData(inflater, container)

        return binding.root
    }


    private fun checkChangeInViewModelData(inflater: LayoutInflater, container: ViewGroup?) {
        checkIfThereIsNoData()
        viewModel.shoesList.observe(viewLifecycleOwner, Observer { shoesList ->
            shoesList.forEach {
                addNewLayout(it, inflater, container)
            }
        })

    }



    fun addNewLayout(shoes: Shoes, inflater: LayoutInflater, container: ViewGroup?) {
        val bindingCustm: MyCustmBinding = DataBindingUtil.inflate(inflater, R.layout.my_custm, container, false)
        bindingCustm.nameText.text = "Name = ${shoes.name}"
        bindingCustm.sizeText.text = "Size = ${shoes.size}"
        bindingCustm.colorText.text = "Color = ${shoes.color}"
        bindingCustm.typeText.text = "Type = ${shoes.type}"
        bindingCustm.descriptionText.text = "Type = ${shoes.descrition}"
        binding.listLayout.addView( bindingCustm.root)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_to_login_fragment -> findNavController().navigate(
                SheoeListFragmentDirections.actionSheoeListFragmentToLoginFragment2()
            )
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    private fun checkIfThereIsNoData() {
        viewModel.isListEmpty.observe(viewLifecycleOwner, Observer {
                isEmpty ->
            binding.tv.visibility = if (isEmpty) View.VISIBLE else View.GONE
        })
    }

}