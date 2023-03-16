package com.example.prototypedesignpattern.Models;

import androidx.annotation.NonNull;

public class Computer implements Cloneable{
    private String os;
    private String office;
    private String antivirus;
    private String browser;
    private String others;
    private String department;

    public Computer(String os, String office, String antivirus, String browser, String others, String department) {
        this.os = os;
        this.office = office;
        this.antivirus = antivirus;
        this.browser = browser;
        this.others = others;
        this.department = department;
    }

    public Computer() {
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public void setAntivirus(String antivirus) {
        this.antivirus = antivirus;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOs() {
        return os;
    }

    public String getOffice() {
        return office;
    }

    public String getAntivirus() {
        return antivirus;
    }

    public String getBrowser() {
        return browser;
    }

    public String getOthers() {
        return others;
    }

    public String getDepartment() {
        return department;
    }

    @NonNull
    @Override
    public Computer clone() {
        try {
            return (Computer) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "os='" + os + '\'' +
                ", office='" + office + '\'' +
                ", antivirus='" + antivirus + '\'' +
                ", browser='" + browser + '\'' +
                ", others='" + others + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
