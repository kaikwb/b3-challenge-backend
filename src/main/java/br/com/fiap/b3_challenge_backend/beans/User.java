package br.com.fiap.b3_challenge_backend.beans;

public class User {
    private Integer id;
    private String name;
    private String cpf;
    private String postalCode;
    private String address;
    private String number;
    private String address2;
    private String neighborhood;
    private String city;
    private String state;

    public User() {
    }

    public User(Integer id, String name, String cpf, String postalCode, String address, String number, String address2, String neighborhood, String city, String state) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.postalCode = postalCode;
        this.address = address;
        this.number = number;
        this.address2 = address2;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
