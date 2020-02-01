package com.osama.reddittest.data

/**
 * Class which provides a model for a Topic
 * @property topicId id of the topic
 * @property body the content of the topic
 * @property upVotes number of up votes
 * @property downVotes number of down votes
 */
data class Topic(
    val topicId: String,
    val body: String,
    val date: Long,
    val upVotes: Int,
    val downVotes: Int)