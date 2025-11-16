package com.example.quotesapp.model

object QuotesData {
    private val allQuotes = listOf(
        Quote(
            id = 1,
            text = "Never forget those that helped before you even had to ask",
            author = "ig-glossy_minds",
            category = "Life"
        ),
        Quote(
            id = 2,
            text = "The price of greatness is responsibility",
            author = "ig-glossy_minds",
            category = "Success"
        ),
        Quote(
            id = 3,
            text = "Everything you can imagine is real",
            author = "Pablo Picasso",
            category = "Motivation"
        ),
        Quote(
            id = 4,
            text = "Believe you can and you're halfway there.",
            author = "Theodore Roosevelt",
            category = "Motivation"
        ),
        Quote(
            id = 5,
            text = "The future belongs to those who believe in the beauty of their dreams.",
            author = "Eleanor Roosevelt",
            category = "Motivation"
        ),
        Quote(
            id = 6,
            text = "Life is what happens when you're busy making other plans.",
            author = "John Lennon",
            category = "Life"
        ),
        Quote(
            id = 7,
            text = "Success is not final, failure is not fatal: it is the courage to continue that counts.",
            author = "Winston Churchill",
            category = "Success"
        ),
        Quote(
            id = 8,
            text = "The only true wisdom is in knowing you know nothing.",
            author = "Socrates",
            category = "Wisdom"
        ),
        Quote(
            id = 9,
            text = "Love all, trust a few, do wrong to none.",
            author = "William Shakespeare",
            category = "Love"
        ),
        Quote(
            id = 10,
            text = "The best way to predict the future is to create it.",
            author = "Peter Drucker",
            category = "Success"
        ),
        Quote(
            id = 11,
            text = "In the end, we only regret the chances we didn't take.",
            author = "Lewis Carroll",
            category = "Life"
        ),
        Quote(
            id = 12,
            text = "Your time is limited, don't waste it living someone else's life.",
            author = "Steve Jobs",
            category = "Motivation"
        ),
        Quote(
            id = 13,
            text = "The only impossible journey is the one you never begin.",
            author = "Tony Robbins",
            category = "Success"
        ),
        Quote(
            id = 14,
            text = "Wisdom begins in wonder.",
            author = "Socrates",
            category = "Wisdom"
        ),
        Quote(
            id = 15,
            text = "Where there is love there is life.",
            author = "Mahatma Gandhi",
            category = "Love"
        )
    )

    private val savedQuoteIds = mutableSetOf<Int>()

    fun getAllQuotes(): List<Quote> = allQuotes.map {
        it.copy(isSaved = savedQuoteIds.contains(it.id))
    }

    fun getQuotesByCategory(category: String): List<Quote> {
        return allQuotes.filter { it.category.equals(category, ignoreCase = true) }
            .map { it.copy(isSaved = savedQuoteIds.contains(it.id)) }
    }

    fun getSavedQuotes(): List<Quote> {
        return allQuotes.filter { savedQuoteIds.contains(it.id) }
            .map { it.copy(isSaved = true) }
    }

    fun toggleSaveQuote(quoteId: Int) {
        if (savedQuoteIds.contains(quoteId)) {
            savedQuoteIds.remove(quoteId)
        } else {
            savedQuoteIds.add(quoteId)
        }
    }
}