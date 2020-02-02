# Discription
Simple coding challenge of a Reddit-like app

# Project Generation
* The project based is from Android Studio's standard new project wizard.
* App UI is following Google's template in https://github.com/android/architecture-samples.

# Project Style
* MVVM architecture as recommended by Google's https://github.com/android/architecture-samples.
* Single activity app.
* Navigation Component.
* SafeArgs for navigation actions to avoid bugs.
* Gitflow.

# Decisions/Assumptions
1. A decision was made that the app supports voting both on the main list and in the topic details screen.
2. A decision was made that Repository pattern was not followed because the app was too simple with only the UI as a data source.
3. An assumption was made that down votes do not decrement or affect up votes in anyway, nor do they affect the sorting.

# Improvement Suggestions
* The app can be further improved by implementing data binding.
* The app can be further improved by implementing more decoupling between V VM M by implementing interfaces between components rather than holding concrete implementation references.
* Using DiffUtils to compare changes to the list.