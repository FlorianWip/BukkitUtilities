# Welcome to BukkitUtilities
What is **BukkitUtilities**?
I my time I wrote and collected a lot of Utils. I wrote libraries for private use. Now I want to collect all of these classes to a library, which I want to share to you. So be active, I will add my Utils and will update it often.


# Features
**The usage of all features will be explained in the wiki**

## Command-System

You can simply create Bukkit-Commands for only players (*PlayerCommand*) or for console and players (*ConsoleCommand*). It supports sub-commands and it includes a *ArgsUtil*, which makes it easier to work with the arguments.

## Reflection-Util

With this ReflectionUtil, you can easily get all classes in a the package of an object and check if a class has a empty (*NoArgsConstructor*) constructor.

## Message-Util
This Util contains some special characters for messages and you can easily generate header and footer lines

# How to use?

## How to make it runnable?

Simply drop the jar in the plugins Folder of your Bukkit-/Spigotserver.
## How to develope with it?
**Without maven:**
Add the jar as dependency to your project, the way depends on your idea.

**Maven**

   ```
	<repositories>
		<repository>
			<id>flammenfuchs</id>
			<url>https://repository.flammenfuchs.de/public</url>
		</repository>
	</repositories>
	<dependencies>
		<dependency>
			<groupId>de.flammenfuchs</groupId>
			<artefactId>BukkitUtilities</artifactId>
			<version>1.0.0</version>
		</dependency>
	</dependencies>
```
**Gradle**

	repositories {
	    maven {
	        url "https://repository.flammenfuchs.de/public"
	    }
	}
	dependencies {
	    BukkitUtilities 'de.flammenfuchs:BukkitUtilities:1.0.0'
	}


# Compatibility
|Minecraft-Version |Getestete Kompatiblität        |Inkompatibel (geprüft)       |
|------------------|-------------------------------|-----------------------------|
|1.8               |ab v1.0.0                      |-                            |
|1.9               |ungetestet                     |-                            |
|1.10              |ungetestet                     |-                            |
|1.11              |ungetestet                     |-                            |
|1.12              |ungetestet                     |-                            |
|1.13              |ungetestet                     |-                            |
|1.14              |ungetestet                     |-                            |
|1.15              |ungetestet                     |-                            |
|1.16              |ungetestet                     |-                            |
|1.17              |ungetestet                     |-                            |
# More information
in the wiki of this project
