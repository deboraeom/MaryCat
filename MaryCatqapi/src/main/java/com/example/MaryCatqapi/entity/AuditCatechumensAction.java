package com.example.MaryCatqapi.entity;


import javax.persistence.*;

@Entity(name = "auditCatechumensActions")
@Table(name = "audit_catechumens_actions")
public class AuditCatechumensAction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "catechumens_id")
     private Long catechumens_id;

    @Column(name = "catechists_users_id")
    private Long catechists_users_id;

    @Column(name = "catechists_churches_id")
    private Long catechists_churches_id;

    @Column(name = "description")
    private String description;


}
