/**
 * This Class implements set of operations on any newtonian particle.
 */
public class SimpleProjectile implements Particle {

  public static final float GRAVITATIONAL = -9.81f;
  public float x;
  public float y;
  public float vx;
  public float vy;

  /**
   * Constructor is used to create an object of SimpleProjectile.
   *
   * @param x  the initial x coordinate of the newtonian particle
   * @param y  the initial y coordinate of the newtonian particle
   * @param vx the initial velocity of the newtonian particle in x coordinate
   * @param vy the initial velocity of the newtonian particle in y coordinate
   */
  public SimpleProjectile(float x, float y, float vx, float vy) {
    this.x = x;
    this.y = y;
    this.vx = vx;
    this.vy = vy;
  }

  /**
   * This method is used to get the state of the particle.
   *
   * @param time the time at which the state must be obtained.
   */
  public String getState(float time) {
    float x;
    float y;

    if (time < 0) {
      x = this.x;
      y = this.y;
    } else {

      if (this.vy <= 0.0f) {
        //float dispX = findXDisplacement(this.x, this.vx, time);
        return "At time " + roundOffFunction(time)
                + ": position is (" + roundOffFunction(this.x)
                + "," + roundOffFunction(this.y) + ")";
      }

      if (time > touchDownTime(vy)) {
        x = findXDisplacement(this.x, vx, touchDownTime(vy));
      } else {
        x = findXDisplacement(this.x, vx, time);
      }


      y = findYDisplacement(this.y, vy, time);
      if (y < this.y) {
        y = this.y;
      }
    }
    //System.out.println("the value of y in getState is::::: "+y);
    return "At time " + roundOffFunction(time)
            + ": position is (" + roundOffFunction(x) + "," + roundOffFunction(y) + ")";
  }


  /**
   * This method is used to return the displacement in X coordinate.
   *
   * @param x    of the newtonian particle at any given time
   * @param vx   of the newtonian particle at any given time
   * @param time of the newtonian particle at any given time
   * @return return the displacement in X coordinate
   **/
  public float findXDisplacement(float x, float vx, float time) {

    float sx = x + (vx * time);
    //System.out.println("this is sx "+sx);
    return sx;
  }

  /**
   * This method is used to return the displacement in Y coordinate.
   *
   * @param y    of the newtonian particle at any given time
   * @param vy   of the newtonian particle at any given time
   * @param time of the newtonian particle at any given time
   * @return return the displacement in Y coordinate
   **/
  public float findYDisplacement(float y, float vy, float time) {

    float test1 = ((1.0f / 2.0f) * GRAVITATIONAL * (time * time));
    System.out.println(test1);
    float test2 = (vy * time);
    System.out.println(test2);
    float sy = y + test2 + test1;
    System.out.println(sy);
    return sy;
  }

  /**
   * method to find the touchdown time.
   *
   * @param vy of the newtonian particle at any given time
   * @return returns the touchdown time
   */
  public float touchDownTime(float vy) {
    float t = -(2 * vy) / GRAVITATIONAL;
    return t;
  }


  /**
   * This method is used to return double precision float value.
   *
   * @param position position of the newtonian particle at any given time
   * @return returns a double precision value
   **/
  public String roundOffFunction(float position) {

    return String.format("%.2f", position);
    /*DecimalFormat deci = new DecimalFormat("#.##");
    deci.setRoundingMode(RoundingMode.HALF_EVEN);
    return deci.format(position);*/


  }


}
