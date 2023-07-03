package br.senai.petshop;

import java.time.LocalDate;
import java.time.Month;
import java.util.Objects;

public class Pet {
	private Long id;
    private String nome;
    private String especie;
    private String raca;
    private String cor;
    private float peso;
    private LocalDate dataNascimento;
    private int idade;

    public Pet() {}

    public Pet(String nome, String especie, String raca, String cor, float peso, LocalDate dataNascimento) {
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.cor = cor;
        this.peso = peso;
        this.dataNascimento = dataNascimento;
        this.setIdade();
    }

    public Pet(Long id, String nome, String especie, String raca, String cor, float peso, LocalDate dataNascimento) {
    	this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.cor = cor;
        this.peso = peso;
        this.dataNascimento = dataNascimento;
        this.setIdade();
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getCor() {
        return cor;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
        setIdade();
    }
    
    public void setDataNascimento(String dataComoTexto) {
    	String[] data = dataComoTexto.split("-");
		int dia = Integer.parseInt(data[0]);
		Month mes = Month.of(Integer.parseInt(data[1]));
		int ano = Integer.parseInt(data[2]);
		
		this.dataNascimento = LocalDate.of(ano, mes, dia);
		setIdade();
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade() {
        this.idade = LocalDate.now().getYear() - dataNascimento.getYear();
    }


    @Override
	public int hashCode() {
		return Objects.hash(cor, dataNascimento, especie, id, idade, nome, peso, raca);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pet other = (Pet) obj;
		return Objects.equals(cor, other.cor) && Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(especie, other.especie) && Objects.equals(id, other.id) && idade == other.idade
				&& Objects.equals(nome, other.nome) && Float.floatToIntBits(peso) == Float.floatToIntBits(other.peso)
				&& Objects.equals(raca, other.raca);
	}

	@Override
    public String toString() {
        return "Pet{" +
        		"id=" + id +
                ", nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", raca='" + raca + '\'' +
                ", cor='" + cor + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", idade=" + idade +
                '}';
    }
}
