package demo;

public class User {
    private boolean gender; // Sửa đổi thành gender để rõ ràng hơn
    private String email;
    private String name;
    private String job;
    private String city;
    private String address;
    private String[] deliveryMethods; // Đổi tên biến

    public boolean isGender() {
        return gender;
    }
    
    public void setGender(boolean gender) {
        this.gender = gender;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getJob() {
        return job;
    }
    
    public void setJob(String job) {
        this.job = job;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String[] getDeliveryMethods() {
        return deliveryMethods;
    }
    
    public void setDeliveryMethods(String[] deliveryMethods) { // Đổi tên phương thức
        this.deliveryMethods = deliveryMethods;
    }
    
    public User() {
        super();
    }
}
