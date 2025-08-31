package com.etiqaassessment.DTO;

public class FamilyMemberDTO {
    private Long id;
    private String name;
    private String relation;

    public FamilyMemberDTO(Long id, String name, String relation) {
        this.id = id;
        this.name = name;
        this.relation = relation;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getRelation() { return relation; }
}
