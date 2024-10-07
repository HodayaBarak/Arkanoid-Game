package Collision;

import GeometryPrimitives.Line;
import GeometryPrimitives.Point;

import java.awt.*;
import java.util.ArrayList;

//206750911 Hodaya Machluf

/** @author Hodaya Machluf
 * @version 19.0.2
 * @since 2023-05-04
 * Class collision.Rectangle creates a collision.Rectangle object from a given upper left point, width and height.
 * the method can return the rectangle values and aldo it`s intersection points with a given line.
 *
 */
public class Rectangle {
        //define variables
        private double width, height;
        private Point upperLeft;
        private Point upperRight;
        private Point bottomLeft;
        private Point bottomRight;


        /**
         * constructor
         * <p>
         * creates new object 'collision.Rectangle' and assigns the upperLeft and it`s width
         * and height in the rectangle`s fields.
         * then, it calculate the other rectangle`s vertices.
         * </p>
         * @param upperLeft Description: the upper left vertex.
         * @param width  Description: the rectangle`s width.
         * @param height  Description: the rectangle`s height.
         */
        // Create a new rectangle with location and width/height.
        public Rectangle(Point upperLeft, double width, double height) {
                this.width = width;
                this.height = height;
                this.upperLeft = upperLeft;
                // calculate the other rectangle`s vertices and assign them in the rectangles relevent fields
                this.upperRight = new Point((this.upperLeft.getX() + this.width), this.upperLeft.getY());
                this.bottomLeft = new Point(this.upperLeft.getX(), (this.upperLeft.getY() + this.height));
                this.bottomRight = new Point((this.bottomLeft.getX() + this.width), bottomLeft.getY());
        }



        /**
         * contains Method
         * <p>
         * contains Method  determines if a given point is contained within the rectangle.
         * </p>
         * @param point Description: the point to check for containment
         * @return boolean.
         */

        public boolean contains(Point point) {
                //the point to check for containment values
                double pointX = point.getX();
                double pointY = point.getY();
                //the rectangles points
                double rectX = upperLeft.getX();
                double rectY = upperLeft.getY();
                double rectRightX = rectX + width;
                double rectBottomY = rectY + height;

                return ((pointX >= rectX) && (pointX <= rectRightX) && (pointY >= rectY) && (pointY <= rectBottomY));
        }




        /**
         * intersectionPoints Method
         * <p>
         * intersectionPoints Method gets a rectangle and a specified line. it checks if the line
         * intersect with any of the rectangle`s sides. it returns a List of intersection points with
         * the specified line. if there is no intersection between the line and the rectangle`s sides - it
         * returns an empty list.
         * </p>
         * @param line Description: the line that may intersect with the rectangle.
         * @return java.util.List <>.
         */

        public java.util.List<Point> intersectionPoints(Line line) {



                //define list of intersection points
                ArrayList<Point> intersectionPoints = new ArrayList<>();

                // checkf if the specified line is intersect with any of the rectangle`s sides
                // if the if so - the intersection point added to the intersectionPoint list.
                if (line.isIntersecting(this.getUpperParallelX())) {

                        intersectionPoints.add(line.intersectionWith(this.getUpperParallelX()));
                }
                if (line.isIntersecting(this.getBottomParallelX())) {

                        intersectionPoints.add(line.intersectionWith(this.getBottomParallelX()));
                }
                ////////////////////////
                if (line.isIntersecting(this.getLeftParallelY())) {

                        intersectionPoints.add(line.intersectionWith(this.getLeftParallelY()));
                }
                if (line.isIntersecting(this.getRightParallelY())) {

                        intersectionPoints.add(line.intersectionWith(this.getRightParallelY()));
                }

                if ((this.getUpperParallelX().pointOnLine(line.start()))) {

                        intersectionPoints.add(line.start());

                } else if (this.getBottomParallelX().pointOnLine(line.start())) {
                        intersectionPoints.add(line.start());
                } else if (this.getLeftParallelY().pointOnLine(line.start())) {
                        intersectionPoints.add(line.start());
                } else if (this.getLeftParallelY().pointOnLine(line.start())) {
                        intersectionPoints.add(line.start());
                }
                // return the intersection points list (possibly empty)
                return intersectionPoints;

        }


        /**
         * getWidth Method
         * <p>
         * getWidth Method returns the rectangle`s width.
         * </p>
         * @return double.
         */
        // Return the width and height of the rectangle
        public double getWidth() {
                return this.width;
        }

        /**
         * getHeight Method
         * <p>
         * getHeight Method returns the rectangle`s height.
         * </p>
         * @return double.
         */
        public double getHeight() {
                return this.height;
        }


        /**
         * getUpperLeft Method
         * <p>
         * getUpperLeft Method returns the upper-left vertex of the rectangle.
         * </p>
         * @return GeometryPrimitives.Point.
         */
        // Returns the upper-left point of the rectangle.
        public Point getUpperLeft() {
                return this.upperLeft;
        }

        /**
         * getUpperRight Method
         * <p>
         * getUpperRight Method returns the upper-right vertex of the rectangle.
         * </p>
         * @return GeometryPrimitives.Point.
         */

        public Point getUpperRight() {
                return this.upperRight;
        }

        /**
         * getBottomLeft Method
         * <p>
         * getBottomLeft Method returns the bottom-left vertex of the rectangle.
         * </p>
         * @return GeometryPrimitives.Point.
         */

        public Point getBottomLeft() {
                return this.bottomLeft;
        }

        /**
         * getBottomRight Method
         * <p>
         * getBottomRight Method returns the bottom-right vertex of the rectangle.
         * </p>
         * @return GeometryPrimitives.Point.
         */

        public Point getBottomRight() {
                return this.bottomRight;
        }


        /**
         * getUpperParallelX Method
         * <p>
         * getUpperParallelX Method returns the upper side of the rectangle that parallel to X axe.
         * </p>
         * @return GeometryPrimitives.Line.
         */
        public Line getUpperParallelX() {
                return new Line(this.upperLeft, this.upperRight);
        }

        /**
         * getBottomParallelX Method
         * <p>
         * getBottomParallelX Method returns the bottom side of the rectangle that parallel to X axe.
         * </p>
         * @return GeometryPrimitives.Line.
         */
        public Line getBottomParallelX() {
                return new Line(this.bottomLeft, this.bottomRight);
        }
        /**
         * getLeftParallelY Method
         * <p>
         * getLeftParallelY Method returns the left side of the rectangle that parallel to Y axe.
         * </p>
         * @return GeometryPrimitives.Line.
         */
        public Line getLeftParallelY() {
                return new Line(this.upperLeft, this.bottomLeft);
        }
        /**
         * getRightParallelY Method
         * <p>
         * getRightParallelY Method returns the right side of the rectangle that parallel to Y axe.
         * </p>
         * @return GeometryPrimitives.Line.
         */
        public Line getRightParallelY() {
                return new Line(this.upperRight, this.bottomRight);
        }
}
