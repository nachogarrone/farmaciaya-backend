package com.farmaciaya.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by nachogarrone on 20/10/15.
 */
@Entity
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer compra_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private Date date;
    private Integer total;
    @ManyToOne
    @JoinColumn(name = "farmacia_id")
    private Farmacia farmacia;
    @OneToMany
    @JoinTable(name = "compra_articulos",
            joinColumns={@JoinColumn(name="compra_id", referencedColumnName="compra_id")},
            inverseJoinColumns={@JoinColumn(name="medicamento_id", referencedColumnName="medicamento_id")})
    private List<Medicamento> medicamentos;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCompra_id() {
        return compra_id;
    }

    public void setCompra_id(Integer compra_id) {
        this.compra_id = compra_id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Farmacia getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(Farmacia farmacia) {
        this.farmacia = farmacia;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }
}
