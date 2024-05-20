package com.pavanvulisetti.myapplication.ui.usercards


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pavanvulisetti.myapplication.data.model.Result
import com.pavanvulisetti.myapplication.databinding.UserHorizontalListItemBinding

class UserHorizontalListAdapter(
    private val userList: ArrayList<Result>
) : RecyclerView.Adapter<UserHorizontalListAdapter.UserHorizontalListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHorizontalListItemViewHolder {
        return UserHorizontalListItemViewHolder(
            UserHorizontalListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserHorizontalListItemViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun addData(list: List<Result>) {
        userList.addAll(list)
    }

    class UserHorizontalListItemViewHolder(
        private val binding: UserHorizontalListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(userResult: Result) {
            binding.horizontalListUserNameTextView.text = "${userResult.name?.first}"
            Glide.with(binding.horizontalListImageView.context)
                .load(userResult.picture?.large)
                .into(binding.horizontalListImageView)
            itemView.setOnClickListener {
                //click functionality of User horizontal list card can be implemented here
            }
        }
    }
}