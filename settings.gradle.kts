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
include(":rickandmorty-app")
include(":core:domain")
include(":core:models")
include(":core:network")
include(":core:repository")
include(":core:ui:common")
include(":feature:character_details")
include(":feature:characters_episode")
include(":feature:home")
