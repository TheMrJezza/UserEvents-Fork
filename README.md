# UserEvents-Fork
A proposed overhaul/remake of the UserEvents Bukkit Plugin (https://www.spigotmc.org/resources/userevents.96449/).

This is not the official code/repo for the Plugin linked above, and I am not the author of said plugin.

**Current Improvments include:**
- Cached Configuration.
- Support for Minecraft versions older than 1.9, although newer is considered first-class.
- Abstraction to eliminate code duplication.
- All "Player Based" commands (/fly /god /heal /feed) have full "Other Player" support. i.e /&lt;command&gt; {Target}
- Restructure and Reformat language configuration file to remove unnecessary Lists.
- Streamlined plugin.yml

Once again, I'm not the developer of UserEvents, and while this repo is labled as a "Fork", all of this code is my own.
Any issues here should not be held against the original/official developer.

**Future Improvments and Features:**
- Make God Status persistant between Server Restarts on MC versions older than 1.9.
- Add /gills {Target} to allow breathing underwater.
- Add /repair {Target} & /repairall {Target} to repair items in a Player's Hand/Inventory.
- Add /invsee {Target} to view/modify another player's inventory.
- Find a use for /userevents. The original plugin has this command, however, it isn't in this version due to lack of purpose.
