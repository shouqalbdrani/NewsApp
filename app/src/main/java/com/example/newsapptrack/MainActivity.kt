package com.example.newsapptrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.newsapptrack.ui.theme.NewsAppTrackTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            // Theme state or switch between light and dark theme
            var darkTheme by remember { mutableStateOf(false) }
            // List for track bookmarked news
            val bookmarkedArticles = remember { mutableStateListOf<Article>() }
            // Tracks the state of language drop down
            var languageMenuExpanded by remember { mutableStateOf(false) }

            NewsAppTrackTheme(darkTheme = darkTheme) {
                val navController = rememberNavController()

                // Top bar structure , title of the app , language selection , Theme , Search

                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(
                                    text = stringResource(R.string.app_name),
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center
                                )
                            },
                            actions = {
                                // Language Change Button
                                IconButton(onClick = { languageMenuExpanded = true }) {
                                    Icon(
                                        imageVector = Icons.Default.Language,
                                        contentDescription = stringResource(R.string.change_language)
                                    )
                                }

                                DropdownMenu(
                                    expanded = languageMenuExpanded,
                                    onDismissRequest = { languageMenuExpanded = false }
                                ) {
                                    DropdownMenuItem(
                                        text = { Text("English") },
                                        onClick = {
                                            LanguageUtils.setAppLocale(this@MainActivity, "en")
                                            recreate()
                                        }
                                    )
                                    DropdownMenuItem(
                                        text = { Text("Arabic") },
                                        onClick = {
                                            LanguageUtils.setAppLocale(this@MainActivity, "ar")
                                            recreate()
                                        }
                                    )
                                }

                                IconButton(onClick = { darkTheme = !darkTheme }) {
                                    Icon(
                                        imageVector = if (darkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
                                        contentDescription = "Toggle Theme"
                                    )
                                }

                                IconButton(onClick = { }) {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = "Search"
                                    )
                                }
                            }
                        )
                    }
                ) { innerPadding ->
                    NavHost( // Start from news Feed screen which have titles of news and bookmark icon
                        navController = navController,
                        startDestination = "newsFeed"
                    ) {
                        composable("newsFeed") {
                            NewsFeedScreen(
                                modifier = Modifier.padding(innerPadding),
                                news = listOf(
                                    Article.Example1,
                                    Article.Example2,
                                    Article.Example3,
                                    Article.Example4,
                                    Article.Example5,
                                    Article.Example6
                                ),
                                onArticleClick = { titleId, contentId ->
                                    navController.navigate("newsDetail/$titleId/$contentId")
                                },
                                onBookmarkClick = { article ->
                                    if (bookmarkedArticles.contains(article)) {
                                        bookmarkedArticles.remove(article)
                                    } else {
                                        bookmarkedArticles.add(article)
                                    }
                                },
                                bookmarkedArticles = bookmarkedArticles
                            )
                        }

                        // News Detail Screen Route
                        composable("newsDetail/{titleId}/{contentId}") { backStackEntry ->
                            val titleId = backStackEntry.arguments?.getString("titleId")?.toIntOrNull()
                            val contentId = backStackEntry.arguments?.getString("contentId")?.toIntOrNull()

                            NewsDetailScreen(
                                title = titleId?.let { stringResource(id = it) } ?: "Unknown Title",
                                content = contentId?.let { stringResource(id = it) } ?: "Content Unavailable"
                            )
                        }
                    }
                }
            }
        }
    }
}
