import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class PhysicsTest {
    Physics physics;

    @Before
    public void setUp(){ physics= new Physics();}

    @Test
    public void shouldCalculateProductOfMassAndAcceleration(){
        assertEquals(10.0,physics.calculateForce(5.0,2.0), 0);
        assertEquals(0, physics.calculateForce(0, 7), 0);
        assertEquals(8,physics.calculateForce(8,1),0);
            }
    @Test
    public void shouldCalculateVelocity() {
        assertEquals(1, physics.calculateVelocity(5.0, 10, 5, 10), 0);
        assertEquals(1,physics.calculateVelocity(1,2,1,2),0);
        assertEquals(5, physics.calculateVelocity(2, 27, 2, 7), 0);
    }

    @Test
    public void shouldCalculateWeightDividedByGravity(){
        assertEquals(25,physics.calculateMass(100,4),0);
        assertEquals(1,physics.calculateMass(25,25),0);
        assertEquals(.04,physics.calculateMass(1,25),0);
    }
    @Test
    public void shouldCalculateAcceleration(){
        assertEquals(12.5,physics.calculateAcceleration(27,2,10,8),0);
        assertEquals(1,physics.calculateAcceleration(1,2,1,2),0);
        assertEquals(5,physics.calculateAcceleration(2,27,2,7),0);
    }
    @Test
    public void shouldCalculateDistance(){
        assertEquals(100,physics.calculateDistance(25,4),0);
        assertEquals(0,physics.calculateDistance(0,5),0);
        assertEquals(1,physics.calculateDistance(1,1),0);
    }
}
