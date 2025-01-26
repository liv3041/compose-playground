# Digital Art Space App 🎨📱

## 🌟 Features

- **Dynamic Artwork Display**: Showcase an array of images with intuitive navigation.
- **Customizable Layout**: Easily arrange elements using `Row` and `Column` composables.
- **Interactive UI**: Modify artwork states with simple button taps.
- **Jetpack Compose-Based**: Built with a declarative UI framework for a seamless user experience.
- **Offline Ready**: All photos and digital art are stored locally within the app.

## 🛠 Tech Stack

- **Kotlin**: The programming language for building the app.
- **Jetpack Compose**: Used for building modern, reactive UI.
- **Android Studio**: The development environment.

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

## 🚀 How to Use

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/digital-art-space.git
   ```
2. Open the project in Android Studio.
3. Add your artwork or photos to the `res/drawable` directory.
4. Update the code to reference your images:
   ```kotlin
   Image(painter = painterResource(R.drawable.your_image), contentDescription = "Your Image")
   ```
5. Run the app on an emulator or a physical device.

## 📖 Learning Outcomes

- Building low-fidelity prototypes and translating them into functional code.
- Creating layouts with `Row` and `Column` composables.
- Customizing UI elements using the `Modifier` object.
- Managing states with Jetpack Compose and responding to user interactions.



## 📂 Project Structure

```
├── app
│   ├── src
│   │   ├── main
│   │   │   ├── java/com/example/digitalartspace
│   │   │   │   ├── MainActivity.kt
│   │   │   │   └── ArtSpace.kt
│   │   │   ├── res
│   │   │   │   ├── drawable/
│   │   │   │   ├── layout/
│   │   │   │   └── values/
│   └── build.gradle
└── build.gradle
```
## Resources

All the resources, including the code and layout designs, are taken from the **Android Developer Training Codelab**.

- [Jetpack Compose Basics](https://developer.android.com/courses/pathways/compose)



