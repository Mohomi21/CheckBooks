If you'd like, I can now add a `screenshots/` folder and placeholder PNG files (empty) and update the README with exact filenames so you can drop your images in place. Which would you prefer next?

Where to add screenshots
------------------------
Create a `screenshots/` folder at the project root (already created). Add images with these suggested names:
- `screenshots/main_ui.png` — MainActivity layout screenshot (design view or emulator screenshot)
- `screenshots/main_running.png` — MainActivity while running (example of adding an entry or a Toast)
- `screenshots/screen2_ui.png` — Screen2 layout screenshot
- `screenshots/screen2_running.png` — Screen2 running with RecyclerView entries visible

Embedding screenshots in this README (example markdown)

```markdown
![Main screen layout](screenshots/main_ui.png)
_Figure 1 — MainActivity layout (title, author, rating, comment fields and Add/View/Exit buttons)_

![Main running](screenshots/main_running.png)
_Figure 2 — MainActivity while running; shows sample inputs and the "Book added." Toast._

![Screen2 layout](screenshots/screen2_ui.png)
_Figure 3 — Screen2 layout with RecyclerView and Display/Rating/Back buttons._

![Screen2 running](screenshots/screen2_running.png)
_Figure 4 — Screen2 while running showing the book list and a computed average rating Toast._
```

Tips for taking screenshots
- Emulator: use the emulator's screenshot tool (three-dot menu → Screenshot) or Android Studio's Device File Explorer / Screen Capture.
- Physical device: use the device's screenshot keys, then copy the files to your PC and place them in `screenshots/`.
- For clarity, crop or annotate the screenshots using any image editor before saving.

Sample UI descriptions you can paste under each screenshot
- MainActivity (layout): Shows label texts for Title, Author, Rating of 5, Comment; right-side input fields `txtBook`, `txtAuthor`, `txtRating`, `txtComment`; bottom buttons `btnAdd`, `btnOut`, `btnView`.
- MainActivity (running): Type a sample title (e.g., "The 48 Laws of Power"), author ("Robert Greene"), rating (e.g., 4.0), and a short comment ("Good read about strategy."). Tap Add Info to add to the list; a Toast "Book added." appears and fields clear.
- Screen2 (layout): RecyclerView (`rvView`) occupies the center area. Buttons at bottom: Display (refresh list), Rating (calculate average), Back (return).
- Screen2 (running): After adding books, press Display to refresh; the list shows entries as two-line rows: line1 "Title - Author"; line2 "Rating: 4.00 | Short comment". Press Rating to see a Toast with the average rating.

Troubleshooting and notes
-------------------------
- If you see unresolved resource ids or build errors in Android Studio, do: Build → Clean Project then Build → Rebuild Project. That regenerates `R` and resolves resource issues.
- The code uses a simple RecyclerView adapter defined inside `Screen2.kt` to keep everything minimal (no new files). `notifyDataSetChanged()` is used for simplicity. In a more advanced app, prefer DiffUtil or specific notify events for better performance.
- Strings are currently in code for simplicity. For proper localization move them to `res/values/strings.xml`.

Mapping to assignment requirements
---------------------------------
- Use Kotlin & Android: yes (Kotlin Activities)
- Store book details & allow rating/comments: yes (four parallel lists in `BookStore`)
- Provide add/view/exit flows on Main screen: yes
- `Screen2`: display using RecyclerView, compute average rating, back navigation: yes
- Beginner-friendly, minimal complexity, clear code and comments: yes

Next steps I can do for you (pick any):
- Add simple persistence (SharedPreferences) so entries survive app restarts.
- Create a nicer custom item layout for the RecyclerView.
- Move strings to `strings.xml` for localization.
- Add unit tests for average rating computation.

If you want me to also add empty placeholder PNG files inside `screenshots/` (so you have example files to overwrite), I can create them now.

---

If you'd like the placeholder PNGs created now, reply "Create placeholders" and I'll add them; otherwise tell me which improvement you prefer next.
