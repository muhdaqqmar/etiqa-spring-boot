package com.etiqaassessment.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Setter
@Getter
@Entity
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long family_member_id;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name="customer_id")
    private Customer customer;
    private String name;
    private String relation;

    public FamilyMember() {
    }

    public FamilyMember(String name, Long family_member_id, Customer customer, String relation) {
        this.name = name;
        this.family_member_id = family_member_id;
        this.customer = customer;
        this.relation = relation;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FamilyMember that = (FamilyMember) o;
        return Objects.equals(family_member_id, that.family_member_id) && Objects.equals(customer, that.customer) && Objects.equals(name, that.name) && Objects.equals(relation, that.relation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(family_member_id, customer, name, relation);
    }
}
