import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * This Class implements set of operations on any newtonian particle.
 */
public class SimpleProjectileTest {
  //SimpleProjectile s = new SimpleProjectile(23.043022f, -5.436577f, 0.0f, 0.0f);
  SimpleProjectile s1 = new SimpleProjectile(0.0f, 0.0f, 0.0f, 10.0f);
  SimpleProjectile s2 = new SimpleProjectile(0.0f, 0.0f, 10.0f, 10.0f);
  SimpleProjectile s3 = new SimpleProjectile(0.0f, 0.0f, 10.0f, -10.0f);
  SimpleProjectile s4 = new SimpleProjectile(0.0f, 0.0f, -10.0f, 10.0f);


  /**
   * This test is used to test the state of the particle.
   */
  @Test
  public void test1() {
    //touch down
    assertEquals("At time 2.04: position is (0.00,0.00)", s1.getState(2.0387f));
  }

  @Test
  public void test2() {
    //negative time
    assertEquals("At time -2.04: position is (0.00,0.00)", s1.getState(-2.0387f));
  }

  @Test
  public void test3() {
    //mid air
    assertEquals("At time 1.00: position is (0.00,5.09)", s1.getState(1.0f));
  }

  @Test
  public void test4() {
    //after touch down
    assertEquals("At time 6.00: position is (0.00,0.00)", s1.getState(6.0f));
  }

  @Test
  public void test5() {
    //touch down
    assertEquals("At time 2.04: position is (20.39,0.00)", s2.getState(2.0387f));
  }

  @Test
  public void test6() {
    //after touch down
    assertEquals("At time 3.00: position is (20.39,0.00)", s2.getState(3.0f));
  }

  @Test
  public void test7() {
    //mid air
    assertEquals("At time 1.00: position is (10.00,5.09)", s2.getState(1.0f));
  }

  @Test
  public void test8() {
    //negative time
    assertEquals("At time 2.04: position is (-20.39,0.00)", s4.getState(-5.0f));
  }

  @Test
  public void test9() {
    //touch down
    assertEquals("At time 2.04: position is (-20.39,0.00)", s4.getState(2.0387f));
  }

  @Test
  public void test10() {
    //after touch down
    assertEquals("At time 5.00: position is (-20.39,0.00)", s4.getState(5.0f));
  }

  @Test
  public void test11() {
    //mid air
    assertEquals("At time 1.00: position is (-10.00,5.09)", s4.getState(1.0f));
  }

  @Test
  public void test12() {
    //negative time
    assertEquals("At time -5.00: position is (0.00,0.00)", s3.getState(-5.0f));
  }

  @Test
  public void test13() {
    //touch down
    assertEquals("At time 2.04: position is (0.00,0.00)", s3.getState(2.0387f));
  }

  @Test
  public void test14() {
    //after touch down
    assertEquals("At time 5.00: position is (0.00,0.00)", s3.getState(5.0f));
  }

  @Test
  public void test15() {
    //mid air
    assertEquals("At time 1.00: position is (0.00,0.00)", s3.getState(1.0f));
  }


}