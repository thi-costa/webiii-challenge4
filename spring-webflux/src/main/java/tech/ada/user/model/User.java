package tech.ada.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Document
public class User {

    @Id
    private String id;

    private String name;
    private String username;
    private List<String> roles;
    private Long birth;
    private LocalDate since;
    private Double balanco;

    public User pagar(User user, Comprovante comprovante){
        this.balanco -= comprovante.getValor();
        user.balanco += comprovante.getValor();
        comprovante.setAck_usuario(true);
        return this;
    }

    public User(){
        this.balanco = 0.0d;
    }

    public User update(User usuario) {
        // id, username and since not permited changing
        this.setName(usuario.name);
        this.setBirth(usuario.birth);
        this.setRoles(usuario.getRoles());
        this.setSince(usuario.since);
        return this;
    }



}