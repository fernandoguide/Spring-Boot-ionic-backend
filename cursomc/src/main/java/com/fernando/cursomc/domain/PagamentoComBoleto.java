package com.fernando.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fernando.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto  extends Pagamento{ 
	
	private static final long serialVersionUID = 1L;
	
	 private Date  dataVencimento;
	 private Date  dataPagamento;
	 
	 public PagamentoComBoleto()	{
		 
	 }

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento , Date dataPagamento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	 

}
