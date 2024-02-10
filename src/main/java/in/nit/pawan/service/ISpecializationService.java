package in.nit.pawan.service;

import java.util.List;

import in.nit.pawan.entity.Specialization;

public interface ISpecializationService {
	public Long saveSpecialization(Specialization spec);
    public List<Specialization> getAllSpecialization();
    public void removeSpecialization(Long id);
    public Specialization getOneSpecialization(Long id);
    public void updateSpecialization(Specialization spec);
    
    
    
    
    
}
