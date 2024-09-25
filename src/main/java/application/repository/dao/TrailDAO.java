package application.repository.dao;

import application.repository.entity.Trail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrailDAO extends JpaRepository<Trail, Long>, JpaSpecificationExecutor<Trail> {
    @Override
    Page<Trail> findAll(Specification<Trail> spec, Pageable pageable);
}
