package com.etiqaassessment.DTO;

import java.util.List;

public class FetchDataDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private List<FamilyMemberDTO> familyMembers;
    private List<OrderDTO> orders;

    public FetchDataDTO(Integer id, String firstName, String lastName, String email, String phone,
                        List<FamilyMemberDTO> familyMembers, List<OrderDTO> orders) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.familyMembers = familyMembers;
        this.orders = orders;
    }

    public Integer getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public List<FamilyMemberDTO> getFamilyMembers() { return familyMembers; }
    public List<OrderDTO> getOrders() { return orders; }
}
