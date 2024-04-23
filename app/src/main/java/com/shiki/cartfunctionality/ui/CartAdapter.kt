package com.shiki.cartfunctionality.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shiki.cartfunctionality.databinding.AdapterCartListBinding
import com.shiki.cartfunctionality.model.CartItem
import javax.inject.Inject


class CartAdapter @Inject constructor(private val onItemClick: OnItemClickListener)
    : RecyclerView.Adapter<CartAdapter.CartlistViewHolder>(){

    interface OnItemClickListener {
        fun onClicked(prodname: CartItem): CartItem
    }

    var cart_item = mutableListOf<CartItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartlistViewHolder {
        val binding =
            AdapterCartListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartlistViewHolder(binding,onItemClick)
    }

    override fun onBindViewHolder(holder: CartlistViewHolder, position: Int) {
        holder.bind(cart_item[position])
    }

    override fun getItemCount(): Int {
        return cart_item.size
    }


  inner class CartlistViewHolder(
       val view: AdapterCartListBinding,
       onItemClick: OnItemClickListener
   ) :
        RecyclerView.ViewHolder(view.root),
   View.OnClickListener{

      private lateinit var cartItem: CartItem

       init {
           view.root.setOnClickListener(this)
       }
        fun bind(item: CartItem) {
            this.cartItem= item
            var init_quant= item.qty
            var total:Int?=0
            var price= item.Cartdata.unit_mrp
            view.tvProdName.text = item.Cartdata.product_name
            view.tvProductPrice.text = "\u20B9 : ${item.Cartdata.unit_mrp}"
            view.tvProdQuan.text=(item.qty).toString()

            view.btnIncrement.setOnClickListener(View.OnClickListener {
                if(init_quant>=0){
                    init_quant++
                    view.tvTotalProductPrice.text=((price.toInt()*init_quant.toInt()).toString())
                    view.tvProdQuan.text=(init_quant).toString()
                }
            })
            view.btnDecrement.setOnClickListener(View.OnClickListener {
                if(init_quant>=0){
                    init_quant--
                    total=(price.toInt()*init_quant.toInt())
                    view.tvTotalProductPrice.text=((price.toInt()*init_quant.toInt()).toString())
                    view.tvProdQuan.text=(init_quant).toString()
                }
            })
        }

       override fun onClick(v: View?) {
            onItemClick.onClicked(cartItem)
       }
   }

    fun updatecartItem(cart_item: List<CartItem>) {
            this.cart_item = cart_item.toMutableList()
        notifyItemRangeInserted(0, cart_item.size)
    }


}
