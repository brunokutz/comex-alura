package br.com.alura.comex.pedido.model;

import br.com.alura.comex.pedido.dto.ItemPedidoDto;
import br.com.alura.comex.produto.model.Produto;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "preco_unitario", nullable = false)
    private BigDecimal precoUnitario;

    @Column(nullable = false)
    private Integer quantidade;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pedido pedido;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produto produto;

    @Column(nullable = false)
    private BigDecimal desconto = BigDecimal.ZERO;
    @Enumerated(EnumType.STRING)
    private TipoDescontoItem tipoDesconto = TipoDescontoItem.NENHUM;

    public ItemPedido() {
        super();
    }

    public ItemPedido(Integer quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
        this.precoUnitario = produto.getPrecoUnitario();
    }

    public ItemPedido(Pedido pedido, Produto produto, ItemPedidoDto itemPedido) {
        this.precoUnitario = itemPedido.getValorUnitario();
        this.quantidade = itemPedido.getQuantidade();
        this.pedido = pedido;
        this.produto = produto;
        this.desconto = BigDecimal.valueOf(0);
    }

    public BigDecimal getValorTotalItem() {
        return this.precoUnitario.multiply(new BigDecimal(this.quantidade));
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Pedido getPedidoId() {
        return pedido;
    }

    public Produto getProdutoId() {
        return produto;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public TipoDescontoItem getTipoDesconto() {
        return tipoDesconto;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public void setTipoDesconto(TipoDescontoItem tipoDesconto) {
        this.tipoDesconto = tipoDesconto;
    }
}