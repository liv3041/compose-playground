
# Affirmations App

This is an **Affirmations App** built with **Jetpack Compose** that displays a collection of positive affirmations in both a **Grid View** and a **List View**. The app utilizes `LazyColumn` for the List View and `LazyVerticalGrid` for the Grid View. All resources, including the layouts and code, are based on the **Android Developer Training Codelab**.

## Features

- **List View**: Displays a vertical list of affirmations.
- **Grid View**: Displays affirmations in a grid format, providing a clean and organized way to show multiple items.
- **UI Components**: Use of basic UI components such as `Row`, `Column`, and `Box` for layout management.

## Getting Started

To get started, clone this repository and run the app on your Android device or emulator.

### Clone the Repository

```bash
git clone https://github.com/yourusername/affirmations-app.git
```

### Prerequisites

- Android Studio (latest version)
- Jetpack Compose libraries

### Dependencies

Ensure the following dependencies are included in your `build.gradle` (app-level):

```gradle
dependencies {
    implementation "androidx.compose.ui:ui:1.3.0"
    implementation "androidx.compose.material:material:1.3.0"
    implementation "androidx.compose.ui:ui-tooling-preview:1.3.0"
    implementation "androidx.navigation:navigation-compose:2.5.0"
    implementation "androidx.compose.foundation:foundation:1.3.0"
    implementation "androidx.compose.foundation:foundation-layout:1.3.0"
}
```

### Screenshots

- **List View**: Displays a simple vertical list of affirmations.
<img src="https://github.com/user-attachments/assets/7c941d1e-be08-4b00-b1f3-fcb36710c35c" width="250">
- **Grid View**: Shows affirmations in a grid layout.
<img src="https://github.com/user-attachments/assets/d6f89534-bf02-4aef-b780-dce6363391a1" width="250">



## App Overview

### LazyColumn (List View)

In Jetpack Compose, `LazyColumn` is used to display lists that are scrollable. It is similar to a `RecyclerView` in traditional Android views but is much more efficient. Items inside a `LazyColumn` are loaded lazily, meaning that only the items visible on the screen are rendered, improving performance.

```kotlin
@Composable
fun AffirmationList(affirmations: List<Affirmation>) {
    LazyColumn {
        items(affirmations) { affirmation ->
            AffirmationCard(affirmation)
        }
    }
}
```

Here, `LazyColumn` is used to render a list of affirmations. Each item is created by passing a list (`affirmations`) and displaying it using `AffirmationCard`.

### LazyVerticalGrid (Grid View)

`LazyVerticalGrid` allows you to create grid-based layouts where items are placed in a grid with a variable number of columns. Like `LazyColumn`, `LazyVerticalGrid` only renders visible items to optimize performance.

```kotlin
LazyVerticalGrid (
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small)),
        modifier = modifier

    ){
        items(topicList) {topic->
            TopicCard(
                topic = topic,
                modifier = Modifier.padding(8.dp)
            )

        }
    }
```

In this example, `LazyVerticalGrid` displays affirmations in a grid with two columns per row. The `items` function is used to display the topic cards.

### Container Layouts: Row, Column, and Box

Jetpack Compose provides several basic layout components to organize UI elements.

- **Row**: A layout that arranges children horizontally. It’s similar to `LinearLayout` with `horizontal` orientation.

```kotlin
Row(
    modifier = Modifier.fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween
) {
    Text(text = "Affirmation 1")
    Text(text = "Affirmation 2")
}
```

- **Column**: A layout that arranges children vertically, similar to `LinearLayout` with `vertical` orientation.

```kotlin
Column(
    modifier = Modifier.padding(16.dp),
    verticalArrangement = Arrangement.Top
) {
    Text(text = "Affirmation 1")
    Text(text = "Affirmation 2")
}
```

- **Box**: A layout that allows stacking of components. The components inside the `Box` are placed on top of each other. It’s useful for creating overlays, such as placing a `Text` on top of an `Image`.

```kotlin
Box(
    modifier = Modifier.fillMaxSize()
) {
    Image(painter = painterResource(id = R.drawable.sample_image), contentDescription = "Sample Image")
    Text(text = "Affirmation", modifier = Modifier.align(Alignment.Center))
}
```

These containers (`Row`, `Column`, `Box`) allow you to arrange and position the UI components efficiently.



## Resources

All the resources, including the code and layout designs, are taken from the **Android Developer Training Codelab**.

- [Jetpack Compose Basics](https://developer.android.com/courses/pathways/compose)

## License

This project is open source and available under the [MIT License](LICENSE).

---

**Thank you for checking out the Affirmations App! We hope you find it useful for learning about Jetpack Compose. Feel free to fork and contribute to the project.**

---

### Explanation:

- **LazyColumn**: Efficiently renders a vertical list.
- **LazyVerticalGrid**: Efficiently renders a grid layout.
- **Row**, **Column**, **Box**: Fundamental layout components for arranging UI elements in Jetpack Compose.

The app demonstrates how to use these Jetpack Compose components to build a simple yet dynamic Affirmations app. The `LazyColumn` and `LazyVerticalGrid` make sure that large lists of data are handled efficiently. The layouts (`Row`, `Column`, `Box`) are used to structure the UI elements properly. All code and designs are derived from the **Android Developer Training Codelab**.
