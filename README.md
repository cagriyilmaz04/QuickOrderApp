# QuickOrderApp 🍽️📱

QuickOrderApp is a modern Android application that allows users to browse a restaurant’s menu and manage their favorite dishes efficiently. The app is built using Kotlin, Jetpack Compose, and Google Cloud, following the MVVM architecture for clean and scalable code structure.

## 📌 Features

## 🍛 Menu Screen

Displays a list of dishes with their name, description, and price.

Uses LazyColumn for smooth scrolling.

Each dish is shown as a Card component with an image and details.

Users can mark dishes as favorites with a simple tap.

## ❤️ Favorites Screen

Lists all favorited dishes in a separate section.

Users can remove dishes from their favorites.

Includes smooth animations when adding or removing favorites.

## 🎨 Modern UI & Animations

Built with Jetpack Compose for a declarative and reactive UI.

Smooth transitions & animations for better user experience.

Uses Material 3 components for a clean and stylish design.

## 🛠️ Technologies & Architecture

## 📱 Android Development

Kotlin → Modern programming language for Android development.

Jetpack Compose → Fully declarative UI framework.

MVVM Architecture → Ensures clean separation of concerns.

Navigation Component → Manages screen transitions smoothly.

## 🌐 Networking & API

Custom API → Hosted on Google Cloud (Cloud API).

Retrofit → Handles network requests.

OkHttp → Manages network calls efficiently.

Gson → Parses JSON responses.

## 💾 Local Storage

Room Database → Stores favorites locally.

DAO (Data Access Object) → Handles database operations.

🔧 Dependency Injection

Hilt (Dagger Hilt) → Manages dependencies cleanly.

## 📦 State Management

Flow & StateFlow → Handles reactive UI updates efficiently.

## 🚀 How It Works

Launch the App → The menu is fetched from the Cloud API.

Mark Favorites → Tap the heart icon to add a dish to favorites.

View Favorites → Navigate to the favorites screen.

Remove Favorites → Tap the heart icon again to remove a dish.

🛠️ Setup & Installation

1️⃣ Clone the Repository

git clone https://github.com/cagriyilmaz04/QuickOrderApp.git
cd QuickOrderApp

2️⃣ Open in Android Studio

Open the project in Android Studio Giraffe or newer.

Sync Gradle files.

3️⃣ Run the Application

Connect a device/emulator and run the app.

📂 Project Structure

📦 QuickOrderApp
┣ 📂 data
┃ ┣ 📂 local
┃ ┣ 📂 remote
┃ ┣ 📂 repository
┣ 📂 domain
┃ ┣ 📂 model
┃ ┣ 📂 repository
┃ ┣ 📂 usecase
┣ 📂 presentation
┃ ┣ 📂 screens
┃ ┣ 📂 components
┃ ┣ 📂 viewmodel
┣ 📂 di (Dependency Injection)
┣ 📂 util (Constants & Helpers)
┣ AndroidManifest.xml
┗ build.gradle

🔗API Endpoints

### 1️⃣ TheMealDB API
- **Base URL:** `https://www.themealdb.com/api/json/v1/1/`
- Fetches meal categories and basic meal data.

### 2️⃣ Custom Backend API (Spring Boot)
- **Base URL:** `http://34.60.187.225:8080/`
- I developed by using **Java Spring Boot** to provide enhanced meal details, pricing, and descriptions.
- Example Endpoint:
  ```bash
  GET http://34.60.187.225:8080/meals/{category}

http://34.60.187.225:8080/meals/Pork

👨‍💻 Authors

Muhammet Çağrı Yılmaz – Android Developer


📜 License

This project is licensed under the MIT License.

🔥 Now your README.md looks highly professional and well-structured! 🚀

