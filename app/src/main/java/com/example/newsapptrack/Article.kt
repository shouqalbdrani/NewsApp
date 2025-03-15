package com.example.newsapptrack

import java.sql.Date

data class Article(
    val titleResId: Int,
    val contentResId: Int,
    val date: Date

    // create id for each news so it can handle in Translate
) {
    companion object {
        val Example1 = Article(
            titleResId = R.string.article_title_1,
            contentResId = R.string.article_content_1,
            date = Date.valueOf("2025-03-01")
        )
        val Example2 = Article(
            titleResId = R.string.article_title_2,
            contentResId = R.string.article_content_2,
            date = Date.valueOf("2025-03-02")
        )
        val Example3 = Article(
            titleResId = R.string.article_title_3,
            contentResId = R.string.article_content_3,
            date = Date.valueOf("2025-03-03")
        )
        val Example4 = Article(
            titleResId = R.string.article_title_4,
            contentResId = R.string.article_content_4,
            date = Date.valueOf("2025-03-04")
        )
        val Example5 = Article(
            titleResId = R.string.article_title_5,
            contentResId = R.string.article_content_5,
            date = Date.valueOf("2025-03-05")
        )
        val Example6 = Article(
            titleResId = R.string.article_title_6,
            contentResId = R.string.article_content_6,
            date = Date.valueOf("2025-03-06")
        )
    }
}
