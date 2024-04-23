package com.shiki.cartfunctionality.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.shiki.cartfunctionality.R
import com.shiki.cartfunctionality.databinding.FragmentCartBinding
import com.shiki.cartfunctionality.databinding.FragmentProdutDetailBinding
import com.shiki.cartfunctionality.model.CartItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class Produt_detail_Fragment : Fragment() {

    private var _binding: FragmentProdutDetailBinding?= null
    private val binding get()=_binding!!

    private lateinit var viewModel: Product_detail_ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding= FragmentProdutDetailBinding.inflate(inflater,container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel= ViewModelProvider(this).get(Product_detail_ViewModel::class.java)
        setObserver()
    }

    private fun setObserver() {
        viewModel.prodres.observe(viewLifecycleOwner){
            binding.tvProductName.text=it.product_name
            binding.tvQuantity.text=it.product_quantity.toString()
            binding.tvUnitMrp.text=it.product_price.toString()
            binding.tvTotalProductPrice.text= it.product_total.toString()
        }
    }


}