package com.ravi.shaadimatches.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ravi.shaadimatches.R
import com.ravi.shaadimatches.data.model.ShaadiMatchesModel
import com.ravi.shaadimatches.ui.ShaadiMatchesListAdapter.ShaadiMatchesListViewHolder
import com.ravi.shaadimatches.util.Utility
import kotlinx.android.synthetic.main.row_item.view.*
import kotlin.reflect.KFunction1

class ShaadiMatchesListAdapter internal constructor(
    val mContext: Context, var mItems: MutableList<ShaadiMatchesModel>, val mOnClickListener: KFunction1<View?, Unit>
) : RecyclerView.Adapter<ShaadiMatchesListViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ShaadiMatchesListViewHolder {
        val rowItemBinding: View =
            LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return ShaadiMatchesListViewHolder(rowItemBinding)
    }

    override fun onBindViewHolder(
        viewHolder: ShaadiMatchesListViewHolder,
        position: Int
    ) {
        val item = mItems[position]
        viewHolder.bind(item, viewHolder)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun setItems(list: List<ShaadiMatchesModel>?) {
        mItems.clear()
        mItems.addAll(list!!)
        notifyDataSetChanged()
    }

    inner class ShaadiMatchesListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(shaadiMatchesModel: ShaadiMatchesModel, viewHolder: ShaadiMatchesListViewHolder) {
            Utility.printLog(
                TAG, shaadiMatchesModel.toString()
            )
            viewHolder.itemView.accept_button.setTag(R.string.click_tag, shaadiMatchesModel)
            viewHolder.itemView.accept_button.setOnClickListener(mOnClickListener)
            viewHolder.itemView.reject_buttuon.setTag(R.string.click_tag, shaadiMatchesModel)
            viewHolder.itemView.reject_buttuon.setOnClickListener(mOnClickListener)

            viewHolder.itemView.name.text = String.format(
                "%s %s",
                shaadiMatchesModel.name.first,
                shaadiMatchesModel.name.last
            )
            viewHolder.itemView.age.text = shaadiMatchesModel.dob.age.toString()
            Glide.with(viewHolder.itemView.context).load(shaadiMatchesModel.picture.large)
                .into(viewHolder.itemView.image)
            if (shaadiMatchesModel.isAccept || shaadiMatchesModel.isReject) {
                Log.d(TAG, "bind: if ")
                viewHolder.itemView.button_container.visibility = View.GONE
                viewHolder.itemView.selected_container.visibility = View.VISIBLE
                if (shaadiMatchesModel.isAccept) {
                    viewHolder.itemView.selected_text.setTextColor(
                        ContextCompat.getColor(
                            viewHolder.itemView.context,
                            R.color.accepted
                        )
                    )
                    viewHolder.itemView.selected_text.text =
                        viewHolder.itemView.context.resources.getString(R.string.accept_text)
                } else if (shaadiMatchesModel.isReject) {
                    viewHolder.itemView.selected_text.setTextColor(
                        ContextCompat.getColor(
                            viewHolder.itemView.context,
                            R.color.rejected
                        )
                    )
                    viewHolder.itemView.selected_text.text =
                        viewHolder.itemView.context.resources.getString(R.string.rejected_text)
                }
            } else {
                Log.d(TAG, "bind: else ")
                itemView.button_container.visibility = View.VISIBLE
                itemView.selected_container.visibility = View.GONE
            }
        }

    }

    companion object {
        private const val TAG = "ShaadiMatchesListAdapte"
    }

}