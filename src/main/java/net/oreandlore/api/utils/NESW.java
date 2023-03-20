package net.oreandlore.api.utils;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public enum NESW {
    NA("NA", "NA"),
    UP("Up", "U"),
    DOWN("Down", "D"),
    NORTH("North", "N"),
    NORTH_EAST("", ""),
    EAST("East", "E"),
    EAST_SOUTH("", ""),
    SOUTH("South", "S"),
    SOUTH_WEST("", ""),
    WEST("West", "W"),
    WEST_NORTH("", "");

    final String direction;
    final String letter;

    private NESW(String direction, String letter) {
        this.direction = direction;
        this.letter = letter;
    }

    public static Location moveLocationInDirection(Location start, NESW direction, int amountToMove) {
        if (direction == NORTH) {
            return start.clone().add(0.0D, 0.0D, (double) (-amountToMove));
        } else if (direction == NORTH_EAST) {
            return start.clone().add((double) amountToMove, 0.0D, (double) (-amountToMove));
        } else if (direction == EAST) {
            return start.clone().add((double) amountToMove, 0.0D, 0.0D);
        } else if (direction == EAST_SOUTH) {
            return start.clone().add((double) amountToMove, 0.0D, (double) amountToMove);
        } else if (direction == SOUTH) {
            return start.clone().add(0.0D, 0.0D, (double) amountToMove);
        } else if (direction == SOUTH_WEST) {
            return start.clone().add((double) (-amountToMove), 0.0D, (double) amountToMove);
        } else if (direction == WEST) {
            return start.clone().add((double) (-amountToMove), 0.0D, 0.0D);
        } else {
            return direction == WEST_NORTH ? start.clone().add((double) (-amountToMove), 0.0D, (double) (-amountToMove)) : start;
        }
    }

    public static NESW fromLocationToLocation(Location From, Location To) {
        if (To.getBlockX() > From.getBlockX()) {
            return EAST;
        } else if (To.getBlockX() < From.getBlockX()) {
            return WEST;
        } else {
            return To.getBlockZ() > From.getBlockZ() ? SOUTH : NORTH;
        }
    }

    public static NESW fromPlayerFacing_Full(Player p) {
        double rotation = (double) ((p.getLocation().getYaw() - 90.0F) % 360.0F);
        if (rotation < 0.0D) {
            rotation += 360.0D;
        }

        if (0.0D <= rotation && rotation < 22.5D) {
            return NORTH;
        } else if (22.5D <= rotation && rotation < 67.5D) {
            return NORTH_EAST;
        } else if (67.5D <= rotation && rotation < 112.5D) {
            return EAST;
        } else if (112.5D <= rotation && rotation < 157.5D) {
            return EAST_SOUTH;
        } else if (157.5D <= rotation && rotation < 202.5D) {
            return SOUTH;
        } else if (202.5D <= rotation && rotation < 247.5D) {
            return SOUTH_WEST;
        } else if (247.5D <= rotation && rotation < 292.5D) {
            return WEST;
        } else if (292.5D <= rotation && rotation < 337.5D) {
            return WEST_NORTH;
        } else {
            return 337.5D <= rotation && rotation < 359.0D ? NORTH : NORTH;
        }
    }

    public static NESW fromPlayerFacing(Player p) {
        double rotation = (double) ((p.getLocation().getYaw() - 90.0F) % 360.0F);
        if (rotation < 0.0D) {
            rotation += 360.0D;
        }

        if (0.0D <= rotation && rotation < 45.0D) {
            return WEST;
        } else if (45.0D <= rotation && rotation < 135.0D) {
            return NORTH;
        } else if (135.0D <= rotation && rotation < 225.0D) {
            return EAST;
        } else if (225.0D <= rotation && rotation < 315.0D) {
            return SOUTH;
        } else {
            return 315.0D <= rotation && rotation < 360.0D ? WEST : NORTH;
        }
    }

    public static NESW fromPlayerFacing_Diagonal(Player p) {
        double rotation = (double) ((p.getLocation().getYaw() - 90.0F) % 360.0F);
        if (rotation < 0.0D) {
            rotation += 360.0D;
        }

        if (0.0D <= rotation && rotation < 90.0D) {
            return WEST_NORTH;
        } else if (90.0D <= rotation && rotation < 180.0D) {
            return NORTH_EAST;
        } else if (180.0D <= rotation && rotation < 270.0D) {
            return EAST_SOUTH;
        } else {
            return 270.0D <= rotation && rotation <= 360.0D ? SOUTH_WEST : NORTH_EAST;
        }
    }

    public static NESW reverse(NESW original) {
        if (original == NORTH) {
            return SOUTH;
        } else if (original == EAST) {
            return WEST;
        } else {
            return original == SOUTH ? NORTH : EAST;
        }
    }

    public String getDirection() {
        return this.direction;
    }
    public String getLetter() {
        return this.letter;
    }
}

