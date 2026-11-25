# Camera Keybinds
Minecraft mod (Fabric) for perspective switching keybinds!

## Compatibility

Version 5.0.0 targets Minecraft Java 26.1, 26.1.1, 26.1.2, 26.2 and 26.3 with
Fabric Loader 0.20.1 or newer, Java 25, and Fabric API for your Minecraft version.
There are two downloads, each containing one playable JAR:

- **26.1 and 26.2:** `camera_keybinds-5.0.0+mc26.1-26.2.jar` (also supports 26.1.1 and 26.1.2).
- **26.3:** `camera_keybinds-5.0.0+mc26.3.jar` (uses the new SDL keyboard codes).

Install only one of these JARs. Minecraft 1.21.9–1.21.11 users should use
Camera Keybinds 4.0.0.

Build with `./gradlew build` (or `gradlew.bat build` on Windows) using JDK 25.
To build another target, override `minecraft_version` and `fabric_version`;
the supported combinations are listed in `.github/workflows/build.yml`.
CI compiles against each supported Minecraft release. These build checks do
not replace in-game testing of the nine keybindings.

## Features
Change your perspective to:
-  first person, with "i"
-  third person, with "o"
-  reverse third person, with "p"

Hold key to temporary change perspective:
-  first person, with "j"
-  third person, with "k"
-  reverse third person, with "l"

Or toggle between last and:
-  first person, with "b"
-  third person, with "n"
-  reverse third person, with "m"

**All** keys can bey rebound!
*Personally I love toggling third person perspective with one of my mouse buttons*

Languages:
- English US
- Polish

