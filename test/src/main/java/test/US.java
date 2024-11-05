package test;

public class US {
    private String gender;
    private String email;
    private String name;
    private String job;
    private String city;
    private String address;
    private String[] delivery;

    // Getter và Setter cho Gender
    public String getGender() {
        return gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    // Getter và Setter cho Email
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter và Setter cho Name
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    // Getter và Setter cho Job
    public String getJob() {
        return job;
    }
    
    public void setJob(String job) {
        this.job = job;
    }

    // Getter và Setter cho City
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }

    // Getter và Setter cho Address
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter và Setter cho Delivery Methods
    public String[] getDeliveryMethods() {
        return delivery;
    }
    
    public void setDelivery(String[] delivery) {
        this.delivery = delivery;
    }

    // Constructor có tham số
    public US(String name, String email, String gender, String[] delivery) {
        super();
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.delivery = delivery;  
    }

    // Constructor không có tham số
    public US() {
        super();
    }
}
