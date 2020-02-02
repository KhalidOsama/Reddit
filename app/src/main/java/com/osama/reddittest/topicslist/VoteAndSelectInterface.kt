package com.osama.reddittest.topicslist

interface VoteAndSelectInterface {
    fun upVote(topicId: String)
    fun downVote(topicId: String)
    fun itemSelected(topicId: String)
}