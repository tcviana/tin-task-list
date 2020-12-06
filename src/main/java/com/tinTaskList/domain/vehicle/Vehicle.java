package com.tinTaskList.domain.vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VEHICLE")
@Getter
@Setter
@NoArgsConstructor
public class Vehicle {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_seq")
    private long id;

    @Column(name = "veiculo")
    private String veiculo;

    @Column(name = "marca")
    @Enumerated(EnumType.STRING)
    private Marca marca;

    @Column(name = "ano")
    private int ano;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "vendido")
    private boolean vendido;

    @CreatedDate
    @Column(name = "created")
    private Date created;

    @LastModifiedDate
    @Column(name = "updated")
    private Date updated;

    public Vehicle(String veiculo, Marca marca, int ano, String descricao, boolean vendido) {
        this.veiculo = veiculo;
        this.marca = marca;
        this.ano = ano;
        this.descricao = descricao;
        this.vendido = vendido;
    }
}
