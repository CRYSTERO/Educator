package tom.entity.enums;

public enum Gender
{
    MALE,
    FEMALE;

    public static Gender parseGender(String string)
    {
        if(string.equals("MALE")) return MALE;
        else return FEMALE;
    }
}
