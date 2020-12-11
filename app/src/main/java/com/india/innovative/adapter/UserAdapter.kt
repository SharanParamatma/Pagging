package com.india.innovative.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.india.innovative.R
import com.india.innovative.ShowDetails
import com.india.innovative.model.User

class UserAdapter : PagedListAdapter<User, UserAdapter.UserViewHolder>(USER_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.user_list_item, parent, false)
        return UserViewHolder(view)
    }
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = getItem(position)
        user?.let { holder.bind(it) }

    }
    class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        
        private val userName = view.findViewById<TextView>(R.id.name)
        private val userEmail = view.findViewById<TextView>(R.id.email)
        private val constraintLayout=view.findViewById<ConstraintLayout>(R.id.constraintLayout)
        @SuppressLint("SetTextI18n")
        fun bind(user: User) {
            userName.text = "${user.name}  ${user.email}"
            userEmail.text = user.gender

            constraintLayout.setOnClickListener {

                val intent = Intent(userName.context, ShowDetails::class.java)
                intent.putExtra("data", user)
                userName.context.startActivity(intent)
            }

        }


    }
    companion object {
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
                oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
                newItem.id == oldItem.id
        }
    }
}