package Mini_projects.bus_reservation;

public class Bus {
    int busNO;
    boolean ac;
    int capacity;

    Bus(int no, boolean ac, int cap) {
        this.busNO= no;
        this.ac= ac;
        this.capacity = cap;
    }
    public int getCapacity() {
        return capacity;
    }
    public  int getBusNO(){
        return busNO;
    }
    public void setAC(boolean value) {
        ac= value;
    }
    public void setCapacity(int cap) {
        capacity= cap;
    }
    public void displayBusInfo(){
        System.out.println("Bus No: "+busNO + " AC: "+ac + " Total Capacity: "+capacity);
    }

}
