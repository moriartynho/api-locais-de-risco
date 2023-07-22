package locais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import locais.models.Local;

public interface LocalRepository extends JpaRepository<Local, Long> {

}
