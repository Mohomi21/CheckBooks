# ThemBooks (CheckBooks)

Simple beginner Kotlin Android app to store book details, allow ratings and comments. This project uses four parallel mutable lists (title, author, rating, comment) in a singleton `BookStore` object.

Contents
- Overview
- Requirements
- How to build & run (Windows PowerShell)
- App usage (Main screen and Screen2)
- Screenshots & placeholders (add your screenshots here)
- Troubleshooting
- Code notes and mapping to requirements
- Next steps / Improvements

---

Overview
--------
ThemBooks is a small Android application (Kotlin) meant for learning. It stores book information in four parallel lists and provides a simple UI to add new books, view the list, and compute an average rating.

The app is intentionally simple and uses only the files already in the repo (no extra files were added for app logic). A RecyclerView on the second screen displays the current entries.

Built-in sample books:
- The 48 Laws of Power — Robert Greene
- Meditations — Marcus Aurelius
- Beyond Good and Evil — Friedrich Nietzsche
- The Republic — Plato


Usage / UI
----------
Main screen (MainActivity)
- Fields (EditTexts): `txtBook` (Title), `txtAuthor` (Author), `txtRating` (Rating, numeric), `txtComment` (Comment).
- Buttons:
  - `btnAdd` — validates input and adds the book to the four parallel arrays. Validation rules: title & author required, rating numeric between 0.0 and 5.0, comment length between 5 and 200 characters.
  - `btnView` — navigates to the second screen (`Screen2`).
  - `btnOut` — exits the app.

Screen2 (Screen2)
- `rvView` — RecyclerView that lists current book entries using the built-in two-line item layout.
- Buttons:
  - `btnView` (labeled "Display") — refreshes the RecyclerView (calls notifyDataSetChanged()).
  - `btnRating` (labeled "Rating") — computes and shows the average rating in a Toast.
  - `btnBack` — returns to the main screen.

Screenshots 
--------------------------


Main screen UI :
![Main screen screenshot](<img width="703" height="535" alt="ma1" src="https://github.com/user-attachments/assets/bbbb5142-51b9-4838-a745-ffc4030b6bf7" />
)

Main screen while running :
![Main running screenshot - Main]!<img width="1005" height="594" alt="error" src="https://github.com/user-attachments/assets/e52e944e-a611-4b8e-b1a1-9023be3e483c" />



Screen2 UI :
![Screen2 UI screenshot](<img width="668" height="509" alt="ma2" src="https://github.com/user-attachments/assets/49b57193-54ec-47b0-95f7-50a56df735d4" />
)

Screen2 while running (:
![Screen2 running screenshot] <img width="1005" height="594" alt="image" src="https://github.com/user-attachments/assets/8984ce6d-71e6-4b71-adfd-cda8f64df926" />


Tips for taking screenshots
- On emulator: use Android Studio's emulator screenshot tool (three-dot menu → Screenshot) and save the PNG into `screenshots/`.
- On a device: capture the screen, transfer the image into the project `screenshots/` folder, and commit.


Code notes and mapping to requirements
-------------------------------------
- Four parallel lists: `BookStore.titles`, `BookStore.authors`, `BookStore.ratings`, `BookStore.comments` (in `MainActivity.kt`).
- Input validation: implemented in `MainActivity.kt` before adding values to the lists.
- RecyclerView: simple adapter defined inside `Screen2.kt` to avoid creating extra files — displays the lists in order.


Next steps / improvements
-------------------------
- Improve layouts (constraints, margins) and add a custom item layout for RecyclerView to show nicer cards.
- Would be better to have some sort of built in ai that tells you in-depth descriptions about the books
