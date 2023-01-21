import java.util.Iterator;

import java.util.NoSuchElementException;

public class Fila<Item> implements Iterable<Item>  {
	private Pessoa first;  //inicio da fila
	private Pessoa last; //final da fila
	private Pessoa novo; //no prioridade q vai ser adicionado
	private int tamanho;
	private int quantp;
	private int quantn;
	private int atenPrioridade;
	private int atenNormal;
		
	public Fila() {
		first = null;
		last = null;
		novo = null;
		tamanho = 0;
	}
		
	public boolean isEmpty() {
		return first==null;
	}
		
	public int size() {
		return tamanho;
	}
		
	public void enqueue(Pessoa el) {
		Pessoa aux = last;
		last=el;
		last.next = null;
		if(isEmpty()) first = last;
		else aux.next=last;
		tamanho++;
		quantn++;
	}
		
	public void enqueuep(Pessoa el) {
		Pessoa percorre = first;
		Pessoa x = first;
		while(percorre != null) {
			if(el.idade>percorre.idade) {
				break;
			}
			x = percorre;
			percorre = percorre.next;
		}
		novo=el;
		novo.next = percorre;
		if(isEmpty()) {
			first = last = novo;
		}
		else {
			if(percorre==first) {
				first=novo;
				novo.next = percorre;
			}
			else{
				x.next=novo;
			}
		}
		tamanho++;
		quantp++;
	}


	public Pessoa dequeue() {
		if(isEmpty()) throw new NoSuchElementException("Queue underflow");
		int idadeAux = first.idade;
		String auxNome = first.nome;
		Pessoa aux = new Pessoa(auxNome,idadeAux);
		first = first.next;
		tamanho--;
		if(isEmpty()) last = null;
		if(aux.idade>=60) atenPrioridade++;
		else atenNormal++;
		return aux;
	}
		
	public int atendimentoNormal() {
		int porcentagem;
		porcentagem = (atenNormal*100)/quantn;
		return porcentagem;
	}
		
	public int atendimentoPrioridade() {
		int porcentagem;
		porcentagem = (atenPrioridade*100)/quantp;
		return porcentagem;
	}
		
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(Item item : this) {
			builder.append(item);
			builder.append(",");
		}
		return builder.toString();
	}
		
	public Iterator<Item> iterator() {
		return (Iterator<Item>) new EncadeadaIterator(first);
	}
		
	private class EncadeadaIterator implements Iterator<Pessoa>{
			
		private Pessoa percorrer;
			
		public EncadeadaIterator(Pessoa first) {
			percorrer = first;
		}
			
		public boolean hasNext() {
			return percorrer != null;
		}
			
		public void remove() {
			if(isEmpty()) throw new UnsupportedOperationException(); 
		}
			
		public Pessoa next() {
			if(!hasNext()) throw new NoSuchElementException();
			int elIdade = percorrer.idade;
			String elNome = percorrer.nome;
			percorrer = percorrer.next;
			Pessoa el = new Pessoa(elNome, elIdade);
			return el;
		}
			
	}
}
