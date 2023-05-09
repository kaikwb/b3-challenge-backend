package br.com.fiap.b3_challenge_backend.beans;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String mail;
    private String password;
    private String postalCode;
    private String address;
    private String addressNumber;
    private String address2;
    private String neighborhood;
    private String city;
    private String state;

    /**
     * Cria um usuário sem dados.
     */
    public User() {
    }

    /**
     * Cria um usuário com dados.
     *
     * @param id            identificador do usuário.
     * @param firstName     nome do usuário.
     * @param lastName      sobrenome do usuário.
     * @param mail          e-mail do usuário.
     * @param password      senha do usuário.
     * @param postalCode    código postal do usuário.
     * @param address       endereço do usuário.
     * @param addressNumber número do endereço do usuário.
     * @param address2      complemento do endereço do usuário.
     * @param neighborhood  bairro do usuário.
     * @param city          cidade do usuário.
     * @param state         estado do usuário.
     */
    public User(Integer id, String firstName, String lastName, String mail, String password, String postalCode, String address, String addressNumber, String address2, String neighborhood, String city, String state) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        this.password = password;
        this.postalCode = postalCode;
        this.address = address;
        this.addressNumber = addressNumber;
        this.address2 = address2;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
    }

    /**
     * Retorna o identificador do usuário.
     *
     * @return identificador do usuário.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o identificador do usuário.
     *
     * @param id identificador do usuário.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Retorna o nome do usuário.
     *
     * @return nome do usuário.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Define o nome do usuário.
     *
     * @param firstName nome do usuário.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retorna o sobrenome do usuário.
     *
     * @return sobrenome do usuário.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Define o sobrenome do usuário.
     *
     * @param lastName sobrenome do usuário.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retorna o e-mail do usuário.
     *
     * @return e-mail do usuário.
     */
    public String getMail() {
        return mail;
    }

    /**
     * Define o e-mail do usuário.
     *
     * @param mail e-mail do usuário.
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * Retorna a senha do usuário.
     *
     * @return senha do usuário.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define a senha do usuário.
     *
     * @param password senha do usuário.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retorna o código postal do usuário.
     *
     * @return código postal do usuário.
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Define o código postal do usuário.
     *
     * @param postalCode código postal do usuário.
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * Retorna o endereço do usuário.
     *
     * @return endereço do usuário.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Define o endereço do usuário.
     *
     * @param address endereço do usuário.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Retorna o número do endereço do usuário.
     *
     * @return número do endereço do usuário.
     */
    public String getAddressNumber() {
        return addressNumber;
    }

    /**
     * Define o número do endereço do usuário.
     *
     * @param addressNumber número do endereço do usuário.
     */
    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    /**
     * Retorna o complemento do endereço do usuário.
     *
     * @return complemento do endereço do usuário.
     */
    public String getAddress2() {
        return address2;
    }

    /**
     * Define o complemento do endereço do usuário.
     *
     * @param address2 complemento do endereço do usuário.
     */
    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    /**
     * Retorna o bairro do usuário.
     *
     * @return bairro do usuário.
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * Define o bairro do usuário.
     *
     * @param neighborhood bairro do usuário.
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * Retorna a cidade do usuário.
     *
     * @return cidade do usuário.
     */
    public String getCity() {
        return city;
    }

    /**
     * Define a cidade do usuário.
     *
     * @param city cidade do usuário.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Retorna o estado do usuário.
     *
     * @return estado do usuário.
     */
    public String getState() {
        return state;
    }

    /**
     * Define o estado do usuário.
     *
     * @param state estado do usuário.
     */
    public void setState(String state) {
        this.state = state;
    }
}
