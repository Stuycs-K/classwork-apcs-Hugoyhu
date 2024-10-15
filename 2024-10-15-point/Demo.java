public class Demo{

  /*
  Write this method third. Test it then move on
  to the others.
  */
  public static double distance(Point a, Point b){
    return Math.sqrt(
      Math.pow((a.getX() - b.getX()), 2) +
      Math.pow((a.getY() - b.getY()), 2)
    );
  }

  public static void main(String[]args){
    Point p1 = new Point(1,1);
    Point p2 = new Point(-1,-1);
    Point p3 = new Point(3,4);
    System.out.println( p3);
    System.out.println( distance(p1,p2));
    System.out.println( Point.distance(p1,p2));
    System.out.println( p1.distanceTo(p2));
    System.out.println( "Expected: 3.605551275463989, Received: " + distance(p1, p3));
    System.out.println( "Expected: 6.4031242374328485, Received: " + distance(p2, p3));

    Point t1 = new Point(0, 0);
    Point t2 = new Point(1, 0);
    Point t3 = new Point(0.5, 0.5 * Math.sqrt(3));

    System.out.println("Expected distances: 1: " + distance(t1, t2) + ", " + distance(t2, t3) + ", " + distance(t1, t3));
  }
}
