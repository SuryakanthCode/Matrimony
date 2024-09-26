package com.example.matrimony.ui.component.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.matrimony.R
import com.example.matrimony.databinding.ItemHomeBinding
import com.example.matrimony.model.Profile
import com.example.matrimony.utils.clicklistener.OnItemClickListener

class HomeAdapter(
    private val listener: OnItemClickListener,
    private val profile: ArrayList<Profile>,
    val context: Context
) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(profiles: Profile) {
            binding.apply {
                profile = profiles
                clickListener = listener
                position = bindingAdapterPosition
                yesString = "Yes"
                noString = "No"
                Glide.with(context).load(profiles.imageURI[0]).placeholder(R.drawable.placeholder)
                    .into(binding.imageView)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemHomeBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_home,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(profile[position])
    }

    override fun getItemCount(): Int {
        return profile.size
    }

    fun updateList(newProfileList: List<Profile>) {
        profile.clear()
        profile.addAll(newProfileList)
        notifyDataSetChanged()
    }
}