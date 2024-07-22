pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "rickandmorty"
include(":compose-app")
include(":feature:character_details")
include(":feature:character_episode")
include(":feature:home")
include(":shared:domain")
include(":shared:models")
include(":shared:network")
include(":shared:repository")
include(":shared:ui:common")
