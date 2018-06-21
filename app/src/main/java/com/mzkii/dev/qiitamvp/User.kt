package com.mzkii.dev.qiitamvp

import java.io.Serializable

data class User(val facebookId: String,
                val followersCount: String,
                val githubLoginName: String,
                val itemsCount: String,
                val linkedinId: String,
                val profileImageUrl: String,
                val twitterScreenName: String,
                val websiteUrl: String,
                val description: String,
                val id: String,
                val location: String,
                val name: String,
                val organization: String) : Serializable