package com.pavanvulisetti.myapplication.ui.usercards

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pavanvulisetti.myapplication.data.model.Result
import com.pavanvulisetti.myapplication.databinding.TopHeadlineItemLayoutBinding

class UserListAdapter(
    private val userList: ArrayList<Result>
) : RecyclerView.Adapter<UserListAdapter.UserDetailViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDetailViewHolder {
        return UserDetailViewHolder(
            TopHeadlineItemLayoutBinding.inflate(
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
        private val binding: TopHeadlineItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(userResult: Result) {
            binding.textViewTitle.text = userResult.phone
            binding.textViewDescription.text = userResult.email
            binding.textViewSource.text = userResult.name.first
            Glide.with(binding.imageViewBanner.context)
                .load(userResult.picture.large)
                .into(binding.imageViewBanner)
            itemView.setOnClickListener {
                //click can be implemented later

            }
        }
    }
}