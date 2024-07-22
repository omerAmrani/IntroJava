package mmn._12;

/**
 * This class represents a Box3D
 *
 * @author Omer Amrani
 * @version 17.04.2024
 */
public class Box3D {
    private Point3D _base;
    private int _length;
    private int _width;
    private int _height;

    /**
     * Default constructor
     */
    public Box3D() {
        this._base = new Point3D();
        this._length = 1;
        this._width = 1;
        this._height = 1;
    }

    /**
     * Constructs a 3D box at a specified base point with dimensions.
     *
     * @param base   The front, left, lower point of the box.
     * @param length by x-axis
     * @param width  by y-axis
     * @param height by z-axis
     */
    public Box3D(Point3D base, int length, int width, int height) {
        this._base = base;
        this._length = positiveSide(length);
        this._width = positiveSide(width);
        this._height = positiveSide(height);
    }

    /**
     * Construct Box3D based on other box
     *
     * @param copy the Box3D object to be copied.
     */
    public Box3D(Box3D copy) {
        this._base = copy.getBase();
        this._length = copy.getLength();
        this._width = copy.getWidth();
        this._height = copy.getHeight();
    }

    /**
     * Returns the base point of the box.
     *
     * @return the base point of the box.
     */
    public Point3D getBase() {
        return this._base;
    }

    /**
     * Sets the base point of the box.
     *
     * @param p the new base point of the box.
     */
    public void setBase(Point3D p) {
        this._base = p;
    }

    /**
     * Returns the length of the box.
     *
     * @return the length of the box.
     */
    public int getLength() {
        return this._length;
    }

    /**
     * Sets the length of the box.
     *
     * @param num the new length of the box.
     */
    public void setLength(int num) {
        if (isPositive(num)) {
            this._length = num;
        }
    }

    /**
     * Returns the height of the box.
     *
     * @return the height of the box.
     */
    public int getHeight() {
        return this._height;
    }

    /**
     * Sets the height of the box.
     *
     * @param num the new height of the box.
     */
    public void setHeight(int num) {
        if (isPositive(num)) {
            this._height = num;
        }
    }

    /**
     * Returns the width of the box.
     *
     * @return the width of the box.
     */
    public int getWidth() {
        return this._width;
    }

    /**
     * Sets the width of the box.
     *
     * @param num the new width of the box.
     */
    public void setWidth(int num) {
        if (isPositive(num)) {
            this._width = num;
        }
    }

    /**
     * Returns a string representation of this Box3D.
     *
     * @return string in format "The base point is (x,y,z), length = l, width = w, height = h"
     */
    public String toString() {
        return ("The base point is " + this.getBase().toString() + ", length = " + this.getLength()
                + ", width = " + this.getWidth() + ", height = " + this.getHeight());
    }

    /**
     * Check if two boxes are equal
     *
     * @param other the Box3D object to compare this object to.
     * @return true if the boxes are equal, else false
     */
    public boolean equals(Box3D other) {
        return (this.getBase().equals(other.getBase()) &&
                this.getLength() == other.getLength() &&
                this.getWidth() == other.getWidth() &&
                this.getHeight() == other.getHeight());
    }

    /**
     * Move the box by dx, dy, dz
     *
     * @param dx the displacement of the box along the x-axis.
     * @param dy the displacement of the box along the y-axis.
     * @param dz the displacement of the box along the z-axis.
     * @return new Box3D object after moving
     */
    public Box3D move(double dx, double dy, double dz) {
        Point3D basePointCopy = new Point3D(this.getBase());
        basePointCopy.move(dx, dy, dz);
        return new Box3D(basePointCopy, this.getLength(),
                this.getWidth(), this.getHeight());
    }

    /**
     * Get the upper right back point of the box
     *
     * @return the upper right back point of the box
     */
    public Point3D getUpRightBackPoint() {
        // Get copy of the base point for manipulation
        Point3D upRightBackPoint = new Point3D(this.getBase());

        // Move the point to the location
        // The length is in the negative direction
        upRightBackPoint.move(-this.getLength(), this.getWidth(), this.getHeight());
        return upRightBackPoint;
    }

    /**
     * Get the center point of the box
     *
     * @return the center point of the box
     */
    public Point3D getCenter() {
        final double HALF = 0.5;
        Point3D center = new Point3D(this.getBase());

        // Get half of the sizes to get center
        double halfLength = HALF * this.getLength();
        double halfWidth = HALF * this.getWidth();
        double halfHeight = HALF * this.getHeight();

        // Move the point to the location
        // The length is in the negative direction
        center.move(-halfLength, halfWidth, halfHeight);
        return center;
    }

    /**
     * Calculate the distance between two boxes
     *
     * @param other the Box3D object to calculate the distance to.
     * @return the distance between the two boxes
     */
    public double distance(Box3D other) {
        return this.getCenter().distance(other.getCenter());
    }

    /**
     * Calculate the volume of the box
     *
     * @return the volume of the box
     */
    public int getVolume() {
        return (this.getLength() * this.getWidth() * this.getHeight());
    }

    /**
     * Calculate the surface area of the box
     *
     * @return the surface area of the box
     */
    public int getSurfaceArea() {
        final int FACES_NUMBER = 2;
        int lengthWidthFace = this.getLength() * this.getWidth();
        int lengthHeightFace = this.getLength() * this.getHeight();
        int widthHeightFace = this.getWidth() * this.getHeight();

        // For 2 of each face
        return (FACES_NUMBER * (lengthWidthFace + lengthHeightFace + widthHeightFace));
    }

    /**
     * Check if the box is larger than other box
     *
     * @param other the Box3D object to compare this object to.
     * @return true if this box is larger than the other box, else false
     */
    public boolean isLargerCapacity(Box3D other) {
        return (this.getVolume() > other.getVolume());
    }

    /**
     * Check if the box contains other box
     *
     * @param other the Box3D object to compare this object to.
     * @return true if this box contains the other box, else false
     */
    public boolean contains(Box3D other) {
        return (this.getLength() > other.getLength() &&
                this.getWidth() > other.getWidth() &&
                this.getHeight() > other.getHeight());
    }

    /**
     * Check if the box is above other box
     *
     * @param other the Box3D object to compare this object to.
     * @return true if this box is above the other box, else false
     */
    public boolean isAbove(Box3D other) {
        return (this.getBase().isAbove(other.getUpRightBackPoint()));
    }

    /**
     * For the constructor, get the initial side or 1.
     *
     * @param side of the box.
     * @return initial side or 1
     */
    private int positiveSide(int side) {
        final int DEFAULT_SIDE = 1;

        if (isPositive(side)) return side;
        return DEFAULT_SIDE;
    }

    /**
     * @param number to check
     * @return true if number is positive, else false
     */
    private boolean isPositive(int number) {
        return (number > 0);
    }
}
