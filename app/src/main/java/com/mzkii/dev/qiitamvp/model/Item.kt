package com.mzkii.dev.qiitamvp.model

import java.io.Serializable

data class Item(val body: String,
                val createdAt: String,
                val updatedAt: String,
                val likesCount: Int,
                val reactionsCount: Int,
                val commentsCount: Int,
                val id: String,
                val private: Boolean,
                val title: String,
                val url: String,
                val user: User) : Serializable