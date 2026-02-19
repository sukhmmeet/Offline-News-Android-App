# 📰 Offline News App

A modern Android News Application built using **Kotlin** and **Jetpack Compose**, following **MVVM architecture** with an **offline-first approach** using Room Database and smooth infinite scrolling using Paging 3.

---

## 🚀 Features

- 📡 Fetches latest news from REST API
- 💾 Offline-first architecture (Room Database caching)
- 🔄 Pull-to-refresh support
- ⚡ Infinite scrolling using Paging 3
- 🖼 Image loading with Coil
- 🎨 Fully built with Jetpack Compose
- 🏗 Clean MVVM architecture
- 🧵 Coroutines & Flow for reactive programming
- 🌙 Light / Dark theme support

---

## 🏛 Architecture

The app follows a clean **MVVM architecture**:

API → Repository → Room Database → Paging 3 → UI (Compose)


### Flow Explanation

1. Data is fetched from the API using Retrofit.
2. The Repository saves data into Room Database.
3. Paging 3 loads data efficiently from the database.
4. Jetpack Compose UI observes the paginated data.
5. Pull-to-refresh updates the database from API.

---

## 🛠 Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **MVVM Architecture**
- **Room Database**
- **Retrofit**
- **Paging 3**
- **Kotlin Coroutines & Flow**
- **Coil (Image Loading)**

---

## 📦 Dependencies Used

- androidx.compose.material3
- androidx.lifecycle.viewmodel
- androidx.room
- androidx.paging
- retrofit2
- coil-compose

---


## 🧠 What I Learned

- Implementing offline-first architecture
- Using Paging 3 with Room
- Managing UI state with ViewModel and StateFlow
- Handling pull-to-refresh with Compose
- Structuring scalable Android projects

---
## 📂 Project Structure

```
com.dhaliwal.offlinenewsapp
│
├── data
│   ├── api
│   ├── db
│   └── repository
│
├── ui
│   ├── components
│   └── screens
│
├── viewmodel
│
└── MainActivity.kt
```

---

## 🎯 Future Improvements

- Add search functionality
- Add category filtering
- Add bookmarks feature
- Implement RemoteMediator for full API paging
- Add unit & UI tests

---

## 👨‍💻 Author

**DHALIWAL**  
CSE Student | Android Developer | Kotlin Enthusiast

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!
