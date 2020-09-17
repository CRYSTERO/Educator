package tom.entity.enums;

public enum CertificateClass
{
    NATIONAL_ID_CARD("中华人民共和国居民身份证"),
    SAR_ID_CARD("香港/澳门特别行政区身份证"),
    PERMANENT_RESIDENCE_CARD("外国人永久居留证"),
    PASSPORT("护照");

    private final String certificateClass;

    CertificateClass(String certificateClass)
    {
        this.certificateClass = certificateClass;
    }
    public static CertificateClass parseCertificate(String s)
    {
        switch (s)
        {
            case " PASSPORT" :
            {
                return PASSPORT;
            }
            case "SAR_ID_CARD" :
            {
                return SAR_ID_CARD;
            }
            case "PERMANENT_RESIDENCE_CARD" :
            {
                return PERMANENT_RESIDENCE_CARD;
            }
            default:
            {
                return  NATIONAL_ID_CARD;
            }
        }
    }

    public String getCertificateClass()
    {
        return certificateClass;
    }

    @Override
    public String toString()
    {
        return "Certificate{" +
                "certificateClass='" + certificateClass + '\'' +
                '}';
    }
}
