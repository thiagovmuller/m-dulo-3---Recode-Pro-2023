package model;

public class Passagem {
   
    private Integer idPassagem;
    private String ciaAerea;
    private Float valor;
    private String origem;
    private String destino;
    

    public Passagem() {
	}

	public Passagem(String ciaAerea, String origem, String destino, Float valor) {
		this.ciaAerea = ciaAerea;
		this.origem = origem;
		this.destino = destino;
		this.valor = valor;
	}
    
    public Passagem(Integer idPassagem, String ciaAerea, String origem, String destino, Float valor) {
		this.idPassagem = idPassagem;
		this.ciaAerea = ciaAerea;
		this.valor = valor;
		this.origem = origem;
		this.destino = destino;
	}




	public Integer getIdPassagem() {
        return this.idPassagem;
    }
    
    public void setIdPassagem(Integer idPassagem) {
        this.idPassagem = idPassagem;
    }
    
    public String getCiaAerea() {
        return this.ciaAerea;
    }
   
    public void setCiaAerea(String ciaAerea) {
        this.ciaAerea = ciaAerea;
    }
   
    public Float getValor() {
        return this.valor;
    }
   
    public void setValor(Float valor) {
        this.valor = valor;
    }
    
    public String getOrigem() {
        return this.origem;
    }
   
    public void setOrigem(String origem) {
        this.origem = origem;
    }
   
    public String getDestino() {
        return this.destino;
    }
 
    public void setDestino(String destino) {
        this.destino = destino;
    }
    
  //toString
  	@Override
  	public String toString() {
  		return "Passagem [id="+ idPassagem + ", ciaAerea=" + ciaAerea + ", origem=" + origem + ", destino=" + destino + ", valor=" + valor+"]";
  	}
    
}
