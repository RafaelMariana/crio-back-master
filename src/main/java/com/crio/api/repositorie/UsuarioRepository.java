package com.crio.api.repositorie;

import com.crio.api.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface UsuarioRepository extends
        JpaRepository<Usuario, UUID> {
    //selecionar todos os usuarios
    @Query("SELECT u FROM usuario u")
    List<Usuario> findAll();
    // selecionar um usuario pelo seu id
    @Query("SELECT u FROM usuario u WHERE u.id = :id")
    Optional<Usuario> findById(UUID id);
    //salvar um usuario
    @Query("INSERT INTO usuario(nomecompleto,email,senha,tipo,createdAt,updatedAt)" +
            " VALUES(:nomecompleto,:email,:senha,:tipo,:createdAt,:updatedAt)")
    Usuario save(String nomecompleto, String email, String senha, int tipo, LocalDateTime createdAt, LocalDateTime updatedAt);
    //atualizar usuario
    @Query("UPDATE usuario u SET u.nomecompleto=:nomecompleto,u.email=:email, u.senha=:senha, u.tipo=:tipo u.updateAt=:updateAt,"+
    "WHERE u.id=:id")
    void update(UUID id,String nomecompleto, String email, String senha, int tipo, LocalDateTime updatedAt)
    //deletar usuario
    @Query("DELETE FROM usuario u WHERE u.id=:id")
    void deleteById(UUID id);

}
