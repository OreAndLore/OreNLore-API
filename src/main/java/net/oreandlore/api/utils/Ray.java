package net.oreandlore.api.utils;

import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.Particle.DustOptions;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.Iterator;

public class Ray {
    final Vector origin;
    final Vector direction;

    public Ray(Vector origin, Vector direction) {
        this.origin = origin;
        this.direction = direction;
    }

    public Ray(Player FromPlayerFacing) {
        this.origin = FromPlayerFacing.getEyeLocation().toVector();
        this.direction = FromPlayerFacing.getEyeLocation().getDirection();
    }

    public Vector getPostion(double blocksAway) {
        return this.origin.clone().add(this.direction.clone().multiply(blocksAway));
    }

    public boolean isOnLine(Vector position) {
        double t = (position.getX() - this.origin.getX()) / this.direction.getX();
        return (double)position.getBlockY() == this.origin.getY() + t * this.direction.getY() && (double)position.getBlockZ() == this.origin.getZ() + t * this.direction.getZ();
    }

    public ArrayList<Vector> getPositionsOnRay(double maxBlockDistanceAway, double stepIncrement) {
        ArrayList<Vector> positions = new ArrayList();

        for(double d = 0.0D; d <= maxBlockDistanceAway; d += stepIncrement) {
            positions.add(this.getPostion(d));
        }

        return positions;
    }

    public Vector positionOfIntersection(Vector min, Vector max, double blocksAway, double accuracy) {
        ArrayList<Vector> positions = this.getPositionsOnRay(blocksAway, accuracy);
        Iterator vectorIterator = positions.iterator();

        Vector position;
        do {
            if (!vectorIterator.hasNext()) {
                return null;
            }

            position = (Vector)vectorIterator.next();
        } while(!this.intersects(position, min, max));

        return position;
    }

    public boolean intersects(Vector min, Vector max, double blocksAway, double accuracy) {
        ArrayList<Vector> positions = this.getPositionsOnRay(blocksAway, accuracy);
        Iterator vectorIterator = positions.iterator();

        Vector position;
        do {
            if (!vectorIterator.hasNext()) {
                return false;
            }

            position = (Vector)vectorIterator.next();
        } while(!this.intersects(position, min, max));

        return true;
    }

    public boolean intersects(Vector position, Vector min, Vector max) {
        if (position.getX() >= min.getX() && position.getX() <= max.getX()) {
            if (position.getY() >= min.getY() && position.getY() <= max.getY()) {
                return position.getZ() >= min.getZ() && position.getZ() <= max.getZ();
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void highlight(World world, double blocksAway, double accuracy) {
        Iterator positionsRay = this.getPositionsOnRay(blocksAway, accuracy).iterator();

        while(positionsRay.hasNext()) {
            Vector position = (Vector)positionsRay.next();
            DustOptions dustOptions = new DustOptions(Color.fromRGB(0, 127, 255), 1.0F);
            world.spawnParticle(Particle.REDSTONE, position.toLocation(world), 50, dustOptions);
        }

    }
}
