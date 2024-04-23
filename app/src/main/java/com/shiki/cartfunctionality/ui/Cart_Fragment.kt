package com.shiki.cartfunctionality.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.shiki.cartfunctionality.R
import com.shiki.cartfunctionality.databinding.FragmentCartBinding
import com.shiki.cartfunctionality.model.CartItem
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class Cart_Fragment : Fragment(),CartAdapter.OnItemClickListener{

    private var _binding:FragmentCartBinding ?= null
    private val binding get()=_binding!!


    private lateinit var viewModel: Cart_Item_ViewModel

    @Inject
    lateinit var cartAdapter: CartAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentCartBinding.inflate(inflater,container,false)
        return binding!!.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= ViewModelProvider(this).get(Cart_Item_ViewModel::class.java)

        setupRecyclerView()

        setObserver()
    }

    private fun setupRecyclerView() {
        binding.rvCartList.adapter = cartAdapter
    }

    private fun setObserver() {
        viewModel.res.observe(viewLifecycleOwner){
                    it.data?.data1?.let {
                            it1 -> cartAdapter.updatecartItem(it1)
                }
    }
        viewModel.openNewFragment.observe(viewLifecycleOwner, Observer { shouldOpen ->
            if (shouldOpen) {
                Produt_detail_Fragment()
                // After handling the event, reset the value in the ViewModel
                viewModel.onNewFragmentOpened()
            }
        })
    }


    override fun onClicked(prodname: CartItem) :CartItem{
        var values: CartItem=prodname
      Log.e("adapter clicked product: ", values.toString())
        return values
    }
}