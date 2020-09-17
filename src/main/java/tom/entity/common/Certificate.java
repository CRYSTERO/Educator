package tom.entity.common;

import tom.entity.enums.CertificateClass;

public class Certificate
{
    private CertificateClass certificateClass;
    private String certificateId;

    public Certificate()
    {
    }

    public CertificateClass getCertificateClass()
    {
        return certificateClass;
    }

    public void setCertificateClass(CertificateClass certificateClass)
    {
        this.certificateClass = certificateClass;
    }

    public String getCertificateId()
    {
        return certificateId;
    }

    public void setCertificateId(String certificateId)
    {
        this.certificateId = certificateId;
    }
}
