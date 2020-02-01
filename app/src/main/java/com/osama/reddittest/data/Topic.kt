package com.osama.reddittest.data

/**
 * Class which provides a model for a Topic
 * @constructor Sets all properties of the topic
 * @property body the content of the topic
 * @property upVotes number of up votes
 * @property downVotes number of down votes
 */
data class Topic(
    val body: String,
    val upVotes: Int,
    val downVotes: Int)