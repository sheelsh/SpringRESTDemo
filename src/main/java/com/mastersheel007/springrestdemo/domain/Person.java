package com.mastersheel007.springrestdemo.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 *
 * @author mastersheel007
 */
@Entity
@Table(name = "PERSON")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PERSON_ID", nullable = false)
    private Long personId;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "CREATION_TIME", nullable = false)
    private Date creationTime;

    @Column(name = "MODIFICATION_TIME", nullable = false)
    private Date modificationTime;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    @PrePersist
    public void setCreationTime() {
        this.creationTime = new Date();
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    @PreUpdate
    public void setModificationTime() {
        this.modificationTime = new Date();
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}