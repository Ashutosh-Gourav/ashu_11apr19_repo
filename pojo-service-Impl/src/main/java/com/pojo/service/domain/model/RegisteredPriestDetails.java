package com.pojo.service.domain.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.sql.Blob;
import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisteredPriestDetails {
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private float registeredLatitude;
    private float registeredLongitude;
    private String lang;
    private Date dob;
    private int experience;
    private String proofId;
    private String idProofType;
    private Blob idImage;
    private String status;
    private Blob priestImage;
    private String priestPassword;
    private boolean isVerified;
    private String priestEmail;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getRegisteredLatitude() {
        return registeredLatitude;
    }

    public void setRegisteredLatitude(float registeredLatitude) {
        this.registeredLatitude = registeredLatitude;
    }

    public float getRegisteredLongitude() {
        return registeredLongitude;
    }

    public void setRegisteredLongitude(float registeredLongitude) {
        this.registeredLongitude = registeredLongitude;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getProofId() {
        return proofId;
    }

    public void setProofId(String proofId) {
        this.proofId = proofId;
    }

    public String getIdProofType() {
        return idProofType;
    }

    public void setIdProofType(String idProofType) {
        this.idProofType = idProofType;
    }

    public Blob getIdImage() {
        return idImage;
    }

    public void setIdImage(Blob idImage) {
        this.idImage = idImage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Blob getPriestImage() {
        return priestImage;
    }

    public void setPriestImage(Blob priestImage) {
        this.priestImage = priestImage;
    }

    public String getPriestPassword() {
        return priestPassword;
    }

    public void setPriestPassword(String priestPassword) {
        this.priestPassword = priestPassword;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }

    public String getPriestEmail() {
        return priestEmail;
    }

    public void setPriestEmail(String priestEmail) {
        this.priestEmail = priestEmail;
    }
}
