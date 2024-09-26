package com.example.matrimony.ui.component.gesture

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.matrimony.R
import com.example.matrimony.databinding.ItemCardViewBinding
import com.example.matrimony.model.Profile
import com.example.matrimony.utils.clicklistener.OnItemClickListener

class CardPagerAdapter(private val listener: OnItemClickListener, private val profiles: ArrayList<Profile>, val context: Context) :
    RecyclerView.Adapter<CardPagerAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemCardViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(profiles: Profile) {
            binding.apply {
                profile = profiles
                clickListener = listener
                position = bindingAdapterPosition
                yesString = "Yes"
                noString = "No"
                executePendingBindings()
                Glide.with(context).load(profiles.imageURI[0]).placeholder(R.drawable.placeholder)
                    .into(binding.imageView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(profiles[position])
    }

    override fun getItemCount(): Int = profiles.size

    fun updateList(newProfileList: List<Profile>) {
        profiles.clear()
        profiles.addAll(newProfileList)
        notifyDataSetChanged()
    }
}