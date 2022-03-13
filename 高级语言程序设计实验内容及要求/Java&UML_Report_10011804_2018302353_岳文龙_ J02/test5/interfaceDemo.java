interface Vehicle{
    public void start(int n);
    public void stop(int m);
}

class Bike implements Vehicle{
    public void start(int n){
        System.out.println("Bike.start()等于"+n);
    }
    public void stop(int m){
        System.out.println("Bike.stop()等于"+m);
    }
}

class Bus implements Vehicle{
    public void start(int n){
        System.out.println("Bus.start()等于"+n);
    }
    public void stop(int m){
        System.out.println("Bus.stop()等于"+m);
    }
}

public class interfaceDemo{
    public static void main(String[] args){
        Bus a = new Bus();
        a.start(1);a.stop(10);
        Bike b =  new Bike();
        b.start(0);b.stop(3);
    }
}