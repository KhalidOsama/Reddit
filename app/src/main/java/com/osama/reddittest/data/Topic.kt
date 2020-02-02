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
    var upVotes: Int = 0,
    var downVotes: Int = 0)