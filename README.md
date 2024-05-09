# Yumemi Co., Ltd. Android Engineer Code Check Assignment

## Summary

This Android application, developed using Kotlin, implements the MVVM architecture with data binding and dependency injection via Dagger Hilt. It features network interaction through Retrofit and Glide for image loading, targeting GitHub repositories for search functionalities. The app is designed as a single-activity application, leveraging Android's Navigation Component for fragment management.

## Features

### 1) GitHub Repository Search:
- **Search Functionality**: Users can search GitHub repositories using the GitHub API.
- **Display Results**: Search results are displayed in a RecyclerView.
- **Repository Details**: Clicking on a repository item displays its detailed information in a new fragment.

### 2) Image Loading:
- **Dynamic Image Loading**: Repository owner images are loaded dynamically into list items using Glide.

### 3) Network Handling:
- **Network Monitoring**: The application monitors network connectivity and displays alerts when the network is unavailable.

### 4) Dependency Injection:
- **Dagger-Hilt Integration**: The app uses Dagger Hilt for dependency injection to provide Retrofit and other network-related dependencies.

### 5) Modern Android Development:
- **Kotlin Coroutines**: Utilizes Kotlin Coroutines for asynchronous tasks, especially for network requests.
- **Data Binding**: Employs data binding to bind UI components directly to data sources.
- **View Binding**: View binding is used to interact with views more safely and efficiently.

### 6) Robust Testing Framework:
- **Unit Tests**: Includes unit tests for repository methods to ensure the reliability and correctness of the application logic.

## Main Libraries and Dependencies
- **Retrofit**: For network operations.
- **Glide**: For image loading.
- **Dagger Hilt**: For dependency injection.
- **Kotlin Coroutines**: For managing background threads with simplified code and reducing the need for callbacks.
- **Navigation Component**: For managing app navigation.

## Installation
1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the app on an emulator or physical device.

## Usage
1. Open the app.
2. Use the search bar at the top of the main screen to search for GitHub repositories.
3. Click on a repository to view detailed information, including the repository's name, owner, stars, and other relevant data.

## Project Structure

The project is organized into several packages to ensure a clean architecture:

- **apiservices**: Contains the Retrofit API service definitions.
- **models**: Defines the data models used by Retrofit for JSON serialization and deserialization.
- **repository**: Contains repository classes responsible for data operations.
- **ui**: Houses the activities and fragments along with their respective ViewModels.
- **utils**: Includes utility classes such as network monitoring utilities.

## Environment

- **IDE**: Android Studio Hedgehog | 2023.1.1 Patch 1
- **Kotlin**: 1.6.21
- **Gradle**: 8.0.2
- **minSdk**: 23
- **targetSdk**: 34
