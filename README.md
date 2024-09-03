
<img src="http://barbossa.ir/assets/33b9304a-24f1-40bb-be51-3189dd80e8a8-1722025313945058414.png">

# Setup
Add the JitPack repository to settings.gradle file
```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ...      
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependencies to app-level build.gradle file
```gradle
dependencies {
    ...
    implementation 'com.github.barbossa-dev:ComposeScrollPicker:Tag'
}
```





