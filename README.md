## QuotesApp

Android Quotes app built with **Jetpack Compose**. Browse motivational quotes by category, explore latest quotes, and save your favourites – all with a clean, simple architecture using in‑memory models (no backend / database).

### ✨ Features

- **Home (Explore) screen**
  - Hero banner with inspirational image
  - “Latest Quotes” horizontal card slider
  - “Categories” section with pill‑style cards (Life, Motivation, Success, Wisdom, Love)
  - “View All” buttons that open the full Categories (Explore) screen

- **Categories (Explore) screen**
  - Category tabs (Life, Motivation, Success, Wisdom, Love)
  - Quote list matching the assignment UI (avatar, quote, author, category tag, actions)
  - Per‑quote actions: **like/save**, **share**, **download** (UI only)

- **Saved screen**
  - Shows all quotes the user has liked/saved

- **Bottom navigation**
  - `Home`, `Explore`, `Saved` destinations
  - Proper back‑stack behaviour (Home ⇄ Explore ⇄ Saved)

### 🧱 Tech Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose, Material 3
- **Navigation**: `androidx.navigation:navigation-compose`
- **Images**: Coil (Compose)
- **State**: `remember` / `mutableStateOf` (no DI, no database)


1. Clone the repo:
   git clone https://github.com/<your-username>/QuotesApp.git   
2. Open the project in **Android Studio** (Giraffe or newer).
3. Let Gradle sync.
4. Run the app on an emulator or a physical device (API 24+).

### 📌 Notes

- All data is loaded from in‑memory models, so the app works fully offline.
