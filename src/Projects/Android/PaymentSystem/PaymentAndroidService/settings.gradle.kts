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

        maven {
            url = uri("https://raw.github.com/oguzkaran/javaapp2-jan-2024-karandev-maven-repo/main")
        }
    }
}

rootProject.name = "PaymentAndroidService"
include(":app")
include(":RepositoryLib")
include(":DataServiceLib")
include(":NetworkServiceLib")
