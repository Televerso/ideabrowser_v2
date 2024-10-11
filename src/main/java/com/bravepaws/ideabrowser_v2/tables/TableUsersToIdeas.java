package com.bravepaws.ideabrowser_v2.tables;

import jakarta.persistence.*;

@Entity
@Table(name = "users to ideas")
public class TableUsersToIdeas implements BaseTable{
    private int utiid;
    private int ideaid;
    private int userid;

    public TableUsersToIdeas() {}

    public TableUsersToIdeas(int ideaid, int userid)
    {
        this.ideaid = ideaid;
        this.userid = userid;
    }

    @Id
    @Column(name = "UTIID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "UTI_ID_GEN")
    @SequenceGenerator(name = "UTI_ID_GEN", sequenceName = "users_to_ideas_pk", allocationSize = 1)
    public int getUtiId()
    {
        return utiid;
    }
    public void setUtiId(int utiid)
    {
        this.utiid = utiid;
    }

    @Basic
    @Column(name = "USER ID")
    public int getUserid()
    {
        return userid;
    }
    public void setUserid(int userid)
    {
        this.userid = userid;
    }

    @Basic
    @Column(name = "IDEA ID")
    public int getIdeaid()
    {
        return ideaid;
    }
    public void setIdeaid(int ideaid)
    {
        this.ideaid = ideaid;
    }

}
