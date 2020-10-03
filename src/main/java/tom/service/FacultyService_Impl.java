package tom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tom.DAO.FacultyRepository;
import tom.entity.faculty.Faculty;
import tom.util.MD5Utils;

import java.util.List;

@Service
public class FacultyService_Impl implements I_FacultyService
{
    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public Faculty addFaculty(Faculty faculty)
    {
        faculty.setId();
        faculty.setUsername();
        String CertId = faculty.getPersonalInfo().getCertificate().getCertificateId();
        String oriPassword = MD5Utils.stringToMD5(CertId.substring(CertId.length() - 6));
        faculty.setPassword(oriPassword);
        return facultyRepository.save(faculty);
    }

    @Override
    public List<Faculty> getAllFaculties()
    {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty checkIdentity(String id, String password)
    {
        return facultyRepository.findByIdAndPassword(id, MD5Utils.stringToMD5(password));
    }
}
