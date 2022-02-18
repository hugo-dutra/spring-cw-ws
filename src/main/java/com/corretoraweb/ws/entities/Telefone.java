package com.corretoraweb.ws.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "telefone_tcl", schema = "corretora_web")
public class Telefone {
    @Id
    @Column(name = "tcl_id_int", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tcl_telefone_txt", length = 13)
    private String telefone;
    @Column(name = "tcl_whatsapp_bin")
    private Boolean isWhatsApp;
    @Column(name = "tcl_obsercacao_txt", length = 1000)
    private String observacao;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "clt_id_int", nullable = false)
    private Cliente cliente;
}
