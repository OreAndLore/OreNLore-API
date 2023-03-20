package net.oreandlore.api.utils;

public enum HiddenStringTags {
    ClickableGuiItem("444", "Represents a gui item that can be clicked on to perform a function."),
    GuiBoundItem("555", "Represents a gui item that will be blocked from being removed from the gui (in GuiBoundItem.class)"),
    UpgradeCard("520", "Represents an Upgrade Card"),
    TeamSetUpItem("158", "Represents a team setup item."),
    ArenaSetUpItem("134", "Represents a arena setup item."),
    MonsterSpawnItem("709", "Represents the item used to spawn mobs.");

    final String Tag;
    final String Info;

    HiddenStringTags(String tag, String info) {
        this.Tag = tag;
        this.Info = info;
    }

    public boolean Has(String Text) {
        return Util.STRING.fromInvisible(Text).contains(this.getTag());
    }

    public String Add(String Text) {
        return Util.STRING.toInvisible(this.getTag()) + Util.STRING.FString(Text);
    }

    public String getTag() {
        return this.Tag;
    }
}

