package tom.service;

import tom.entity.common.AdminClass;
import tom.entity.common.Class;

public interface I_ClassService
{
    Class addClass(Class newClass);

    void deleteClass(String id);

    AdminClass addAdminClass(AdminClass newAdminClass);

    void deleteAdminClass(String id);

    String getFinalGrade(String oriGrade, String perfGrade);
}
