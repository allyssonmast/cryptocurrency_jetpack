# Cryptocurrency App

This is a mobile app for viewing real-time cryptocurrency data, including current prices, market capitalization, and trading volume. The app is built using Kotlin and Jetpack Compose.

## Features

- View cryptocurrency data in real-time
- Search for specific cryptocurrencies
- View details of each cryptocurrency, including price, market capitalization, and trading volume
- View cryptocurrency charts
- Select favorite cryptocurrencies to keep track of

## Architecture

The app uses Clean Architecture, MVVM, Hilt, and Retrofit.

## Layers
Presentation layer: responsible for rendering the UI and receiving user input. This layer is built using Jetpack Compose and follows the MVVM pattern.
Domain layer: responsible for business logic and use cases. This layer uses Clean Architecture principles to ensure testability and maintainability.
Data layer: responsible for data retrieval and caching. This layer uses Retrofit to retrieve data from the CoinGecko API and Room for caching.
Getting Started

To run the app, follow these steps:

Clone the repository
Open the project in Android Studio
Build and run the app
Libraries Used

- Jetpack Compose for building the UI
- Hilt for dependency injection
- Retrofit for REST API calls
- Room for local data storage
- MPAndroidChart for displaying cryptocurrency charts
