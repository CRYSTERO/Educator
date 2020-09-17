package tom.entity.common;

import tom.entity.enums.Gender;

public class Personal_Info
{
    private String familyName;
    private String givenName;
    private Gender gender;
    private Integer age;
    private Certificate certificate;
    private String birthPlace;
    private String photo;

    public Personal_Info(){}

    public String getFamilyName()
    {
        return familyName;
    }

    public void setFamilyName(String familyName)
    {
        this.familyName = familyName;
    }

    public String getGivenName()
    {
        return givenName;
    }

    public void setGivenName(String givenName)
    {
        this.givenName = givenName;
    }

    public Gender getGender()
    {
        return gender;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public Certificate getCertificate()
    {
        return certificate;
    }

    public void setCertificate(Certificate certificate)
    {
        this.certificate = certificate;
    }

    public String getBirthPlace()
    {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace)
    {
        this.birthPlace = birthPlace;
    }

    public String getPhoto()
    {
        return photo;
    }

    public void setPhoto(String photo)
    {
        this.photo = photo;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }



    @Override
    public String toString()
    {
        return "Personal_Info{" +
                "familyName='" + familyName + '\'' +
                ", givenName='" + givenName + '\'' +
                ", gender=" + gender +
                ", certificate=" + certificate +
                ", birthPlace='" + birthPlace + '\'' +
                '}';
    }
}
