package com.bravepaws.ideabrowser_v2.tables;

import jakarta.persistence.*;


@Entity
@Table(name = "ideas")
public class TableIdeas implements BaseTable {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ideaid;
    private String ideaName;
    private String Description;
    private String Category;
    private int Customer;
    private String Status;
    private int IdeaTheme;

    public TableIdeas() {
    }

    public TableIdeas(String ideaName, int customer, String status) {
        this.ideaName = ideaName;
        this.Customer = customer;
        this.Status = status;
        this.IdeaTheme = 0;
        this.Description = "";
        this.Category = "None";
    }

    public TableIdeas(String ideaName, String Description, String Category, int Customer, String Status, int IdeaTheme) {
        this.ideaName = ideaName;
        this.Description = Description;
        this.Category = Category;
        this.Customer = Customer;
        this.Status = Status;
        this.IdeaTheme = IdeaTheme;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "IDEA_ID_GEN")
    @SequenceGenerator(name = "IDEA_ID_GEN", sequenceName = "ideas_seq", allocationSize = 1)
    @Column(name = "IDEAID", nullable = false)
    public int getIdeaId() {
        return this.ideaid;
    }

    public void setIdeaId(int ideaid) {
        this.ideaid = ideaid;
    }

    @Basic
    @Column(name = "IDEA NAME")
    public String getIdeaName() {
        return ideaName;
    }

    public void setIdeaName(String ideaName) {
        this.ideaName = ideaName;
    }

    @Basic
    @Column(name = "CATEGORY")
    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        this.Category = category;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    @Basic
    @Column(name = "CUSTOMER")
    public int getCustomer() {
        return Customer;
    }

    public void setCustomer(int customer) {
        this.Customer = customer;
    }

    @Basic
    @Column(name = "IDEA THEME")
    public int getIdeaTheme() {
        return IdeaTheme;
    }

    public void setIdeaTheme(int ideaTheme) {
        this.IdeaTheme = ideaTheme;
    }

    @Basic
    @Column(name = "STATUS")
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }
}

