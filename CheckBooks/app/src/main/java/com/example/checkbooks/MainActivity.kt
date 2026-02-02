package com.example.checkbooks

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

// Simple singleton to hold the four parallel arrays (lists).
// Kept in this file so we don't add new files
object BookStore {
    val titles = mutableListOf(
        "The 48 Laws of Power",
        "Meditations",
        "Beyond Good and Evil",
        "The Republic"
    )
    val authors = mutableListOf(
        "Robert Greene",
        "Marcus Aurelius",
        "Friedrich Nietzsche",
        "Plato"
    )
    val ratings = mutableListOf(4.0f, 4.5f, 4.2f, 4.3f)
    val comments = mutableListOf(
        "A compelling look at power dynamics.",
        "Deep and calming philosophical reflections.",
        "Challenging and thought-provoking.",
        "A foundational work of political philosophy."
    )
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Find UI elements
        val txtBook = findViewById<EditText>(R.id.txtBook)
        val txtAuthor = findViewById<EditText>(R.id.txtAuthor)
        val txtRating = findViewById<EditText>(R.id.txtRating)
        val txtComment = findViewById<EditText>(R.id.txtComment)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnView = findViewById<Button>(R.id.btnView)
        val btnOut = findViewById<Button>(R.id.btnOut)

        // Add info button
        btnAdd.setOnClickListener {
            val title = txtBook.text.toString().trim()
            val author = txtAuthor.text.toString().trim()
            val ratingText = txtRating.text.toString().trim()
            val comment = txtComment.text.toString().trim()

            if (title.isEmpty() || author.isEmpty()) {
                Toast.makeText(this, "Please enter both title and author.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val rating = try {
                ratingText.toFloat()
            } catch (_: Exception) {
                Toast.makeText(this, "Please enter a numeric rating (0.0 - 5.0).", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (rating < 0f || rating > 5f) {
                Toast.makeText(this, "Rating must be between 0 and 5.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Comment length check (not too short, not too long)
            if (comment.length < 5) {
                Toast.makeText(this, "Comment is too short (min 5 characters).", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (comment.length > 200) {
                Toast.makeText(this, "Comment is too long (max 200 characters).", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Add to lists
            BookStore.titles.add(title)
            BookStore.authors.add(author)
            BookStore.ratings.add(rating)
            BookStore.comments.add(comment)

            Toast.makeText(this, "Book added.", Toast.LENGTH_SHORT).show()

            // Clear inputs for convenience
            txtBook.text.clear()
            txtAuthor.text.clear()
            txtRating.text.clear()
            txtComment.text.clear()
        }

        // View / Next button: open Screen2
        btnView.setOnClickListener {
            startActivity(Intent(this, Screen2::class.java))
        }

        // Exit button: close the app
        btnOut.setOnClickListener {
            // finishAffinity closes this activity and all parent activities
            finishAffinity()
        }
    }
}