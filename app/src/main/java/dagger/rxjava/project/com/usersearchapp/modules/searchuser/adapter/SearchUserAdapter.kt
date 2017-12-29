package dagger.rxjava.project.com.usersearchapp.modules.searchuser.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.rxjava.project.com.usersearchapp.R
import dagger.rxjava.project.com.usersearchapp.mvp.model.SearchItem
import kotlinx.android.synthetic.main.adapter_user.view.*

/**
 * Created by bineesh on 29/12/17.
 */
class SearchUserAdapter (var context: Context?, var userList:MutableList<SearchItem>?):
        RecyclerView.Adapter<SearchUserAdapter.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val user=userList?.get(position)
        holder?.bindUser(user)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent?.context).inflate(R.layout.adapter_user,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return userList?.size?:0
    }

    class ViewHolder (itemView: View?) : RecyclerView.ViewHolder(itemView) {
        fun bindUser(user: SearchItem?) {
            with(user) {
                itemView.user_name.text=user?.login
            }

        }
    }
    fun updateUserList(list: MutableList<SearchItem>?) {
        userList=list
        notifyDataSetChanged()
    }

}