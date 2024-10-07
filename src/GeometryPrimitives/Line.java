package GeometryPrimitives;
//206750911 Hodaya Machluf

import Collision.Rectangle;

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-04-13
 * Class GeometryPrimitives.Line gets two x`s values and two y`s values. it creates
 *  a new point type objects - the start and end points of a line.
 *  it also calculates the length of a given segment and the middle point of the line.
 *  in addition, the method can compare between two segments, checks if them equal
 *  or intersect and find their intersection point.
 *
 */
public class Line {

    private static final double ZERO = 0;
    private static final double TWO = 2;
    private static final double EPSILON = 0.000001;
    //define variables for the line`s start and end points.
    private Point start;
    private Point end;
    private Line line;
    private Point uppaerLeft;


    /**
     * constructor
     * <p>
     * assigns the two GeometryPrimitives.Point objects values and address in
     * the start and end points of the segment.
     * </p>
     *
     * @param start Description: The starting point of a segment
     * @param end   Description: The ending point of a segment
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * constructor
     * <p>
     * Creates two GeometryPrimitives.Point objects - 'start' and 'end' for
     * the given two GeometryPrimitives.Point values.
     * </p>
     *
     * @param x1 Description: the x`s value of the start point
     * @param y1 Description: the y`s value of the start point
     * @param x2 Description: the x`s value of the end point
     * @param y2 Description: the y`s value of the end point
     */
    // constructors
    public Line(double x1, double y1, double x2, double y2) {
        start = new Point(x1, y1);
        end = new Point(x2, y2);
    }


    /**
     * length Method
     * <p>
     * length Method checks the len of a given segment
     * by calculate the distance between its start and end points
     * using distance method.
     * </p>
     *
     * @return double.
     */
    public double length() {
        // variable that gets the distance between the
        // start and end points
        double len = start.distance(end);
        // Return the length of the line
        return len;
    }

    /**
     * middle Method
     * <p>
     * middle Method defines variables for the X and Y values of two points and
     * calculates the midpoint by adding the X values divided by 2
     * and adding the Y values divided by 2.
     * After the calculation, the method creates a new object GeometryPrimitives.Point for the middle point
     * and returns it.
     * </p>
     *
     * @return GeometryPrimitives.Point.
     */

    public Point middle() {
        //assign the start point and end point values into variables
        double x1 = start.getX();
        double y1 = start.getY();
        double x2 = end.getX();
        double y2 = end.getY();
        //Calculating the X and Y values of the midpoint by
        // adding the X values of the end and start points and
        // dividing by 2 and adding the Y values of the end and
        // start points and dividing by 2
        double midX = (x1 + x2) / TWO;
        double midY = (y1 + y2) / TWO;
        // Returns the middle point of the line
        return new Point(midX, midY);
    }

    /**
     * start Method
     * <p>
     * start Method returns the start point of a given segment.
     * </p>
     *
     * @return GeometryPrimitives.Point.
     */
    public Point start() {
        // Returns the start point of the line
        return start;
    }

    /**
     * end Method
     * <p>
     * end Method returns the end point of a given segment.
     * </p>
     *
     * @return GeometryPrimitives.Point.
     */
    public Point end() {
        // Returns the end point of the line
        return end;
    }

    /**
     * parallelToY Method.
     * <p>
     * parallelToY Method checks if the start x`s value equal to the end x`s value of a
     * given line. if so, the line parallel to y axe and the method returns true.
     * otherwise, the method returns false.
     * </p>
     *
     * @return boolean.
     */
    public boolean parallelToY() {
        //define the x`s value of the start & end points
        double xStart = this.start.getX();
        double xEnd = this.end.getX();

        // check if the values are equal
        if (xStart == xEnd) {
            return true;
        }
        return false;
    }

    /**
     * parallelToX Method
     * <p>
     * parallelToY Method checks if the start y`s value equal to the end y`s value of a
     * given line. if so, the line parallel to x axe and the method returns true.
     * otherwise, the method returns false.
     * </p>
     *
     * @param other Description: a given segment that The method checks if its start&end y`s values
     *              are equal.
     * @return boolean.
     */

    public boolean parallelToX(Line other) {
        //define the y`s value of the start & end points
        double yStart = start.getY();
        double yEnd = end.getY();

        // check if the values are equal
        if (yStart == yEnd) {
            return true;
        }
        return false;
    }

    /**
     * pointOnLine Method
     * <p>
     * parallelToY Method checks if the start x`s value equal to the end x`s value of a
     * given line. if so, the line parallel to y axe and the method returns true.
     * otherwise, the method returns false.
     * * </p>
     *
     * @param intersection Description: a given intersection point between two segments.
     *                     The method checks if the point is on the segment.
     * @return boolean.
     */
    public boolean pointOnLine(Point intersection) {
        double x = intersection.getX();
        double y = intersection.getY();
        double x1 = this.start.getX();
        double y1 = this.start.getY();
        double x2 = this.end.getX();
        double y2 = this.end.getY();

        if (Math.abs(x - x1) <= EPSILON) {
            x = x1;
        } else if (Math.abs(x - x2) <= EPSILON) {
            x = x2;
        }

        if (Math.abs(y - y1) <= EPSILON) {
            y = y1;
        } else if (Math.abs(y - y2) <= EPSILON) {
            y = y2;
        }

        // checks if the point`s values are between the start&end values of the line
        if (x >= Math.min(x1, x2) && (x <= Math.max(x1, x2))
                && (y >= Math.min(y1, y2) && (y <= Math.max(y1, y2)))) {
            return true;
        }
        return false;
    }

    /**
     * isLineContained Method
     * <p>
     * isLineContained Method checks if one line contined in another line by
     * checks if one line`s start point bigger or eqoul to other line`s start point
     * and if other line`s end point bigger or equal to one line`s end point by using comparePoint
     * method. if one line contained the other line, the method returns true. otherwise, the method
     * returns false.
     * </p>
     *
     * @param other Description: a given segment that The method checks if it contained another line.
     * @return boolean.
     */
    public boolean isLineContained(Line other) {
        // assign point`s values to variable
        Point start1 = this.start;
        Point end1 = this.end;
        Point start2 = other.start;
        Point end2 = other.end;
        //check if one line contined in other line
        return ((start1.comparePoint(start2)) && (end2.comparePoint(end1)));
    }


    /**
     * isIntersecting Method
     * <p>
     * isIntersecting Method checks mutual states between two segments.
     * first, it assigns the x,y values of the start and end point of the segment,
     * for each of the segments. It then checks the slopes of the lines by a formula to calculate the
     * slope and the intersection of the segments with the Y axis.
     * If the slopes are equal - the segments are parallel (and therefore do not intersect) - it returns false.
     * Otherwise, it calculate the orientation of the two segments using the cross product formula and assigns
     * the result in variable named "checkCross". if checkCross==0 - the two segments are collinear
     * (crossing or continuing). if checkCross>0 or checkCross<0 : it finding the intersection point
     * of the two segments and uses additional checks in order to check if the segment intersect.
     * </p>
     *
     * @param other Description: a given segment that The method performs tests
     *              on it and on a given segment in order to check if they intersect.
     * @return boolean.
     */
    // Returns true if the lines intersect, false otherwise
    public boolean isIntersecting(Line other) {
        //gets the start and end points of the segment, for each of
        // the segments
        double x1 = start.getX();
        double y1 = start.getY();
        double x2 = end.getX();
        double y2 = end.getY();
        double x3 = other.start.getX();
        double y3 = other.start.getY();
        double x4 = other.end.getX();
        double y4 = other.end.getY();
        Line line1 = new Line(start, end);
        Line line2 = new Line(other.start, other.end);

        // check if the lines are continus
        if (line1.continus(line2)) {
            return true;
        }

        if (line1.equals(line2)) {
            return true;
        }


        //Calculation of the equation of the line segments y = m*x + n:

        //Calculate the slope of the first section
        double m1 = ((y1 - y2) / (x1 - x2));
        //Calculate the slope of the second section
        double m2 = ((y3 - y4) / (x3 - x4));

        //Calculation of the intersection point of the first segment with the Y axis
        double n1 = y1 - (m1 * x1);
        //Calculation of the intersection point of the second segment with the Y axis
        double n2 = y3 - (m2 * x3);

        // if the slopes are not equal
        if (m1 != m2) {
            // check if only one line parallel to y axe and if the lines have intersection point
            if (line1.parallelToY()) {
                if ((line2.start.getY() >= Math.min(line1.start.getY(), line1.end.getY())
                        && (line2.start.getY() <= Math.max(line1.start.getY(), line1.end.getY())))
                        || (line2.end.getY() >= Math.min(line1.start.getY(), line1.end.getY())
                        && (line2.end.getY() <= Math.max(line1.start.getY(), line1.end.getY())))) {
                    // calculate y
                    double yInter = ((m2 * x1) + n2);

                    //check if the intersection point on the lines
                    if (line1.pointOnLine(new Point(x1, yInter))
                            && (line2.pointOnLine(new Point(x1, yInter)))) {
                        return true;
                    }
                }

            } else if (line2.parallelToY()) {
                    if ((line1.start.getY() >= Math.min(line2.start.getY(), line2.end.getY())
                            && (line1.start.getY() <= Math.max(line2.start.getY(), line2.end.getY())))
                            || (line1.end.getY() >= Math.min(line2.start.getY(), line2.end.getY())
                            && (line1.end.getY() <= Math.max(line2.start.getY(), line2.end.getY())))) {
                        // calculate y
                        double yInter = ((m1 * x3) + n1);

                        //check if the intersection point on the lines
                        if (line1.pointOnLine(new Point(x3, yInter))) {
                            return true;
                        }
                    }
                // check if only one line parallel to x axe and if the lines have intersection point
            } else if (parallelToX(line1)) {
                // calculate x
                double xInter = ((y1 - n2) / m2);
                //check if the intersection point on the lines
                if (line1.pointOnLine(new Point(xInter, y1))
                                        && (line2.pointOnLine(new Point(xInter, y1)))) {
                    return true;
                }
            } else if (parallelToX(line2)) {
                // calculate x
                double xInter = ((y3 - n1) / m1);
                //check if the intersection point on the lines
                if (line1.pointOnLine(new Point(xInter, y3))
                                    && (line2.pointOnLine(new Point(xInter, y3)))) {
                    return true;
                }
                // Checking whether the segments have an intersection
                // point given that one of the segments is parallel to
                // the X axis and the other is parallel to the Y axis
            } else if (parallelToX(line1) && line2.parallelToY()) {
                //check if the intersection point on the lines
                if ((line1.pointOnLine(new Point(x3, y1)))
                                    && (line2.pointOnLine(new Point(x3, y1)))) {
                    return true;
                }
            } else {
                // calculate potentiol intersection point
                double x = ((n2 - n1) / (m1 - m2));
                double y = (x * m1) + n1;
                //check if the intersection point on the lines
                if (line1.pointOnLine(new Point(x, y))
                                    && (line2.pointOnLine(new Point(x, y)))) {
                    return true;
                } else if (parallelToX(line2) && line1.parallelToY()) {
                    //check if the intersection point on the line
                    if ((line1.pointOnLine(new Point(x1, y3)))
                                && (line2.pointOnLine(new Point(x1, y3)))) {
                        return true;
                    }
                    //if the slopes not eqoal and there is no intersecion point
                } else {
                    return false;
                }
            }
        }
        // if the slopes are equal
        if (m1 == m2) {
            // the segments not continues
            if (!(line1.continus(line2))) {
                // Checking if one line merges with the other line
                if ((line1.pointOnLine(line2.start)) || (line1.pointOnLine(line2.end))
                        || (line2.pointOnLine(line1.start))
                        || (line2.pointOnLine(line1.end))) {
                    return true;
                }
            }
            // check if the segments parallel to X axe
            if ((parallelToX(line1)) && (parallelToX(line2))) {

                // if the start y`s values of the two points are equal
//                if (line1.start.getY() == line2.start.getY()) {
                if (start.equalsY(line2.start.getY())) {
                    // check if there is a mutual point
                    if ((line1.pointOnLine(new Point(x3, y1)))
                                    && (line2.pointOnLine(new Point(x1, y3)))) {
                        return true;
                    }
                    // if they are parallel to the X-axis and do not have the same Y value at any
                    // point of either segment
                } else {
                    return false;
                }
            }
        }
        return false;
    }


    /**
     * intersectionWith Method
     * <p>
     * intersectionWith Method assigns the x,y values of the start and end point of the segment,
     * for each of the segments. then, it checks if there is an intersection between the segments
     * by using isIntersecting method. if so - it calculation of the equation of the line segments y = m*x + n
     * for each one of the segments, then calculate the intersection point.
     * it create a new object GeometryPrimitives.Point for the values of the intersection point and returns it.
     * else, it returns null.
     * </p>
     *
     * @param other Description: a given segment that The method performs tests
     *              on it and on a given segment in order to check if they intersect.
     * @return GeometryPrimitives.Point.
     */
    // Returns the intersection point if the lines intersect,
    // and null otherwise.
    public Point intersectionWith(Line other) {
        double x1 = start.getX();
        double y1 = start.getY();
        double x2 = end.getX();
        double y2 = end.getY();
        double x3 = other.start.getX();
        double y3 = other.start.getY();
        double x4 = other.end.getX();
        double y4 = other.end.getY();
        double m1 = ((start.getY() - end.getY()) / (start.getX() - end.getX()));
        double m2 = ((other.start.getY() - other.end.getY()) / (other.start.getX() - other.end.getX()));
        double n1 = start.getY() - (m1 * x1);
        double n2 = y3 - (m2 * x3);
        Line line1 = new Line(start, end);
        Line line2 = new Line(other.start, other.end);

        // check if the lines are equal
        if (line1.equals(line2)) {
            return null;
        }

        if (line1.isIntersecting(line2)) {
            if (m1 == m2) {
                // check if the slopes equal and the segments not continues
                if (!(line1.continus(line2))) {
                    // Checking if one line merges with the other line
                    if ((line1.pointOnLine(line2.start)) || (line1.pointOnLine(line2.end))
                            || (line2.pointOnLine(line1.start))
                            || (line2.pointOnLine(line1.end))) {
                        return null;
                    }
                }
                // if the lines continues
                if (line1.continus(line2)) {
                    //Checks if one line is contained in another line
                    if (line1.isLineContained(line2) || line2.isLineContained(line1)) {
                        return null;
                    }
                    // Checks if the lines continue
                    if ((line1.pointOnLine(line2.start) || line1.pointOnLine(line2.end))
                            && ((line2.pointOnLine(line1.start)) || (line2.pointOnLine(line1.end)))) {
                        return line1.continusWith(line2);
                    }
                }
            }
            // if the slopes are not equal
            if (m1 != m2) {
                //if one line parallel to Y axe
                if (line1.parallelToY()) {
                    // calculate y
                    double yInter = ((m2 * x1) + n2);

                    if (line1.start.equalsY(line2.start.getY())) {
                        return new Point(line1.start.getX(), line1.start.getY());
                    }

                    if (line1.start.equalsX(line2.start.getX())) {
                        return new Point(line1.start.getX(), line1.start.getY());
                    }


                    //check if the intersection point on the line
                    if (line1.pointOnLine(new Point(x1, yInter))
                                && line2.pointOnLine(new Point(x1, yInter))) {
                        return new Point(x1, yInter);
                    }
                } else if (line2.parallelToY()) {

                    if (line2.start.equalsY(line1.start.getY())) {
                        return new Point(line2.start.getX(), line2.start.getY());
                    }

                    if (line2.start.equalsX(line1.start.getX())) {
                        return new Point(line2.start.getX(), line2.start.getY());
                    }


                    // calculate y
                    double yInter = ((m1 * x3) + n1);
                    //check if the intersection point on the line
                    if (line1.pointOnLine(new Point(x3, yInter))
                                && (line2.pointOnLine(new Point(x3, yInter)))) {
                        return new Point(x3, yInter);
                    }
                    // check if only one line parallel to x axe and if the lines have intersection point
                } else if (parallelToX(line1)) {

                    // calculate x
                    double xInter = ((y1 - n2) / m2);
                    //check if the intersection point on the line
                    if (line1.pointOnLine(new Point(xInter, y1))
                                && (line2.pointOnLine(new Point(xInter, y1)))) {
                        return new Point(xInter, y1);
                    }
                } else if (parallelToX(line2)) {
                    // calculate x
                    double xInter = ((y3 - n1) / m1);
                    //check if the intersection point on the line
                    if (line1.pointOnLine(new Point(xInter, y3))
                                && (line2.pointOnLine(new Point(xInter, y3)))) {
                        return new Point(xInter, y3);
                    }
                }
                // Checking whether the segments have an intersection
                // point given that one of the segments is parallel to
                // the X axis and the other is parallel to the Y axis

                if (parallelToX(line1) && line2.parallelToY()) {
                    //check if the intersection point on the line
                    if ((line1.pointOnLine(new Point(x3, y1)))
                            && (line2.pointOnLine(new Point(x3, y1)))) {
                        return new Point(x3, y1);
                    }
                } else if (parallelToX(line2) && line1.parallelToY()) {
                    //check if the intersection point on the line
                    if ((line1.pointOnLine(new Point(x1, y3)))
                                    && (line2.pointOnLine(new Point(x3, y1)))) {
                        return new Point(x1, y3);
                    }
                } else {
                    // calculate potentiol intersection point
                    double x = ((n2 - n1) / (m1 - m2));
                    double y = (x * m1) + n1;
                    //check if the intersection point on the lines
                    if (line1.pointOnLine(new Point(x, y))
                                    && (line2.pointOnLine(new Point(x, y)))) {
                        return new Point(x, y);
                    } else {
                        return null;
                    }
                }
            }

        }
        return null;
    }


    /**
     * equals Method
     * <p>
     * equals Method checks if two segments are equal by comparing them x,y values of the start
     * and end points of each segment.
     * if the start&end points of the first segment equals to the start&end points of the second segment
     * or if the start point of the first segment and the end point of the second segment are equal &
     * the end point of the first segment and the start point of the second segment are equal
     * the segments are equal.
     * </p>
     *
     * @param other Description: a given segment that The method performs tests
     *              on it and on a given segment in order to check if they intersect.
     * @return boolean.
     */

    public boolean equals(Line other) {
        //checks if the given segment == null
        if (other == null) {
            return false;
        }
        //comparing the start&end points of one segment to other start&end points of other segment.
        //return true is the lines are equal, false otherwise
        return (((this.start.equals(other.start)) && (this.end.equals(other.end)))
                || ((this.start.equals(other.end)) && (this.end.equals(other.start))));

    }


    /**
     * continus Method.
     * <p>
     * continus Method Checks if the start point of one line is equal to the end point of another line
     * </p>
     *
     * @param other Description: a line to which the end or start point of another line is compared.
     * @return boolean.
     */
    public boolean continus(Line other) {
        //checks if the given segment == null
        if (other == null) {
            return false;
        }
        // comparing the start&end points of one segment to other start&end points of other segment.
        // return true if the lines have a common point, false otherwise
        if (((this.start.equals(other.start)) && (!((this.end.equals(other.end)))))
                || ((this.end.equals(other.end)) && (!(this.start.equals(other.start))))) {
            return true;
        }
        if (((this.start.equals(other.end)) && (!(this.end.equals(other.start))))
                || ((this.end.equals(other.start))) && (!(this.start.equals(other.end)))) {
            return true;
        }
        // the segments not continues
        return false;
    }

    /**
     * continusWith Method
     * <p>
     * continusWith Method returns the mutual point of this line and another line.
     * </p>
     *
     * @param other Description: a line to which the end or start point of another line is compared.
     * @return GeometryPrimitives.Point.
     */
    public Point continusWith(Line other) {
        //checks if the given segment == null
        if (other == null) {
            return null;
        }
        // comparing the start&end points of one segment to other start&end points of other segment.
        // return true if the lines have a common point, false otherwise
        if ((this.start.equals(other.start)) || (this.start.equals(other.end))) {
            return this.start;
        } else if ((this.end.equals(other.end)) || (this.end.equals(other.start))) {
            return this.end;
        }
        return null;
    }

    /**
     * closestIntersectionToStartOfLine Method
     * <p>
     * closestIntersectionToStartOfLine Method checks if a line intersect with one of a given rectangle`s sides.
     * if so, it returns the closest intersection point to the start of the line. if this line does not
     * intersect with the rectangle, it returns null.
     * </p>
     *
     * @param rect Description: a given rectangle that a line may intersect with one of it`s sides.
     * @return GeometryPrimitives.Point.
     */
    // If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.
    public Point closestIntersectionToStartOfLine(Rectangle rect) {

        // checks if the rectangle`s list of intersection points is empty, if so - return null
        if (rect.intersectionPoints(this).isEmpty()) {
            return null;
        }

        //assign the first point in the list of intersection points of the rectangle into a variable
        Point closestCollisionPoint = rect.intersectionPoints(this).get(0);
        //assign the distance between the start point of the line and the first point
        // in the list of intersection points of the rectangle into a variable
        double closestDistance = start().distance(rect.intersectionPoints(this).get(0));

        //check evry element in the list of intersection points of the rectangle
        for (Point point : rect.intersectionPoints(this)) {
            // clculate the distance between the start point of the line and the elment in the list
            double distance = start().distance(point);
            // if the distance smaller than the closestDistance that difined
            if (Math.abs(distance - closestDistance) <= EPSILON) {
                //assign the current point in the list to the closestDistance variable
                closestCollisionPoint = point;
                //assign the diatance between the start point of the line and the elment in the list
                closestDistance = distance;
            }
        }

        return closestCollisionPoint;

    }

}



