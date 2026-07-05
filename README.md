# Compose Playground

A collection of Jetpack Compose applications built to explore modern Android development patterns, including state management, navigation, MVVM architecture, and side effects.

## Apps Included

### 1. Affirmations App
Displays a collection of positive affirmations in both a Grid View and a List View using `LazyColumn` and `LazyVerticalGrid`.

### 2. Counter App
A simple counter demonstration that highlights:
- **State Management**: Using `ViewModel` and `StateFlow`.
- **Unidirectional Data Flow**: UI sends events (increment/decrement) to the ViewModel, and the ViewModel exposes state updates.
- **UI State**: Encapsulated in a `CounterUiState` data class.

### 3. API Simulator
Simulates a network request to demonstrate asynchronous operations and state handling:
- **Loading/Success/Error States**: Managed via a `sealed class` (`ApiSimulatorUiState`).
- **Side Effects**: Utilizes `LaunchedEffect` to trigger the data fetch when the screen is first loaded.
- **Simulated Latency**: Uses Kotlin Coroutines `delay` to mimic real-world network behavior.

---

## Key Learnings & Architecture

### MVVM Architecture
The project follows the **Model-View-ViewModel** pattern to ensure a clean separation of concerns:
- **View (Composables)**: Responsible for rendering the UI based on the state.
- **ViewModel**: Holds the business logic and manages the state using `StateFlow`.
- **UiState**: Dedicated classes/sealed classes that represent the exact state of the UI at any given time.

### Side Effects in Compose
Learnt how to handle operations that happen outside the scope of a composable function:
- **`LaunchedEffect`**: Used in the API Simulator to start the "API call" safely when the composable enters the composition, ensuring it doesn't restart on every recomposition.

### Clean Code Practices
- **Reactive State**: Using `StateFlow` instead of manual state updates for better lifecycle awareness.
- **Sealed Classes**: Implementing `sealed class` for UI states (Loading, Success, Error) to make the code more robust and readable.
- **Reusable Composables**: Breaking down the UI into smaller, stateless components (e.g., the `Counter` buttons) to improve maintainability.

## Getting Started

### Prerequisites
- Android Studio (latest version)
- Kotlin and Jetpack Compose libraries

### Installation
```bash
git clone https://github.com/yourusername/compose-playground.git
```

## Resources
- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [Android Developer Training Codelabs](https://developer.android.com/courses/pathways/compose)

---
**This playground serves as a continuous learning project for mastering Jetpack Compose and modern Android architecture.**
