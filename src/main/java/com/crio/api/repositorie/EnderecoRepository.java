package com.crio.api.repositorie;

import com.crio.api.domain.endereco.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID> {

    @Query("SELECT e FROM Endereco WHERE e.cidade =:cidade")
    List<Endereco> findByCidade(@Param("cidade") String cidade);

    @Query("SELECT e FROM endereco WHERE e.uf =:uf")
    List<Endereco> findByUf(@Param("uf") String uf);


}
