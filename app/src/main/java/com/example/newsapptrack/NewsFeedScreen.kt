package com.example.newsapptrack

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun NewsFeedScreen(
    modifier: Modifier = Modifier,
    news: List<Article>,
    onArticleClick: (Int, Int) -> Unit,  // Pass IDs directly
    onBookmarkClick: (Article) -> Unit,
    bookmarkedArticles: List<Article>
) {
    LazyColumn( // For display the titles
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(news) { item -> // Iterate through the articles
            val isBookmarked = bookmarkedArticles.contains(item) // check if is bookmarked

            ArticleItem(
                article = item,
                isBookmarked = isBookmarked, // Indicate if the article bookmarked
                onBookmarkClick = { onBookmarkClick(item) },
                onClick = {
                    onArticleClick(item.titleResId, item.contentResId)  // Pass IDs and Navigate to details Screen
                }
            )
        }
    }
}
