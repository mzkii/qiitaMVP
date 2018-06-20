package com.mzkii.dev.qiitamvp

data class Item(var createdAt: String,
                var updatedAt: String,
                var likesCount: Int,
                var reactionsCount: Int,
                var comments_count: Int,
                var id: String,
                var private: Boolean,
                var title: String,
                var url: String,
                var user: User)