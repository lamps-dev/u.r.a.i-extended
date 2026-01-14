# U.R.A.I Extension

An extension mod for [U.R.A.I](https://github.com/L33tfx/urai-1.21.11) that adds quality-of-life features and improvements.

## Features

- **Auto-Welcome Message**: Automatically sends a configurable message when joining servers
- **Shortened Default Message**: Concise 158-character default greeting (configurable)
- **Network Protocol Fix**: Resolves network errors when sending messages
- **Bundled Fixed U.R.A.I**: Includes a fixed version of U.R.A.I with URL-encoded API key support

## Installation

### For Users

1. Download the latest release from [Releases](https://github.com/lamps-dev/u.r.a.i-extended/releases)
2. Install the required dependencies:
   - [Fabric API](https://modrinth.com/mod/fabric-api)
   - [Cloth Config](https://modrinth.com/mod/cloth-config)
3. Place the mod JAR in your `mods` folder
4. U.R.A.I is automatically included - **do not install it separately**

### Requirements

- Minecraft 1.21.11
- Fabric Loader 0.18.4+
- Java 21

## Configuration

Access the configuration through Mod Menu:

- **Mod Enabled**: Toggle the entire mod on/off
- **Auto Message Enabled**: Enable/disable automatic server join messages
- **Auto Message Delay**: Delay in milliseconds before sending the message (default: 2000ms)
- **Server Join Intro Message**: Customize the message sent when joining servers
- **Selected Provider**: Choose your LLM provider

Default message:
```
Hey! I'm your AI assistant. Start messages with "Hey Gemini" to chat. Rate limit: 1 reply per 3 seconds. Note: I may occasionally provide inaccurate info.
```

## What's Bundled?

This extension uses Fabric's Jar-in-Jar feature to bundle **U.R.A.I Fixed (v1.0.2-fixed)** that includes:

- **URL-encoded API keys**: Fixes "Illegal character in query" errors when API keys contain spaces or special characters
- **All original U.R.A.I features** preserved
- No separate installation needed - users only install this extension
- Automatic updates when you update the extension

## Building from Source

```bash
git clone https://github.com/lamps-dev/u.r.a.i-extended.git
cd u.r.a.i-extended
./gradlew build
```

The compiled JAR will be in `build/libs/`

## Development

### Prerequisites

- JDK 21
- Gradle 9.2.1

### Project Structure

```
u.r.a.i-extended/
├── src/main/java/org/lampyt/urai/extension/
│   ├── URAIExtension.java              # Main mod class
│   ├── client/
│   │   └── URAIExtensionClient.java    # Client-side logic
│   └── config/
│       ├── URAIExtensionConfig.java     # Configuration data
│       └── ModMenuIntegration.java      # Mod Menu integration
└── src/main/resources/
    ├── fabric.mod.json                  # Mod metadata
    └── assets/u_r_a_i_extension/
        └── lang/                         # Translations
```

## Publishing

This project includes a GitHub workflow for automatic publishing to Modrinth and CurseForge.

### Setup

1. Add GitHub Secrets:
   - `MODRINTH_TOKEN`: Your Modrinth API token
   - `CURSEFORGE_TOKEN`: Your CurseForge API token

2. Update `gradle.properties`:
   ```properties
   modrinth_id = your-modrinth-project-id
   curseforge_id = your-curseforge-project-id
   ```

3. Create a GitHub release to trigger automatic publishing

## Fixes Included

### Network Protocol Error Fix
Ensures chat messages are sent on the main client thread to prevent protocol errors:
```java
client.execute(() -> {
    if (client.player != null && client.player.networkHandler != null) {
        client.player.networkHandler.sendChatMessage(config.serverJoinIntroMessage);
    }
});
```

### U.R.A.I API Key Fix
URL-encodes API keys to handle special characters:
```java
String encodedApiKey = URLEncoder.encode(config.geminiApiKey, StandardCharsets.UTF_8);
```

## License

This project is licensed under the MIT License - see the [LICENSE.txt](LICENSE.txt) file for details.

## Credits

- Original [U.R.A.I mod](https://github.com/L33tfx/urai-1.21.11) by L33tfx
- Built with [Fabric](https://fabricmc.net/)
- Configuration powered by [Cloth Config](https://github.com/shedaniel/cloth-config)

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Support

If you encounter any issues, please [open an issue](https://github.com/lamps-dev/u.r.a.i-extended/issues) on GitHub.
