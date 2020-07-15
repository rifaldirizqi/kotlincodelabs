![KoinBanner](https://raw.githubusercontent.com/ekito/koin/master/img/koin_2.0.jpg "Koin Banner")

# What is KOIN?
A pragmatic lightweight dependency injection framework for Kotlin developers. Written in pure Kotlin using functional resolution only: no proxy, no code generation, no reflection!
Koin is a DSL, a lightweight container and a pragmatic API.

# Source

🌐 [Official Website Koin](https://insert-koin.io/)

# QuickStarter
## Current Version
```
// Current Stable Version
koin_version= "2.1.6"
```
## Gradle
> Koin packages are published on JCenter

Add the following Gradle dependencies to add Koin to your project:gradle :
```
buildscript {
    repositories {
        jcenter()
    }
    dependencies {
        classpath "org.koin:koin-gradle-plugin:$koin_version"
    }
}

apply plugin: 'koin'
```
Add the following Gradle dependencies to add Koin to your app:gradle :
```
dependencies {
  // Koin for Kotlin
  implementation "org.koin:koin-core:$koin_version"
}
```
Declare a Koin module on Package  `di`
```
val apiModule = module {
  // Your Code Here
}
```
Declare a MainApplication on Package `base`
```
class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            getDefinedModule()
        }
    }

    private fun getDefinedModule(): List<Module> {
        return arrayListOf(
            apiModule
        )
    }
}
```
Add name properties to AndroidManifest.xml
```
 <application
   android:name=".base.MainApplication"
   ...
 >
 ...
 </application>
 ```
