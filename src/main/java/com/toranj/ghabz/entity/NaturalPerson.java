package com.toranj.ghabz.entity;

import com.toranj.ghabz.utils.DateConverter;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;
import java.util.Date;

@Entity
@Table(name = "tb_natural_person", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"}),@UniqueConstraint(columnNames = {"national_id"})})
public class NaturalPerson {
    private static final long serialVersionUID = 2054386655979281715L;

    @Id
    @Column(name = "id", length = 50, nullable = false)
    private String id;
    @Column(name = "national_id", length = 20, nullable = false)
    private String nationalId;
    @Column(name = "mobile_number", length = 20, nullable = false)
    private String mobileNumber;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "family", length = 50)
    private String family;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "father_name", length = 50)
    private String fatherName;
    @Column(name = "gender", length = 20)
    private String gender;
    @Column(name = "phoneNumber", length = 50)
    private String phoneNumber;
    @Lob
    @Column(name = "image", length = Integer.MAX_VALUE)
    private byte[] image;
    @Transient
    private String sImage;
    @Transient
    private CommonsMultipartFile fileData;
    @Column(name = "creationDate", nullable = false)
    private Date creationDate;
    @Column(name = "is_active", length = 20)
    private boolean isActive;
    @Column(name = "profileCompletionStatus")
    private boolean profileCompletionStatus;
    @Transient
    private String persianBirthDate;
    @Transient
    private String message;

    public NaturalPerson() {
    }

    public NaturalPerson(String id, String nationalId, String mobileNumber, boolean isActive) {
        this.id = id;
        this.nationalId = nationalId;
        this.mobileNumber = mobileNumber;
        this.isActive = isActive;
    }

    public NaturalPerson(String id, String nationalId, String mobileNumber, String name, String family, Date birthDate, boolean isActive) {
        this.id = id;
        this.nationalId = nationalId;
        this.mobileNumber = mobileNumber;
        this.name = name;
        this.family = family;
        this.birthDate = birthDate;
        this.isActive = isActive;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getsImage() {
        String sImage = null;
        if(getImage() != null) {
            sImage = Base64.getEncoder().encodeToString(getImage());
        } else {
             try {
                    String filePath = getClass().getClassLoader().getResource("img2/4.png").getFile();
                    BufferedImage bImage = ImageIO.read(new File(filePath));
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    ImageIO.write(bImage, "png", bos);
                    byte[] data = bos.toByteArray();
                    sImage = Base64.getEncoder().encodeToString(data);

                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        return sImage;
    }

    public void setsImage(String sImage) {
        this.sImage = sImage;
    }

    public CommonsMultipartFile getFileData() {
        return fileData;
    }

    public void setFileData(CommonsMultipartFile fileData) {
        this.fileData = fileData;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isProfileCompletionStatus() { return profileCompletionStatus; }

    public void setProfileCompletionStatus(boolean profileCompletionStatus) { this.profileCompletionStatus = profileCompletionStatus; }

    public String getPersianBirthDate() {
        if(this.getBirthDate() != null) {
          persianBirthDate = DateConverter.convertGregorianToJalaliCalendar(this.getBirthDate());
        }
        return persianBirthDate; }

    public void setPersianBirthDate(String persianBirthDate) { this.persianBirthDate = persianBirthDate; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }
}