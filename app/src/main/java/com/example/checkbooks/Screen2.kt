package com.example.checkbooks

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class Screen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val rvView = findViewById<RecyclerView>(R.id.rvView)
        rvView.layoutManager = LinearLayoutManager(this)
        val adapter = BookAdapter()
        rvView.adapter = adapter

        val btnDisplay = findViewById<Button>(R.id.btnView)
        val btnRating = findViewById<Button>(R.id.btnRating)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Will display list in RecyclerView by notifying the adapter to refresh
        btnDisplay.setOnClickListener {
            adapter.notifyDataSetChanged()
            Toast.makeText(this, "List refreshed.", Toast.LENGTH_SHORT).show()
        }

        // Calculate average rating and show as a toast
        btnRating.setOnClickListener {
            val ratings = BookStore.ratings
            if (ratings.isEmpty()) {
                Toast.makeText(this, "No ratings available.", Toast.LENGTH_SHORT).show()
            } else {
                var sum = 0f
                for (r in ratings) sum += r
                val avg = sum / ratings.size
                Toast.makeText(this, String.format(java.util.Locale.getDefault(), "Average rating: %.2f", avg), Toast.LENGTH_LONG).show()
            }
        }

        btnBack.setOnClickListener {
            finish() // go back to MainActivity
        }
    }

    // Simple RecyclerView Adapter defined inside the activity file to avoid adding new files.
    inner class BookAdapter : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_2, parent, false)
            return BookViewHolder(view)
        }

        override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
            val title = BookStore.titles.getOrNull(position) ?: ""
            val author = BookStore.authors.getOrNull(position) ?: ""
            val rating = BookStore.ratings.getOrNull(position)?.toString() ?: ""
            val comment = BookStore.comments.getOrNull(position) ?: ""
            // Use the two-line built-in layout: line1 = title - author, line2 = rating + comment
            holder.text1.text = java.lang.String.format(java.util.Locale.getDefault(), "%s - %s", title, author)
            holder.text2.text = java.lang.String.format(java.util.Locale.getDefault(), "Rating: %s | %s", rating, comment)
        }

        override fun getItemCount(): Int = BookStore.titles.size

        inner class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val text1: TextView = itemView.findViewById(android.R.id.text1)
            val text2: TextView = itemView.findViewById(android.R.id.text2)
        }
    }
}