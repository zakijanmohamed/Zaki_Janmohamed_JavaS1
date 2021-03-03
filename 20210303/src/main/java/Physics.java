public class Physics {
    public double calculateForce (double mass, double acceleration){
        return mass*acceleration;
    }

    public double calculateVelocity(double distance1, double distance2,double time1, double time2){
        double velocity = (distance2-distance1)/(time2-time1);
        return velocity;
    }

    public double calculateMass(double weight, double gravity){
        return weight/gravity;
    }

    public double calculateAcceleration(double velocity1, double velocity2, double time1, double time2){
        double acceleration =(velocity2-velocity1)/(time2-time1);
        return acceleration;

    }

    public double calculateDistance(double velocity, double time){
        return velocity*time;
    }
}
