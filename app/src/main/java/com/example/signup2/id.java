package com.example.signup2;

public class id {


    // string variable for
    // storing employee name.
    private String usid;
    private String p;

   // private String p1;
  //  private List<TankInfo> tanks;


    // an empty constructor is
    // required when using
    // Firebase Realtime Database.
    public id() {

    }
    public id(id i)
    {
        usid=i.usid;
        p=i.p;
    }

    // created getter and setter methods
    // for all our variables.
    public String getid() {
        return usid;
    }

    public void setuid(String usid) {
        this.usid = usid;
    }

    public void setpass(String p)
    {
        this.p=p;
    }

    /*public List<TankInfo> getTanks() {
        return tanks;
    }
    /public void setTanks(List<TankInfo> tanks) {
        this.tanks = tanks;
    }*/
}

