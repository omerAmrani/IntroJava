package mmn._12;

/**
 * This class represents a Point3D
 *
 * @author Omer Amrani
 * @version 17.04.2024
 */
public class Point3D {
    private double _x;
    private double _y;
    private double _z;

    /**
     * Default constructor
     */
    public Point3D() {
        this._x = 0;
        this._y = 0;
        this._z = 0;
    }

    /**
     * Construct Point3D by specific coordinates
     *
     * @param x The x-coordinate of the point.
     * @param y The y-coordinate of the point.
     * @param z The z-coordinate of the point.
     */
    public Point3D(double x, double y, double z) {
        this._x = x;
        this._y = y;
        this._z = z;
    }

    /**
     * Construct Point3D based on other point
     *
     * @param copy Point to clone
     */
    public Point3D(Point3D copy) {
        this._x = copy.getX();
        this._y = copy.getY();
        this._z = copy.getZ();
    }

    /**
     * Returns the x-coordinate of this point.
     *
     * @return the x-coordinate of the point.
     */
    public double getX() {
        return this._x;
    }

    /**
     * Sets the x-coordinate of this point.
     *
     * @param num the new x-coordinate of the point.
     */
    public void setX(double num) {
        this._x = num;
    }

    /**
     * Returns the y-coordinate of this point.
     *
     * @return the y-coordinate of the point.
     */
    public double getY() {
        return _y;
    }

    /**
     * Sets the y-coordinate of this point.
     *
     * @param num the new y-coordinate of the point.
     */
    public void setY(double num) {
        this._y = num;
    }

    /**
     * Returns the z-coordinate of this point.
     *
     * @return the z-coordinate of the point.
     */
    public double getZ() {
        return _z;
    }

    /**
     * Sets the z-coordinate of this point.
     *
     * @param num the new z-coordinate of the point.
     */
    public void setZ(double num) {
        this._z = num;
    }

    /**
     * Returns a string representation of this point in the format "(x,y,z)".
     *
     * @return a string representation of the point.
     */
    public String toString() {
        return ("(" + this.getX() + "," + this.getY() + "," + this.getZ() + ")");
    }

    /**
     * Compares this point to another point based on their coordinates.
     *
     * @param other the point to compare with this point.
     * @return true if the coordinates of both points are equal, false otherwise.
     */
    public boolean equals(Point3D other) {
        return (this.getX() == other.getX() &&
                this.getY() == other.getY() &&
                this.getZ() == other.getZ());
    }

    /**
     * Determines if this point is above another point in the z-axis.
     *
     * @param other the reference point to compare against.
     * @return true if this point is above the other point.
     */
    public boolean isAbove(Point3D other) {
        return (this.getZ() > other.getZ());
    }

    /**
     * Determines if this point is under another point in the z-axis.
     *
     * @param other the reference point to compare against.
     * @return true if this point is under the other point.
     */
    public boolean isUnder(Point3D other) {
        return other.isAbove(this);
    }

    /**
     * Determines if this point is to the left of another point in the y-axis.
     *
     * @param other the reference point to compare against.
     * @return true if this point is to the left of the other point.
     */
    public boolean isLeft(Point3D other) {
        return (this.getY() < other.getY());
    }

    /**
     * Determines if this point is to the right of another point in the y-axis.
     *
     * @param other the reference point to compare against.
     * @return true if this point is to the right of the other point.
     */
    public boolean isRight(Point3D other) {
        return other.isLeft(this);
    }

    /**
     * Determines if this point is behind another point in the x-axis.
     *
     * @param other the reference point to compare against.
     * @return true if this point is behind the other point.
     */
    public boolean isBehind(Point3D other) {
        return (this.getX() < other.getX());
    }

    /**
     * Determines if this point is in front of another point in the x-axis.
     *
     * @param other the reference point to compare against.
     * @return true if this point is in front of the other point.
     */
    public boolean isInFrontOf(Point3D other) {
        return other.isBehind(this);
    }

    /**
     * Moves this point by specified deltas in the x, y, and z axes.
     *
     * @param dx the change along the x-axis.
     * @param dy the change along the y-axis.
     * @param dz the change along the z-axis.
     */
    public void move(double dx, double dy, double dz) {
        this.setX(this.getX() + dx);
        this.setY(this.getY() + dy);
        this.setZ(this.getZ() + dz);
    }

    /**
     * Calculates distance between this point and another point.
     *
     * @param p the other point to calculate the distance from.
     * @return the distance between this point and another point.
     */
    public double distance(Point3D p) {
        double powX = this.pow(this.getX(), p.getX());
        double powY = this.pow(this.getY(), p.getY());
        double powZ = this.pow(this.getZ(), p.getZ());
        return Math.sqrt(powX + powY + powZ);
    }

    /**
     * Computes the square of the distance between two coordinates.
     *
     * @param x1 the first coordinate.
     * @param x2 the second coordinate.
     * @return the square of the distance between the two coordinates.
     */
    private double pow(double x1, double x2) {
        return Math.pow(x1 - x2, 2);
    }
}
