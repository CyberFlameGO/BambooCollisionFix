package net.camotoy.geyserhacks;

import org.spongepowered.configurate.objectmapping.ConfigSerializable;
import org.spongepowered.configurate.objectmapping.meta.Comment;

@ConfigSerializable
@SuppressWarnings("FieldMayBeFinal")
public final class GeyserHacksConfiguration {
    @Comment("\"Fixes\" Bedrock players running into lagback issues on certain blocks by removing any collision detection " +
            "from the given block.\n" +
            "Caveats: a custom client - Java or Bedrock - could take advantage of no collision and walk right through.\n" +
            " Additionally, placement of these blocks on both platforms may be buggier than usual.")
    private CollisionFixes collisionFixes = new CollisionFixes();
    @Comment("Fixes some Bedrock platforms causing a sign to be uneditable in the middle of an editing session.\n" +
            "Caveat: a custom client could re-edit their own sign at any time.\n" +
            "Additionally, this fix will apply to all players, Java and Bedrock, if Geyser/Floodgate is not installed.\n" +
            "Requires a decently recent version of Paper.")
    private boolean signFix = true;

    public CollisionFixes collisionFixes() {
        return collisionFixes;
    }

    public boolean signFix() {
        return signFix;
    }

    @ConfigSerializable
    static final class CollisionFixes {
        private boolean bamboo = true;
        private boolean pointedDripstone = true;

        public boolean bamboo() {
            return bamboo;
        }

        public boolean pointedDripstone() {
            return pointedDripstone;
        }
    }
}
