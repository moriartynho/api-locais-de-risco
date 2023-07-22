package mantimentos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import mantimentos.models.PontoDeMantimentos;

public interface PontoDeMantimentosRepository extends JpaRepository<PontoDeMantimentos, Long> {

}
