package tom.entity.common;

public class Grade
{
    private Integer examGrade;
    private Integer extraGrade;
    private Integer experGrade;
    private Integer finalGrade;
    private Boolean hasBeenUploaded;

    public Grade(){}

    public Integer getExamGrade()
    {
        return examGrade;
    }

    public void setExamGrade(Integer examGrade)
    {
        this.examGrade = examGrade;
    }

    public Integer getExtraGrade()
    {
        return extraGrade;
    }

    public void setExtraGrade(Integer extraGrade)
    {
        this.extraGrade = extraGrade;
    }

    public Integer getExperGrade()
    {
        return experGrade;
    }

    public void setExperGrade(Integer experGrade)
    {
        this.experGrade = experGrade;
    }

    public Integer getFinalGrade()
    {
        return finalGrade;
    }

    public void setFinalGrade(Integer finalGrade)
    {
        this.finalGrade = finalGrade;
    }

    public Boolean getHasBeenUploaded()
    {
        return hasBeenUploaded;
    }

    public void setHasBeenUploaded(Boolean hasBeenUploaded)
    {
        this.hasBeenUploaded = hasBeenUploaded;
    }
}
