pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://raw.github.com/oguzkaran/android-mar-2023-maven-repo/main")
        }

        maven {
            url = uri("https://raw.github.com/oguzkaran/android-mar-2023-karandev-maven-repo/main")
        }
    }
}

rootProject.name = "MultipleActivity"
include(":app")
include(":DataBindingConverterModule")
