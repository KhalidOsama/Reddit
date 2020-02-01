package com.osama.reddittest.topicslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osama.reddittest.R
import com.osama.reddittest.Utils.DateUtils
import com.osama.reddittest.data.Topic
import kotlinx.android.synthetic.main.topic_list_item.view.*

class TopicsListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items : List<Topic> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TopicViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.topic_list_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is TopicViewHolder -> {
                holder.bind(items.get(position))
            }
        }
    }

    fun submitList(topicsList: List<Topic>) {
        items = topicsList
    }

    class TopicViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        val topicBody = itemView.topic_body
        val topiDate = itemView.topic_date
        val bUpvote = itemView.b_upvote
        val bDownvote = itemView.b_downvote

        fun bind(topic: Topic) {
            topicBody.setText(topic.body)
            topiDate.setText(DateUtils.printDateFromUtc(topic.date))
            bUpvote.setText(topic.upVotes.toString())
            bDownvote.setText(topic.downVotes.toString())
        }
    }
}