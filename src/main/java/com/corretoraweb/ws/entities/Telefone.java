package com.corretoraweb.ws.entities;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "telefone_tcl")
public class Telefone {
    @Id
    @Column(table = "tcl_id_int")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tcl_telefone_txt", length = 13)
    private String telefone;
    @Column(name = "tcl_whatsapp_bin")
    private Boolean isWhatsApp;
    @Column(name = "tcl_obsercacao_txt", length = 1000)
    private String observacao;
    @ManyToOne
    @JoinColumn(name = "clt_id_int", nullable = false)
    private Cliente cliente;


}
