package in.nit.pawan.specialization;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import in.nit.pawan.entity.Specialization;
import in.nit.pawan.repo.SpecializationRepository;

@DataJpaTest(showSql = true)
@Rollback(false)
@SpringBootTest
public class SpecializationRepositoryTest {
	
	@Autowired
	private SpecializationRepository repo;
	
	/**
	 * 1.  Test save operation
	 */
	public void testSpecCreate() {
		Specialization spec = new Specialization(null, "CRDLS", "Cardiologists", "They are expert in heart");
		spec = repo.save(spec);
		assertNotNull(spec.getId(), "Spec is not created !");
		
	}
	
	/**
	 * 2. Test display all operation
	 */

}
