package com.pavanvulisetti.myapplication.ui.usercards

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pavanvulisetti.myapplication.data.model.Result
import com.pavanvulisetti.myapplication.databinding.ItemBinding

class UserListAdapter(
    private val userList: ArrayList<Result>
) : RecyclerView.Adapter<UserListAdapter.UserDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDetailViewHolder {
        return UserDetailViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserDetailViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun addData(list: List<Result>) {
        userList.addAll(list)
    }

    class UserDetailViewHolder(
        private val binding: ItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(userResult: Result) {
            binding.userNameTextView.text = "${userResult.name?.first} ${userResult.name?.last}"
            binding.userEmailTextView.text = userResult.email
            binding.userPhoneTextView.text = userResult.phone
            Glide.with(binding.userImageView.context)
                .load(userResult.picture?.large)
                .into(binding.userImageView)
            itemView.setOnClickListener {
                //click functionality of User card can be implemented here
            }
        }
    }
}