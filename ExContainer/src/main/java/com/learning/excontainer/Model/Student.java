package com.learning.excontainer.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private int stdid;
    private String stdname;
    private String stdemail;
    private String stdclass;

    public Student() {
    }

    public Student(int stdid, String stdname, String stdemail, String stdclass) {
        this.stdid = stdid;
        this.stdname = stdname;
        this.stdemail = stdemail;
        this.stdclass = stdclass;
    }

    public int getStdid() {
        return stdid;
    }

    public void setStdid(int stdid) {
        this.stdid = stdid;
    }

    public String getStdname() {
        return stdname;
    }

    public void setStdname(String stdname) {
        this.stdname = stdname;
    }

    public String getStdemail() {
        return stdemail;
    }

    public void setStdemail(String stdemail) {
        this.stdemail = stdemail;
    }

    public String getStdclass() {
        return stdclass;
    }

    public void setStdclass(String stdclass) {
        this.stdclass = stdclass;
    }
}
